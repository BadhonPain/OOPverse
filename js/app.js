
let currentModule = null, currentLanguage = 'cpp', currentFile = null;
let recentFiles = JSON.parse(localStorage.getItem('recentFiles')) || [];
let isDarkMode = localStorage.getItem('darkMode') === 'true';

function escapeHtml(text) {
    const map = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#039;' };
    return String(text).replace(/[&<>"']/g, m => map[m]);
}

// ---- Dark mode ----

function initDarkMode() {
    document.body.classList.toggle('dark-mode', isDarkMode);
    document.getElementById('themeToggle').textContent = isDarkMode ? '☀️ Light' : '🌙 Dark';
}

document.getElementById('themeToggle').addEventListener('click', () => {
    isDarkMode = !isDarkMode;
    localStorage.setItem('darkMode', isDarkMode);
    initDarkMode();
});

// ---- Status / stats ----

function updateStats() {
    document.getElementById('statFile').textContent = currentFile || '-';
    document.getElementById('statLang').textContent = currentLanguage.toUpperCase();
}

function showStatus(text, isRunning = false) {
    document.getElementById('statusIndicator').className = 'status-indicator' + (isRunning ? ' running' : ' ready');
    document.getElementById('statusText').textContent = text;
}

// ---- Modules / files ----

async function loadModules() {
    const res = await fetch('/api/modules');
    const modules = await res.json();
    const list = document.getElementById('modulesList');
    list.innerHTML = modules.map(m =>
        `<button class="file-btn" data-module="${escapeHtml(m.name)}"><span class="file-icon">📂</span>${escapeHtml(m.displayName)}</button>`
    ).join('');
    document.querySelectorAll('[data-module]').forEach(btn => {
        btn.addEventListener('click', () => selectModule(btn.dataset.module, btn));
    });
}

async function selectModule(moduleName, btn) {
    document.querySelectorAll('[data-module]').forEach(b => b.classList.remove('active'));
    btn.classList.add('active');
    currentModule = moduleName;
    currentFile = null;

    const res = await fetch(`/api/modules/${encodeURIComponent(moduleName)}/${encodeURIComponent(currentLanguage)}`);
    const files = await res.json();
    const list = document.getElementById('filesList');
    const icon = currentLanguage === 'cpp' ? '⚙️' : '☕';
    list.innerHTML = files.map(f =>
        `<button class="file-btn" data-file="${escapeHtml(f)}"><span class="file-icon">${icon}</span>${escapeHtml(f)}</button>`
    ).join('');
    document.querySelectorAll('[data-file]').forEach(btn => {
        btn.addEventListener('click', () => selectFile(btn.dataset.file, btn));
    });

    updateStats();
    clearCodePreview();
}

async function selectFile(fileName, btn) {
    document.querySelectorAll('[data-file]').forEach(b => b.classList.remove('active'));
    btn.classList.add('active');
    currentFile = fileName;
    document.getElementById('runBtn').disabled = false;
    updateStats();
    addRecentFile(fileName);
    await loadCodePreview();
    showStatus('Ready');
}

async function loadCodePreview() {
    if (!currentModule || !currentFile) return;
    const filePath = `${currentModule}/${currentLanguage}/${currentFile}`;
    try {
        const res = await fetch(`/code/${filePath.split('/').map(encodeURIComponent).join('/')}`);
        const code = await res.text();
        const lines = code.split('\n').slice(0, 50);
        const lineNumbers = lines.map((line, i) =>
            `<div class="code-line"><div class="line-number">${i + 1}</div><div class="line-content">${escapeHtml(line) || '&nbsp;'}</div></div>`
        ).join('');
        document.getElementById('codeFileName').textContent = currentFile;
        document.getElementById('codeContent').innerHTML = lineNumbers;
    } catch (e) {
        document.getElementById('codeContent').innerHTML = '<div class="empty-state">Could not load preview</div>';
    }
}

function clearCodePreview() {
    document.getElementById('codeFileName').textContent = 'Select a file';
    document.getElementById('codeContent').innerHTML =
        '<div class="empty-state"><div class="empty-state-icon"><i class="fas fa-folder-open"></i></div><div>Select a file to preview</div></div>';
}

function addRecentFile(fileName) {
    recentFiles = recentFiles.filter(f => f !== fileName);
    recentFiles.unshift(fileName);
    recentFiles = recentFiles.slice(0, 5);
    localStorage.setItem('recentFiles', JSON.stringify(recentFiles));
}

// ---- Language toggle ----

document.querySelectorAll('.lang-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        document.querySelectorAll('.lang-btn').forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
        currentLanguage = btn.dataset.lang;
        currentFile = null;
        if (currentModule) selectModule(currentModule, document.querySelector(`[data-module="${currentModule}"]`));
    });
});

// ---- Search ----

document.getElementById('moduleSearch').addEventListener('input', (e) => {
    const term = e.target.value.toLowerCase();
    document.querySelectorAll('[data-module]').forEach(btn => {
        btn.style.display = btn.textContent.toLowerCase().includes(term) ? 'flex' : 'none';
    });
});

document.getElementById('fileSearch').addEventListener('input', (e) => {
    const term = e.target.value.toLowerCase();
    document.querySelectorAll('[data-file]').forEach(btn => {
        btn.style.display = btn.textContent.toLowerCase().includes(term) ? 'flex' : 'none';
    });
});

