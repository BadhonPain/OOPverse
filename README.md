
<style>
  @import url('https://fonts.googleapis.com/css2?family=DM+Mono:wght@400;500&family=Fraunces:ital,opsz,wght@0,9..144,300;0,9..144,500;1,9..144,300&display=swap');

  :root {
    --c-bg: var(--color-background-primary);
    --c-surf: var(--color-background-secondary);
    --c-border: var(--color-border-tertiary);
    --c-muted: var(--color-text-secondary);
    --c-accent: #185FA5;
    --c-accent-soft: #E6F1FB;
    --c-teal: #1D9E75;
    --c-teal-soft: #E1F5EE;
    --c-amber: #BA7517;
    --c-amber-soft: #FAEEDA;
    --mono: 'DM Mono', monospace;
    --serif: 'Fraunces', serif;
  }

  * { box-sizing: border-box; margin: 0; padding: 0; }

  body, .readme-root {
    font-family: var(--font-sans);
    color: var(--color-text-primary);
    font-size: 14px;
    line-height: 1.6;
  }

  .readme-root { padding: 0 0 2rem; }

  .hero {
    border-bottom: 0.5px solid var(--c-border);
    padding: 2rem 0 1.75rem;
    margin-bottom: 2rem;
  }

  .hero-eyebrow {
    font-family: var(--mono);
    font-size: 11px;
    letter-spacing: 0.12em;
    text-transform: uppercase;
    color: var(--c-muted);
    margin-bottom: 0.5rem;
  }

  .hero-title {
    font-family: var(--serif);
    font-size: 38px;
    font-weight: 300;
    line-height: 1.1;
    letter-spacing: -0.02em;
    color: var(--color-text-primary);
    margin-bottom: 0.75rem;
  }

  .hero-title span {
    font-style: italic;
    color: var(--c-accent);
  }

  .hero-desc {
    font-size: 14px;
    color: var(--c-muted);
    max-width: 520px;
    line-height: 1.7;
    margin-bottom: 1.25rem;
  }

  .badge-row {
    display: flex;
    gap: 8px;
    flex-wrap: wrap;
  }

  .badge {
    font-family: var(--mono);
    font-size: 11px;
    padding: 3px 10px;
    border-radius: 100px;
    border: 0.5px solid var(--c-border);
    color: var(--c-muted);
    background: var(--c-surf);
  }

  .badge.accent { background: var(--c-accent-soft); color: var(--c-accent); border-color: #B5D4F4; }
  .badge.teal { background: var(--c-teal-soft); color: var(--c-teal); border-color: #9FE1CB; }
  .badge.amber { background: var(--c-amber-soft); color: var(--c-amber); border-color: #FAC775; }

  .section-label {
    font-family: var(--mono);
    font-size: 10px;
    letter-spacing: 0.14em;
    text-transform: uppercase;
    color: var(--c-muted);
    margin-bottom: 1rem;
    display: flex;
    align-items: center;
    gap: 8px;
  }

  .section-label::after {
    content: '';
    flex: 1;
    height: 0.5px;
    background: var(--c-border);
  }

  .curriculum-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 1px;
    background: var(--c-border);
    border: 0.5px solid var(--c-border);
    border-radius: var(--border-radius-lg);
    overflow: hidden;
    margin-bottom: 2rem;
  }

  .module-card {
    background: var(--c-bg);
    padding: 1rem 1.1rem;
    cursor: pointer;
    transition: background 0.15s;
    position: relative;
  }

  .module-card:hover { background: var(--c-surf); }

  .module-num {
    font-family: var(--mono);
    font-size: 10px;
    color: var(--c-muted);
    margin-bottom: 0.4rem;
  }

  .module-name {
    font-size: 13px;
    font-weight: 500;
    color: var(--color-text-primary);
    margin-bottom: 0.3rem;
    line-height: 1.3;
  }

  .module-tags {
    display: flex;
    gap: 4px;
    flex-wrap: wrap;
    margin-top: 0.5rem;
  }

  .tag {
    font-family: var(--mono);
    font-size: 10px;
    padding: 2px 7px;
    border-radius: 4px;
    background: var(--c-surf);
    color: var(--c-muted);
    border: 0.5px solid var(--c-border);
  }

  .ref-table {
    margin-bottom: 2rem;
  }

  .ref-row {
    display: grid;
    grid-template-columns: 180px 1fr auto;
    align-items: start;
    gap: 1rem;
    padding: 0.85rem 0;
    border-bottom: 0.5px solid var(--c-border);
  }

  .ref-row:first-child { border-top: 0.5px solid var(--c-border); }

  .ref-topic {
    font-size: 13px;
    font-weight: 500;
    color: var(--color-text-primary);
    display: flex;
    align-items: flex-start;
    gap: 8px;
  }

  .ref-icon {
    width: 28px;
    height: 28px;
    border-radius: 6px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-shrink: 0;
    font-size: 14px;
  }

  .ref-icon.blue { background: var(--c-accent-soft); color: var(--c-accent); }
  .ref-icon.teal { background: var(--c-teal-soft); color: var(--c-teal); }
  .ref-icon.amber { background: var(--c-amber-soft); color: var(--c-amber); }
  .ref-icon.coral { background: #FAECE7; color: #993C1D; }
  .ref-icon.purple { background: #EEEDFE; color: #534AB7; }

  .ref-file {
    font-family: var(--mono);
    font-size: 11px;
    color: var(--c-muted);
    padding-top: 2px;
    line-height: 1.6;
  }

  .ref-file strong { color: var(--c-accent); font-weight: 500; }

  .ref-concepts {
    font-size: 12px;
    color: var(--c-muted);
    line-height: 1.6;
    padding-top: 2px;
  }

  .code-block {
    background: var(--c-surf);
    border: 0.5px solid var(--c-border);
    border-radius: var(--border-radius-md);
    padding: 1rem 1.25rem;
    margin-bottom: 1.5rem;
    position: relative;
    overflow: hidden;
  }

  .code-block pre {
    font-family: var(--mono);
    font-size: 12px;
    color: var(--color-text-primary);
    line-height: 1.7;
    white-space: pre;
    overflow-x: auto;
  }

  .code-label {
    font-family: var(--mono);
    font-size: 10px;
    color: var(--c-muted);
    margin-bottom: 0.5rem;
    letter-spacing: 0.08em;
    text-transform: uppercase;
  }

  .code-comment { color: var(--c-muted); }
  .code-kw { color: var(--c-accent); }
  .code-flag { color: var(--c-teal); }
  .code-str { color: var(--c-amber); }

  .practices-grid {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 12px;
    margin-bottom: 2rem;
  }

  .practice-card {
    background: var(--c-surf);
    border-radius: var(--border-radius-md);
    padding: 1rem;
    border: 0.5px solid var(--c-border);
  }

  .practice-icon {
    font-size: 18px;
    margin-bottom: 0.5rem;
    display: block;
  }

  .practice-title {
    font-size: 13px;
    font-weight: 500;
    margin-bottom: 0.25rem;
    color: var(--color-text-primary);
  }

  .practice-desc {
    font-size: 12px;
    color: var(--c-muted);
    line-height: 1.6;
  }

  .tab-bar {
    display: flex;
    gap: 0;
    border-bottom: 0.5px solid var(--c-border);
    margin-bottom: 1.5rem;
  }

  .tab {
    font-family: var(--mono);
    font-size: 11px;
    padding: 0.5rem 1rem;
    border: none;
    background: none;
    cursor: pointer;
    color: var(--c-muted);
    border-bottom: 2px solid transparent;
    margin-bottom: -0.5px;
    letter-spacing: 0.05em;
    text-transform: uppercase;
  }

  .tab.active {
    color: var(--c-accent);
    border-bottom-color: var(--c-accent);
  }

  .section { margin-bottom: 2rem; }

  .os-tabs { display: flex; gap: 6px; margin-bottom: 0.75rem; }
  .os-tab {
    font-family: var(--mono);
    font-size: 11px;
    padding: 3px 10px;
    border: 0.5px solid var(--c-border);
    border-radius: 4px;
    background: none;
    cursor: pointer;
    color: var(--c-muted);
  }
  .os-tab.active { background: var(--c-accent-soft); color: var(--c-accent); border-color: #B5D4F4; }
</style>

<div class="readme-root">
  <div class="hero">
    <div class="hero-eyebrow">C++ Learning Workspace · 9 Modules · C++17</div>
    <h1 class="hero-title">OOP<span>verse</span></h1>
    <p class="hero-desc">A structured, 9-stage curriculum for mastering C++ Object-Oriented Programming and Modern C++11/14/17 — from structs to STL, templates to file I/O.</p>
    <div class="badge-row">
      <span class="badge accent">C++17</span>
      <span class="badge teal">9 modules</span>
      <span class="badge amber">5 tutorials</span>
      <span class="badge">Beginner → Advanced</span>
      <span class="badge">Zero binary clutter</span>
    </div>
  </div>

  <div class="tab-bar">
    <button class="tab active" onclick="showSection('curriculum')">Curriculum</button>
    <button class="tab" onclick="showSection('tutorials')">Tutorials</button>
    <button class="tab" onclick="showSection('compile')">Compile & Run</button>
    <button class="tab" onclick="showSection('practices')">Best Practices</button>
  </div>

  <div id="sec-curriculum" class="section">
    <div class="section-label">9-stage learning path</div>
    <div class="curriculum-grid" id="curriculum-grid"></div>
  </div>

  <div id="sec-tutorials" class="section" style="display:none;">
    <div class="section-label">modern c++ reference</div>
    <div class="ref-table" id="ref-table"></div>
  </div>

  <div id="sec-compile" class="section" style="display:none;">
    <div class="section-label">getting started</div>
    <div class="os-tabs">
      <button class="os-tab active" onclick="showOS('all')">All platforms</button>
      <button class="os-tab" onclick="showOS('win')">Windows</button>
      <button class="os-tab" onclick="showOS('unix')">Linux / macOS</button>
    </div>
    <div id="compile-content"></div>
  </div>

  <div id="sec-practices" class="section" style="display:none;">
    <div class="section-label">design philosophy</div>
    <div class="practices-grid" id="practices-grid"></div>
  </div>
</div>

<script>
const modules = [
  { num: "01", name: "Basics & Structs", tags: ["struct", "class", "memory layouts"] },
  { num: "02", name: "Classes & Encapsulation", tags: ["constructors", "RAII", "static members"] },
  { num: "03", name: "Inheritance", tags: ["virtual", "type casting", "multi-level"] },
  { num: "04", name: "Polymorphism", tags: ["overloading", "virtual fns", "abstract"] },
  { num: "05", name: "Templates & Generics", tags: ["fn templates", "class templates", "sort"] },
  { num: "06", name: "STL", tags: ["vector", "map", "algorithms"] },
  { num: "07", name: "I/O & Manipulators", tags: ["streams", "formatting", "flags"] },
  { num: "08", name: "Exception Handling", tags: ["try/catch", "propagation", "safety"] },
  { num: "09", name: "File Operations", tags: ["seekg/seekp", "binary", "state"] },
];

const tutorials = [
  { icon: "ti-pointer", color: "blue", topic: "Memory Management", file: "02_Classes_and_Encapsulation/\nsmart_pointers.cpp", concepts: "unique_ptr · shared_ptr · weak_ptr · RAII · cyclic refs" },
  { icon: "ti-arrows-exchange", color: "teal", topic: "Move Semantics", file: "02_Classes_and_Encapsulation/\nrule_of_five.cpp", concepts: "lvalue vs rvalue · std::move · Rule of Five" },
  { icon: "ti-alert-triangle", color: "amber", topic: "Robust Handling", file: "08_Exception_Handling/\ncustom_exceptions.cpp", concepts: "custom exceptions · what() noexcept · polymorphic catch" },
  { icon: "ti-filter", color: "coral", topic: "Modern STL", file: "06_STL/\nstl_algorithms_lambdas.cpp", concepts: "lambdas · sort · find_if · transform" },
  { icon: "ti-table", color: "purple", topic: "Hash Tables", file: "06_STL/\nunordered_containers.cpp", concepts: "unordered_map · unordered_set · O(1) vs O(log N)" },
];

const compileContent = {
  all: `<div class="code-block">
    <div class="code-label">1. Compile</div>
    <pre><span class="code-kw">g++</span> <span class="code-flag">-std=c++17</span> <span class="code-str">&lt;filename&gt;.cpp</span> <span class="code-flag">-o</span> <span class="code-str">&lt;output&gt;</span></pre>
  </div>
  <div class="code-block">
    <div class="code-label">2. Run — Windows</div>
    <pre>.<span class="code-str">\&lt;output&gt;.exe</span></pre>
  </div>
  <div class="code-block">
    <div class="code-label">3. Run — Linux / macOS</div>
    <pre>./<span class="code-str">&lt;output&gt;</span></pre>
  </div>
  <div class="code-block">
    <div class="code-label">Example — smart pointers tutorial</div>
    <pre><span class="code-kw">g++</span> <span class="code-flag">-std=c++17</span> <span class="code-str">02_Classes_and_Encapsulation/smart_pointers.cpp</span> <span class="code-flag">-o</span> smart_pointers
.<span class="code-str">\smart_pointers.exe</span>   <span class="code-comment"># Windows</span>
./<span class="code-str">smart_pointers</span>        <span class="code-comment"># Linux / macOS</span></pre>
  </div>`,
  win: `<div class="code-block">
    <div class="code-label">PowerShell / Command Prompt</div>
    <pre><span class="code-kw">g++</span> <span class="code-flag">-std=c++17</span> <span class="code-str">&lt;filename&gt;.cpp</span> <span class="code-flag">-o</span> <span class="code-str">&lt;output&gt;</span>
.<span class="code-str">\&lt;output&gt;.exe</span></pre>
  </div>`,
  unix: `<div class="code-block">
    <div class="code-label">bash / zsh</div>
    <pre><span class="code-kw">g++</span> <span class="code-flag">-std=c++17</span> <span class="code-str">&lt;filename&gt;.cpp</span> <span class="code-flag">-o</span> <span class="code-str">&lt;output&gt;</span>
./<span class="code-str">&lt;output&gt;</span></pre>
  </div>`,
};

const practices = [
  { icon: "ti-sparkles", color: "blue", title: "Modern idioms first", desc: "Emphasizes C++11/14/17 patterns over legacy raw pointer management throughout." },
  { icon: "ti-file-x", color: "teal", title: "Zero binary clutter", desc: "Compiled .exe binaries excluded via .gitignore — source stays clean." },
  { icon: "ti-list-numbers", color: "amber", title: "Linear progression", desc: "Numbered modules enforce a natural learning path from basics to advanced topics." },
  { icon: "ti-message-2-code", color: "coral", title: "Deep inline commentary", desc: "Every tutorial file is annotated with thorough inline explanations of each construct." },
  { icon: "ti-stack-2", color: "purple", title: "Textbook structure", desc: "9 stages mirror a university-style curriculum — each module builds on the last." },
  { icon: "ti-cpu", color: "blue", title: "Real-world examples", desc: "Assignments like TollBooth.cpp ground abstract OOP concepts in tangible use cases." },
];

function renderCurriculum() {
  const grid = document.getElementById('curriculum-grid');
  grid.innerHTML = modules.map(m => `
    <div class="module-card" onclick="sendPrompt('Tell me more about the ${m.name} module in OOPverse')">
      <div class="module-num">${m.num}</div>
      <div class="module-name">${m.name}</div>
      <div class="module-tags">${m.tags.map(t => `<span class="tag">${t}</span>`).join('')}</div>
    </div>
  `).join('');
}

function renderTutorials() {
  const table = document.getElementById('ref-table');
  table.innerHTML = tutorials.map(t => `
    <div class="ref-row">
      <div class="ref-topic">
        <div class="ref-icon ${t.color}"><i class="ti ${t.icon}" aria-hidden="true"></i></div>
        <span style="padding-top:6px">${t.topic}</span>
      </div>
      <div class="ref-file" style="font-size:11px; white-space:pre">${t.file}</div>
      <div class="ref-concepts">${t.concepts}</div>
    </div>
  `).join('');
}

function renderPractices() {
  const grid = document.getElementById('practices-grid');
  grid.innerHTML = practices.map(p => `
    <div class="practice-card">
      <i class="ti ${p.icon} practice-icon" style="color: var(--c-${p.color === 'coral' ? 'teal' : p.color})" aria-hidden="true"></i>
      <div class="practice-title">${p.title}</div>
      <div class="practice-desc">${p.desc}</div>
    </div>
  `).join('');
}

function showSection(id) {
  ['curriculum','tutorials','compile','practices'].forEach(s => {
    document.getElementById('sec-' + s).style.display = s === id ? 'block' : 'none';
  });
  document.querySelectorAll('.tab').forEach((t, i) => {
    t.classList.toggle('active', ['curriculum','tutorials','compile','practices'][i] === id);
  });
}

function showOS(os) {
  document.getElementById('compile-content').innerHTML = compileContent[os];
  document.querySelectorAll('.os-tab').forEach(t => {
    t.classList.toggle('active', t.textContent.toLowerCase().includes(os === 'all' ? 'all' : os === 'win' ? 'win' : 'lin'));
  });
}

renderCurriculum();
renderTutorials();
renderPractices();
document.getElementById('compile-content').innerHTML = compileContent.all;
</script>
