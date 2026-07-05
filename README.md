# OOPverse 🌌

> A premium, interactive, bilingual **(C++ & Java)** learning workspace covering **14 progressive modules** of Object-Oriented Programming — from structs and encapsulation all the way to multithreading, networking, and code testing.

[![C++17](https://img.shields.io/badge/C%2B%2B-17-blue?style=for-the-badge&logo=cplusplus)](https://isocpp.org/)
[![Java 17](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)](https://openjdk.org/)
[![CI](https://img.shields.io/github/actions/workflow/status/badhonpain/OOPverse/compile_check.yml?style=for-the-badge&logo=github-actions&label=CI)](https://github.com/badhonpain/OOPverse/actions)
[![License: MIT](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)

---

## 📖 Table of Contents

- [What is OOPverse?](#-what-is-oopverse)
- [Project Structure](#-project-structure)
- [Prerequisites](#️-prerequisites)
- [Getting Started](#-getting-started)
  - [Option 1 — Web UI Runner](#option-1--web-ui-runner-recommended)
  - [Option 2 — CLI Runner](#option-2--cli-runner)
- [14-Module Curriculum](#-14-module-curriculum)
- [Known Limitations](#️-known-limitations)
- [Tech Stack](#️-tech-stack)
- [CI/CD Pipeline](#️-cicd-pipeline)
- [Reference Material](#-reference-material)
- [Creator](#-creator)

---

## 🌌 What is OOPverse?

OOPverse is a structured, self-contained OOP learning repository designed for students and developers who want to master Object-Oriented Programming through hands-on, runnable examples. Every concept is demonstrated **side-by-side in both C++ and Java**, making it easy to understand how the same paradigm is expressed across two of the most widely used languages in the world.

**Key highlights:**

- ✅ **14 progressive modules** — carefully ordered from basics to advanced topics, plus a dedicated code-testing module
- ✅ **Bilingual** — every module has both C++ and Java implementations
- ✅ **Two runners** — a modern Web UI (with two execution modes) and a terminal-based CLI runner
- ✅ **Real interactive input support** — the Web UI can run programs that read from `cin` / `Scanner` live, not just batch-style
- ✅ **Zero manual compilation** — the runners handle compile, execute, and cleanup automatically
- ✅ **CI/CD verified** — every file in the repo is guaranteed to compile on every commit
- ✅ **Per-module READMEs** — each module has its own detailed explanation

---

## 📁 Project Structure

```
OOPverse/
├── 01_Basics_and_Structs/
│   ├── cpp/                   # C++ source files
│   ├── java/                  # Java source files
│   └── README.md              # Module-level explanation
├── 02_Classes_and_Encapsulation/
├── 03_Inheritance/
├── 04_Polymorphism_and_Overloading/
├── 05_Templates_and_Generics/
├── 06_STL_and_Collections/
├── 07_IO_and_Manipulators/
├── 08_Exception_Handling/
├── 09_File_Operations/
├── 10_Nested_Classes_and_Enums/
├── 11_Multithreading/
├── 12_Networking/
├── 13_Command_Line_Arguments/
├── 14_Code_Testing/
│
├── index.html                 # Web UI frontend (markup only)
├── css/
│   └── styles.css             # Web UI styling — CSS-variable driven theme (light/dark)
├── js/
│   └── app.js                 # Web UI client logic (module/file browsing, both run modes)
├── play-server.js             # Web UI backend (Node.js + Express + WebSocket)
├── play.sh                    # CLI runner for Linux / macOS
├── play.ps1                   # CLI runner for Windows (PowerShell)
├── package.json               # Node.js dependencies
└── Materials/
    └── OOP QB BUET_TF.pdf     # BUET OOP question bank (reference)
```

Each numbered module folder follows the same layout: a `cpp/` subfolder, a `java/` subfolder, and a `README.md` explaining the concepts covered. **Any file you drop directly into a module's `cpp/` or `java/` folder is picked up automatically** by both runners — no registration or config needed.

---

## ⚙️ Prerequisites

Before running OOPverse, make sure the following are installed on your system:

| Tool | Version | Purpose |
|------|---------|---------|
| [G++ (GCC)](https://gcc.gnu.org/) | C++17 or later | Compile C++ files |
| [JDK (OpenJDK)](https://openjdk.org/) | 17 or later | Compile & run Java files |
| [Node.js](https://nodejs.org/) | 16 or later | Required for the Web UI runner only |

**Verify your installations:**
```bash
g++ --version
java --version
javac --version
node --version    # Only needed for Web UI
```

> **Windows only, for Interactive Terminal mode:** the Web UI's live/interactive run mode depends on [`node-pty`](https://github.com/microsoft/node-pty), which compiles a native addon on install. This requires a C++ build toolchain — either **Visual Studio Build Tools** (with the "Desktop development with C++" workload) or `npm install --global windows-build-tools`, plus Python 3 for `node-gyp`. Judge-style mode has no such requirement.

---

## 🚀 Getting Started

OOPverse provides **two ways** to browse and run examples. Choose whichever suits your workflow.

---

### Option 1 — Web UI Runner *(Recommended)*

The Web UI is a browser-based interface powered by a Node.js + Express backend. It lets you browse modules, preview source code, and compile & run files — all with a single click.

**Step 1 — Install dependencies** *(first time only)*
```bash
npm install
```

**Step 2 — Start the server**
```bash
npm start
```

**Step 3 — Open your browser**
```
http://localhost:3000
```

#### Web UI Features

| Feature | Description |
|---------|-------------|
| 📂 Module browser | Lists all 14 modules in the sidebar |
| 🔀 Language toggle | Switch between C++ and Java file lists instantly |
| 📄 Code preview | View the full source code of any file before running it |
| 🌗 Dark mode | Full light/dark theme, driven entirely by CSS variables |
| ▶️ One-click run | Compiles and executes the selected file on the server |
| 📟 Live output | Displays compiler output and program output in a terminal-style panel |
| 🧹 Auto cleanup | Compiled binaries (`.exe`, `.class`) are deleted automatically after each run |
| ⏱️ Timeout guard | Judge-style runs are terminated after 15s; interactive sessions after 60s |

#### Two Run Modes

The Run panel lets you choose **per run** how input is supplied:

| Mode | How it works | Best for |
|------|--------------|----------|
| **Judge style** | Paste all expected input upfront into a textarea, one value per line. The program runs start-to-finish and returns a single result — just like an online judge (Codeforces, etc.) feeding input from a file. | Competitive-programming style problems where you already know the input, or any file with no `cin`/`Scanner` calls |
| **Interactive terminal** | Compiles the file, then runs it inside a real pseudo-terminal (PTY) over a WebSocket connection. Output streams in live as it's printed, and you type responses into a live input box exactly as you would in a real console. | Programs that print prompts and read `cin >>` / `Scanner.nextInt()` etc., especially ones using `cin.tie(nullptr); ios::sync_with_stdio(false);`, where judge-style buffering would hide prompts until the very end |

> **Why two modes exist:** piped (non-interactive) processes default to fully-buffered `stdout`, so prompts and output can appear all at once at the end rather than as the program runs — especially once fast-I/O optimizations are used. A real PTY restores normal line-buffered behavior, so Interactive mode shows prompts exactly when they're printed.

> **Note on Interactive mode:** it streams a raw text feed. It doesn't fully emulate a terminal (no live re-rendering of `system("cls")`, colored text, or cursor-controlled progress bars) — the escape codes for those are stripped for readability. For everything from ordinary `cin`/`Scanner` based programs, this makes no difference.

> **Port conflict?** If port 3000 is already in use, open `play-server.js` and change `const PORT = 3000;` to any available port number.

---

### Option 2 — CLI Runner

The CLI runner is a fully interactive terminal menu — no browser or Node.js required. It works on any platform that has a shell, and standard input works exactly as in a normal terminal since there's no buffering to worry about.

**On Linux / macOS:**
```bash
chmod +x play.sh
./play.sh
```

**On Windows (PowerShell):**
```powershell
.\play.ps1
```

#### How the CLI runner works:

1. **Select a module** — an interactive numbered menu lists all 14 modules
2. **Select a language** — choose C++ or Java
3. **Select a file** — pick from the available source files in that module
4. **Run** — the runner compiles the file, prints the output, and cleans up the binary automatically

---

## 📚 14-Module Curriculum

The modules are designed in strict progressive order. Each module builds on the previous one and presents concepts in **both C++ and Java** for direct comparison.

| # | Module | Core Concepts | C++ Highlights | Java Highlights |
|:--|:-------|:--------------|:---------------|:----------------|
| **01** | **Basics & Structs** | Primitive types, scopes, basic I/O, type casting, arrays | Struct layouts, pointers, namespaces | `BasicIO`, loops, `ArrayDemo`, `MethodDemo`, multidimensional arrays |
| **02** | **Classes & Encapsulation** | Classes, encapsulation, object lifetimes, constructors, destructors | Rule of Three/Five, move semantics, smart pointers, `this` pointer, shallow vs deep copy | `ClassBasics`, static blocks, `AccessModifiers`, `CopyConstructor` |
| **03** | **Inheritance** | Single, multilevel, hierarchical, multiple, and hybrid inheritance | Virtual destructors, constructor chaining, all four type casts (`static_cast`, `dynamic_cast`, `const_cast`, `reinterpret_cast`) | `SingleInheritance`, Interfaces (default, static, private methods), `AbstractClass`, `super` keyword |
| **04** | **Polymorphism & Overloading** | Function/method overloading, method overriding, virtual dispatch, abstraction | Operator overloading (unary & binary), conversion functions, vtables | `MethodOverloading`, runtime polymorphism, upcasting, autoboxing |
| **05** | **Templates & Generics** | Compile-time generic programming | Class templates, function templates, template inheritance, monomorphization | Generic classes, generic methods, generic interfaces, wildcards (`extends`/`super`), multi-type generics |
| **06** | **STL & Collections** | Containers, iterators, standard algorithms | `vector`, `list`, `deque`, `map`, `set`, unordered containers, lambda sorting, STL algorithms | `ArrayList`, `LinkedList`, `HashMap`, `HashSet`, `Vector`, iterators, custom comparators, Streams API |
| **07** | **I/O & Manipulators** | Standard streams, text formatting, string operations | Stream format flags, manipulators, width/precision/fill, inline functions | `FormattedOutput`, `ScannerIO`, `StringBuilder`, string operations, type conversion |
| **08** | **Exception Handling** | Error propagation, exception hierarchies, safe program teardown | `try`/`catch`/`throw`, custom exceptions, `noexcept`, polymorphic exceptions | `TryCatchDemo`, checked vs unchecked exceptions, `try-with-resources`, custom exception classes |
| **09** | **File Operations** | Read/write text and binary files, serialization | Sequential & random access (`seekg`/`seekp`), stream buffers | `FileReadDemo`, `FileWriteDemo`, `BufferedReader`, serialization & deserialization, random access files |
| **10** | **Nested Classes & Enums** | Scoped structures, inner type encapsulation | Nested structs, scoped `enum class` | Static/non-static inner classes, anonymous classes, enums with constructors and fields |
| **11** | **Multithreading** | Parallel execution, thread synchronization, inter-thread communication | `std::thread`, `mutex`, `lock_guard`, `condition_variable`, lambda threads | `Thread` class, `Runnable`, `synchronized`, `wait()`/`notify()`, `join()`, producer-consumer pattern |
| **12** | **Networking** | Socket programming, client-server architecture, network I/O | POSIX sockets (Linux/macOS), Winsock2 (Windows), TCP server setup | `ServerSocket`, `Socket`, client-server message exchange, input/output streams over network |
| **13** | **Command-Line Arguments** | Runtime input via CLI flags and arguments | `argc`/`argv` parsing, CLI config structures | `String[] args` parsing, argument validation, input handling |
| **14** | **Code Testing** | Applying OOP + DS/A fundamentals to solved problems | Checking & Testing code | Checking & Testing code |

---

## 🔄 v1 vs v2 — What Changed

| | v1 | v2 |
|---|----|----|
| **User input (`cin`, `Scanner`)** | ❌ Not supported — any program waiting on input would hang for 15s and time out | ✅ Supported via two modes: paste input upfront (**Judge style**) or type live while the program runs (**Interactive terminal**, real PTY) |
| **Frontend code** | Inline `<style>` and `<script>` inside one `index.html` | Split into `index.html`, `css/styles.css`, `js/app.js` |
| **Dark mode** | Every component had a duplicated `body.dark-mode .x { }` rule | Single set of CSS variables in `:root`; dark mode just overrides the variables |
| **Modules** | 13 | 14 (added `14_Code_Testing`) |
| **Backend** | Express only (`/api/run`, one-shot `exec()`) | Express + WebSocket (`ws`) + `node-pty` for live sessions |

---



- **Interactive Terminal mode is Windows-only as currently implemented.** Both `/api/run` (judge mode) and the interactive PTY path shell out via `cmd.exe`. On Linux/macOS, judge-style CLI usage still works fine through `play.sh`, but the Web UI's compile/run commands need to be ported to a POSIX shell to work cross-platform.
- **Interactive mode streams raw text, not a full terminal emulation.** ANSI/VT escape sequences (cursor positioning, `clear`, colors) are stripped for readability rather than rendered — fine for standard `cin`/`Scanner` programs, not suitable for anything relying on live-redrawn output (e.g. a console progress bar).
- **`node_modules/` is currently committed to the repository.** This is typically unintentional — recommend adding a `.gitignore` and running `git rm -r --cached node_modules` to slim down the repo.

---

## 🛠️ Tech Stack

| Layer | Technology | Purpose |
|-------|-----------|---------|
| **Language** | [![C++17](https://img.shields.io/badge/C%2B%2B-17-00599C?style=flat-square&logo=cplusplus&logoColor=white)](https://isocpp.org/) | Primary systems programming language |
| **Language** | [![Java 17](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://openjdk.org/) | Primary object-oriented language |
| **Compiler** | [![GCC](https://img.shields.io/badge/GCC-g%2B%2B-A42E2B?style=flat-square&logo=gnu&logoColor=white)](https://gcc.gnu.org/) | Compiles C++ source files (`-std=c++17`) |
| **Compiler** | [![javac](https://img.shields.io/badge/javac-JDK%2017-007396?style=flat-square&logo=openjdk&logoColor=white)](https://openjdk.org/) | Compiles and runs Java source files |
| **Backend** | [![Node.js](https://img.shields.io/badge/Node.js-16+-339933?style=flat-square&logo=nodedotjs&logoColor=white)](https://nodejs.org/) | Powers the Web UI runner server |
| **Framework** | [![Express](https://img.shields.io/badge/Express.js-4.18-000000?style=flat-square&logo=express&logoColor=white)](https://expressjs.com/) | REST API for judge-style compile & run |
| **Realtime** | [![WebSocket](https://img.shields.io/badge/WebSocket-ws-010101?style=flat-square&logo=socketdotio&logoColor=white)](https://github.com/websockets/ws) | Live streaming for Interactive Terminal mode |
| **PTY** | [![node--pty](https://img.shields.io/badge/node--pty-native-black?style=flat-square)](https://github.com/microsoft/node-pty) | Real pseudo-terminal for live `cin`/`Scanner` input |
| **Frontend** | [![HTML/CSS/JS](https://img.shields.io/badge/Frontend-HTML%20%7C%20CSS%20%7C%20JS-E34F26?style=flat-square&logo=html5&logoColor=white)]() | Vanilla web UI, split into `index.html` / `css/styles.css` / `js/app.js` |
| **CI/CD** | [![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-CI-2088FF?style=flat-square&logo=githubactions&logoColor=white)](https://github.com/features/actions) | Auto-compiles all files on every push |
| **Shell** | [![Bash](https://img.shields.io/badge/Bash-play.sh-4EAA25?style=flat-square&logo=gnubash&logoColor=white)](https://www.gnu.org/software/bash/) | CLI runner for Linux / macOS |
| **Shell** | [![PowerShell](https://img.shields.io/badge/PowerShell-play.ps1-5391FE?style=flat-square&logo=powershell&logoColor=white)](https://learn.microsoft.com/en-us/powershell/) | CLI runner for Windows |

---

## 🛡️ CI/CD Pipeline

Every commit pushed to `main` or `master` automatically triggers a GitHub Actions workflow that compiles **every single source file** in the repository.

**What gets checked:**
- All `.cpp` files are compiled with `g++ -std=c++17 -fsyntax-only`
- All `.java` files are compiled with `javac` (JDK 17)
- Compiled `.class` files are cleaned up after each check
- The workflow fails immediately if any file does not compile

This ensures OOPverse is always in a **100% build-safe state** and can be trusted as a reliable reference.

**Workflow file:** `.github/workflows/compile_check.yml`

---

## 🙏 Acknowledgements

The code examples, concepts, and learning structure throughout OOPverse are largely inspired by and in many cases directly derived from the lecture materials, slides, and teachings of the faculty members of the **Department of Computer Science & Engineering, Bangladesh University of Engineering and Technology (BUET)**. Their structured and rigorous approach to teaching Object-Oriented Programming formed the academic foundation upon which this entire repository is built.

Sincere gratitude to all the instructors whose guidance — both inside and outside the classroom — made this work possible.

---

## 📄 Reference Material

The repository includes **`Materials/OOP QB BUET_TF.pdf`** — a curated OOP question bank made by BUET CSE'24 students. It is useful for exam preparation and self-assessment alongside the code examples.

---

## 👨‍💻 Creator

| | |
|---|---|
| **Name** | Badhon Pain |
| **Institution** | Bangladesh University of Engineering and Technology (BUET) |
| **Department** | Computer Science & Engineering |
| **GitHub** | [@badhonpain](https://github.com/badhonpain) |
| **LinkedIn** | [Badhon Pain](https://www.linkedin.com/in/badhon-pain-634341378/) |

OOPverse was designed and developed as a structured reference workspace with a focus on pedagogical clarity, bilingual coverage, and production-quality tooling. Every module, example, and runner in this repository reflects a commitment to making OOP concepts accessible, comparable, and immediately runnable.