// ---- Run mode toggle ----

function getRunMode() {
    return document.querySelector('input[name="runMode"]:checked').value;
}

document.querySelectorAll('input[name="runMode"]').forEach(radio => {
    radio.addEventListener('change', () => {
        const interactive = getRunMode() === 'interactive';
        document.getElementById('stdinPanel').style.display = interactive ? 'none' : 'flex';
        document.getElementById('interactivePanel').style.display = interactive ? 'flex' : 'none';
    });
});

// ---- Run ----

let activeSocket = null;

document.getElementById('runBtn').addEventListener('click', () => {
    if (!currentModule || !currentFile) return;
    if (getRunMode() === 'interactive') {
        runInteractive();
    } else {
        runJudgeStyle();
    }
});

async function runJudgeStyle() {
    showStatus('Running...', true);
    document.getElementById('loading').classList.add('active');
    document.getElementById('output').style.display = 'none';
    const startTime = Date.now();

    const res = await fetch('/api/run', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            moduleName: currentModule,
            language: currentLanguage,
            fileName: currentFile,
            input: document.getElementById('stdinInput').value
        })
    });
    const result = await res.json();
    const elapsed = Date.now() - startTime;

    document.getElementById('loading').classList.remove('active');
    const output = document.getElementById('output');
    output.style.display = 'block';
    output.classList.remove('has-error');

    if (result.success) {
        output.textContent = result.output || '(Program executed successfully with no output)';
        showStatus(`Completed in ${elapsed}ms`);
    } else {
        output.classList.add('has-error');
        output.textContent = `❌ Error:\n${result.error}`;
        showStatus('Error');
    }
    document.getElementById('statTime').textContent = `${elapsed}ms`;
}

function stripAnsi(str) {
    return str
        .replace(/\x1b\][^\x07\x1b]*(?:\x07|\x1b\\)/g, '') // OSC sequences (e.g. window title)
        .replace(/\x1b\[[0-9;?]*[a-zA-Z]/g, '')             // CSI sequences (cursor moves, clear screen, colors, private modes)
        .replace(/\x1b[()][A-Za-z0-9]/g, '')                 // charset selection
        .replace(/\x1b[=>]/g, '');                           // keypad mode
}

function runInteractive() {
    const output = document.getElementById('output');
    const termInput = document.getElementById('terminalInput');
    const runBtn = document.getElementById('runBtn');

    output.style.display = 'block';
    output.classList.remove('has-error');
    output.textContent = '';
    document.getElementById('loading').classList.remove('active');
    showStatus('Connecting...', true);
    runBtn.disabled = true;
    termInput.disabled = true;

    if (activeSocket) {
        try { activeSocket.close(); } catch {}
    }

    const proto = location.protocol === 'https:' ? 'wss:' : 'ws:';
    const socket = new WebSocket(`${proto}//${location.host}/ws/run`);
    activeSocket = socket;
    const startTime = Date.now();

    socket.addEventListener('open', () => {
        socket.send(JSON.stringify({
            type: 'start',
            moduleName: currentModule,
            language: currentLanguage,
            fileName: currentFile,
            cols: 100,
            rows: 30
        }));
    });

    socket.addEventListener('message', (event) => {
        const msg = JSON.parse(event.data);

        if (msg.type === 'status') {
            showStatus(msg.data, true);
        } else if (msg.type === 'output') {
            output.textContent += stripAnsi(msg.data);
            output.scrollTop = output.scrollHeight;
            termInput.disabled = false;
            termInput.focus();
        } else if (msg.type === 'error') {
            output.classList.add('has-error');
            output.textContent += `\n❌ Error:\n${msg.data}`;
            showStatus('Error');
            termInput.disabled = true;
        } else if (msg.type === 'exit') {
            const elapsed = Date.now() - startTime;
            showStatus(msg.code === 0 ? `Completed in ${elapsed}ms` : `Terminated with code ${msg.code}`);
            document.getElementById('statTime').textContent = `${elapsed}ms`;
            termInput.disabled = true;
            runBtn.disabled = false;
        }
    });

    socket.addEventListener('close', () => {
        runBtn.disabled = false;
        termInput.disabled = true;
    });

    socket.addEventListener('error', () => {
        output.classList.add('has-error');
        output.textContent += '\n❌ Connection error. Is the server running with node-pty installed?';
        showStatus('Error');
        runBtn.disabled = false;
        termInput.disabled = true;
    });
}

document.getElementById('terminalInput').addEventListener('keydown', (e) => {
    if (e.key === 'Enter' && activeSocket && activeSocket.readyState === WebSocket.OPEN) {
        const val = e.target.value;
        activeSocket.send(JSON.stringify({ type: 'input', data: val + '\r' }));
        e.target.value = '';
    }
});

document.getElementById('copyCodeBtn').addEventListener('click', () => {
    navigator.clipboard.writeText(document.getElementById('codeContent').innerText);
    alert('Code copied!');
});

document.getElementById('copyOutputBtn').addEventListener('click', () => {
    navigator.clipboard.writeText(document.getElementById('output').textContent);
    alert('Output copied!');
});

document.getElementById('clearOutputBtn').addEventListener('click', () => {
    document.getElementById('output').textContent = '';
});

// ---- Init ----

loadModules();
updateStats();
initDarkMode();