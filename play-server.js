// OOPverse Web UI Runner - Backend (Node.js + Express)
// Install: npm install express ws node-pty
// Run: npm start OR node play-server.js
// Then open: http://localhost:3000
//
// Two run modes are supported:
//   1) Judge style   -> POST /api/run          (all stdin supplied upfront, one-shot response)
//   2) Interactive   -> WebSocket /ws/run       (real PTY, live streaming in/out, like a real terminal)

const express = require('express');
const { exec, spawn } = require('child_process');
const fs = require('fs');
const path = require('path');
const http = require('http');
const WebSocket = require('ws');
const pty = require('node-pty');

const app = express();
const PORT = 3000;
const ROOT_DIR = __dirname;

app.use(express.json());

// Serve index.html from root as fallback
app.get('/', (req, res) => {
    const indexPath = path.join(ROOT_DIR, 'index.html');
    if (fs.existsSync(indexPath)) {
        res.sendFile(indexPath);
    } else {
        res.status(404).send('index.html not found');
    }
});

// Try to serve from public folder if it exists
app.use(express.static(path.join(ROOT_DIR, 'public'), { fallthrough: true }));
// Also serve from root
app.use(express.static(ROOT_DIR, { fallthrough: true }));

// Get all modules
app.get('/api/modules', (req, res) => {
    fs.readdir(ROOT_DIR, { withFileTypes: true }, (err, files) => {
        if (err) return res.status(500).json({ error: err.message });

        const modules = files
            .filter(f => f.isDirectory() && /^\d{2}_/.test(f.name))
            .map(f => ({
                name: f.name,
                displayName: f.name.replace(/_/g, ' ')
            }))
            .sort((a, b) => a.name.localeCompare(b.name));

        res.json(modules);
    });
});

// Get files in a module for a specific language
app.get('/api/modules/:moduleName/:language', (req, res) => {
    const { moduleName, language } = req.params;
    const langDir = path.join(ROOT_DIR, moduleName, language);

    if (!fs.existsSync(langDir)) {
        return res.json([]);
    }

    fs.readdir(langDir, (err, files) => {
        if (err) return res.json([]);

        const ext = language === 'cpp' ? '.cpp' : '.java';
        const sourceFiles = files
            .filter(f => f.endsWith(ext))
            .sort();

        res.json(sourceFiles);
    });
});

// Get code preview for a file
app.get('/code/:module/:language/:file', (req, res) => {
    const { module, language, file } = req.params;
    const filePath = path.join(ROOT_DIR, module, language, file);

    if (!fs.existsSync(filePath)) {
        return res.status(404).send('File not found');
    }

    fs.readFile(filePath, 'utf-8', (err, data) => {
        if (err) {
            return res.status(500).send('Error reading file');
        }
        res.type('text/plain').send(data);
    });
});

// ---------------------------------------------------------------------------
// JUDGE-STYLE RUN — all stdin supplied upfront, single JSON response
// ---------------------------------------------------------------------------
app.post('/api/run', (req, res) => {
    const { moduleName, language, fileName, input } = req.body;
    const filePath = path.join(ROOT_DIR, moduleName, language, fileName);

    if (!fs.existsSync(filePath)) {
        return res.json({ success: false, error: 'File not found: ' + filePath, output: '' });
    }

    const workDir = path.dirname(filePath);
    const stdinData = (input || '') + '\n';

    let compileCmd, runCmdName, runArgs;
    if (language === 'cpp') {
        const outFile = fileName.replace('.cpp', '.exe');
        compileCmd = `g++ -std=c++17 -o "${outFile}" "${fileName}"`;
        runCmdName = path.join(workDir, outFile);
        runArgs = [];
    } else {
        const className = fileName.replace('.java', '');
        compileCmd = `javac "${fileName}"`;
        runCmdName = 'java';
        runArgs = [className];
    }

    exec(compileCmd, { cwd: workDir, timeout: 15000, shell: 'cmd.exe', maxBuffer: 10 * 1024 * 1024 }, (compileErr, _stdout, compileStderr) => {
        if (compileErr) {
            return res.json({ success: false, output: '', error: compileStderr || compileErr.message });
        }

        const child = spawn(runCmdName, runArgs, { cwd: workDir, shell: true, timeout: 15000 });
        let stdout = '', stderr = '', timedOut = false;

        const killTimer = setTimeout(() => {
            timedOut = true;
            child.kill();
        }, 15000);

        child.stdout.on('data', d => stdout += d);
        child.stderr.on('data', d => stderr += d);
        child.stdin.write(stdinData);
        child.stdin.end();

        child.on('close', (code) => {
            clearTimeout(killTimer);
            cleanupArtifacts(language, workDir, fileName);
            if (timedOut) {
                return res.json({ success: false, output: stdout, error: '⏱️ Program execution timeout (15 seconds exceeded) — it may be waiting for more input than you provided.' });
            }
            res.json({ success: code === 0, output: stdout, error: stderr, fileName });
        });

        child.on('error', (err) => {
            clearTimeout(killTimer);
            res.json({ success: false, output: '', error: err.message });
        });
    });
});

