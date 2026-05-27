// OOPverse Web UI Runner - Backend (Node.js + Express)
// Install: npm install express
// Run: npm start OR node play-server.js
// Then open: http://localhost:3000

const express = require('express');
const { exec } = require('child_process');
const fs = require('fs');
const path = require('path');
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

// Compile and run a file
app.post('/api/run', (req, res) => {
    const { moduleName, language, fileName } = req.body;
    const filePath = path.join(ROOT_DIR, moduleName, language, fileName);

    if (!fs.existsSync(filePath)) {
        return res.json({
            success: false,
            error: 'File not found: ' + filePath,
            output: ''
        });
    }

    let command;
    const workDir = path.dirname(filePath);

    if (language === 'cpp') {
        const outFile = path.join(workDir, fileName.replace('.cpp', '.exe'));
        // Windows: compile and run, then delete exe
        // Split into: compile, run, cleanup steps for better error reporting
        command = `cd /d "${workDir}" && g++ -std=c++17 -o "${outFile}" "${fileName}" 2>&1 && "${outFile}" 2>&1 && del /q "${outFile}" 2>nul`;
    } else {
        const className = fileName.replace('.java', '');
        // Windows: compile and run, then delete class files
        command = `cd /d "${workDir}" && javac "${fileName}" 2>&1 && java "${className}" 2>&1 && del /q *.class 2>nul`;
    }

    exec(command, { timeout: 15000, shell: 'cmd.exe', maxBuffer: 10 * 1024 * 1024 }, (error, stdout, stderr) => {
        let output = stdout || '';
        let errorMsg = stderr || '';

        // For better UX, combine stdout and stderr
        if (error) {
            // If there's stderr, use it as the error message
            if (stderr) {
                errorMsg = stderr;
            } else if (error.killed) {
                errorMsg = '⏱️ Program execution timeout (15 seconds exceeded)';
            } else {
                errorMsg = error.message;
            }
        }

        res.json({
            success: !error,
            output: output || '',
            error: errorMsg || '',
            fileName
        });
    });
});

app.listen(PORT, () => {
    console.log(`\n╔════════════════════════════════════════╗`);
    console.log(`║    OOPverse Web UI Runner              ║`);
    console.log(`║    🌌 http://localhost:${PORT}            ║`);
    console.log(`╚════════════════════════════════════════╝\n`);
});