function cleanupArtifacts(language, workDir, fileName) {
    if (language === 'cpp') {
        fs.unlink(path.join(workDir, fileName.replace('.cpp', '.exe')), () => {});
    } else {
        fs.readdir(workDir, (e, files) => {
            if (!e) files.filter(f => f.endsWith('.class')).forEach(f => fs.unlink(path.join(workDir, f), () => {}));
        });
    }
}

// ---------------------------------------------------------------------------
// INTERACTIVE RUN — real PTY over WebSocket, live streaming both ways
// ---------------------------------------------------------------------------
const server = http.createServer(app);
const wss = new WebSocket.Server({ server, path: '/ws/run' });

const RUN_TIMEOUT_MS = 60000; // interactive sessions get more slack than judge mode

wss.on('connection', (ws) => {
    let ptyProcess = null;
    let killTimer = null;
    let workDir = null, language = null, fileName = null;

    const send = (obj) => {
        if (ws.readyState === WebSocket.OPEN) ws.send(JSON.stringify(obj));
    };

    ws.on('message', (raw) => {
        let msg;
        try { msg = JSON.parse(raw); } catch { return; }

        if (msg.type === 'start') {
            ({ language } = msg);
            fileName = msg.fileName;
            const filePath = path.join(ROOT_DIR, msg.moduleName, language, fileName);

            if (!fs.existsSync(filePath)) {
                send({ type: 'error', data: 'File not found: ' + filePath });
                return ws.close();
            }
            workDir = path.dirname(filePath);

            let compileCmd, runCmd;
            if (language === 'cpp') {
                const outFile = fileName.replace('.cpp', '.exe');
                compileCmd = `g++ -std=c++17 -o "${outFile}" "${fileName}"`;
                runCmd = outFile; // no quotes: generated filenames never contain spaces
            } else {
                const className = fileName.replace('.java', '');
                compileCmd = `javac "${fileName}"`;
                runCmd = `java ${className}`; // no quotes around className — Java class names can't contain spaces, and quoting here corrupts the arg through node-pty's Windows command-line reconstruction
            }

            send({ type: 'status', data: 'Compiling...' });

            exec(compileCmd, { cwd: workDir, timeout: 15000, shell: 'cmd.exe', maxBuffer: 10 * 1024 * 1024 }, (err, _stdout, stderr) => {
                if (err) {
                    send({ type: 'error', data: stderr || err.message });
                    return ws.close();
                }

                send({ type: 'status', data: 'Running...' });

                try {
                    // Spawn via cmd.exe /c so Windows resolves the executable / PATH
                    // (java, relative .exe) the same reliable way exec() already does —
                    // node-pty's direct spawn doesn't do PATH lookups on Windows.
                    ptyProcess = pty.spawn('cmd.exe', ['/c', runCmd], {
                        name: 'xterm-color',
                        cols: msg.cols || 100,
                        rows: msg.rows || 30,
                        cwd: workDir,
                        env: process.env
                    });
                } catch (spawnErr) {
                    send({ type: 'error', data: 'Failed to start interactive process: ' + spawnErr.message });
                    return ws.close();
                }

                killTimer = setTimeout(() => {
                    send({ type: 'output', data: '\r\n⏱️ Timeout (60s) — process killed.\r\n' });
                    ptyProcess.kill();
                }, RUN_TIMEOUT_MS);

                ptyProcess.onData((chunk) => send({ type: 'output', data: chunk }));

                ptyProcess.onExit(({ exitCode }) => {
                    clearTimeout(killTimer);
                    send({ type: 'exit', code: exitCode });
                    cleanupArtifacts(language, workDir, fileName);
                });
            });
            return;
        }

        if (msg.type === 'input' && ptyProcess) {
            ptyProcess.write(msg.data);
        }

        if (msg.type === 'resize' && ptyProcess) {
            try { ptyProcess.resize(msg.cols, msg.rows); } catch {}
        }
    });

    ws.on('close', () => {
        clearTimeout(killTimer);
        if (ptyProcess) ptyProcess.kill();
    });
});

server.listen(PORT, () => {
    console.log(`\n╔════════════════════════════════════════╗`);
    console.log(`║    OOPverse Web UI Runner              ║`);
    console.log(`║    🌌 http://localhost:${PORT}            ║`);
    console.log(`╚════════════════════════════════════════╝\n`);
});