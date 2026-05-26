# OOPverse 🌌

> A premium, interactive, bilingual (C++ & Java) workspace covering 13 progressive modules of Object-Oriented Programming (OOP) — from structs to networking, generics to multithreading.

[![C++17](https://img.shields.io/badge/C%2B%2B-17-blue?style=for-the-badge&logo=cplusplus)](https://isocpp.org/)
[![Java17](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)](https://openjdk.org/)
[![CI](https://img.shields.io/github/actions/workflow/status/badhonpain/OOPverse/compile_check.yml?style=for-the-badge&logo=github-actions)](https://github.com/badhonpain/OOPverse/actions)

---

## 🚀 The OOPverse Interactive Runner

OOPverse comes with a beautiful, cross-platform interactive command line runner! No need to type long compilation commands or search for paths. 

```bash
# On Windows (PowerShell)
.\play.ps1

# On Linux / macOS (Bash)
./play.sh
```

### How it works:
1. **Browse**: Simply use the interactive menu to select one of the 13 modules.
2. **Choose**: Choose whether you want to run the **C++** or **Java** example.
3. **Execute**: Select your file. The runner compiles it, prints the output cleanly, and automatically removes binary files afterwards to keep your workspace clean!

---

## 📚 13-Module Progressive Curriculum

The modules are designed in a strict progressive order, comparing C++ and Java paradigms side-by-side:

| # | Module | Core Concepts | C++ Highlights | Java Highlights |
|:--|:-------|:--------------|:---------------|:----------------|
| **01** | **Basics & Structs** | Primitive types, scopes, basic I/O, type casting | Struct layouts, pointers, basic namespaces | `BasicIO`, loops, `ArrayDemo`, `MethodDemo` |
| **02** | **Classes & Encapsulation** | Classes, encapsulation, object lifetimes | Rule of Three/Five, Move semantics, smart pointers | `ClassBasics`, static blocks, `AccessModifiers` |
| **03** | **Inheritance** | Single/hierarchical/multiple inheritance | Hybrid inheritance, virtual destructors, casting | `SingleInheritance`, Interfaces, `AbstractClass` |
| **04** | **Polymorphism & Overloading** | Overloading, overrides, virtual tables | Custom operator overloading, explicit conversion | `MethodOverloading`, dynamic dispatch, upcasting |
| **05** | **Templates & Generics** | Compile-time generic programming | Monomorphization, Class & function templates | Type erasure, bounded wildcards (`extends`/`super`) |
| **06** | **STL & Collections** | Containers, iterators, standard algorithms | `vector`, `list`, `map`, custom lambda sorting | `ArrayList`, `HashMap`, `HashSet`, Streams API |
| **07** | **I/O & Manipulators** | Standard streams and text formatting | Formatting manipulators, stream flags, inline | `FormattedOutput`, `ScannerIO`, `StringBuilder` |
| **08** | **Exception Handling** | Error propagation, safe program teardown | Uncaught exceptions, noexcept, polymorphism | `TryCatchDemo`, Checked exceptions, try-with-resources |
| **09** | **File Operations** | Read/write text and binary file operations | Stream buffers, random access seekg/seekp | `BufferedReader`, `SerializationDemo` |
| **10** | **Nested Classes & Enums** | Scoped structures and class encapsulation | Nested struct scopes, scoped enum classes | Inner classes, `AnonymousClass`, enums with fields |
| **11** | **Multithreading** | Parallel execution and synchronization | Mutex, locks, condition variables, lambdas | JVM monitor synchronization, wait/notify, `join` |
| **12** | **Networking** | Socket programming and network streams | POSIX sockets, Winsock2 configuration | `ServerSocket`, client-server message loop |
| **13** | **Command-Line Arguments** | Run-time user inputs and flag parsing | `argc`/`argv` parsing, CLI config structures | `String[] args` parsing, input validation |

---

## 🛡️ Built-in CI/CD Verification

Every single commit is automatically compiled and verified on a continuous integration pipeline:
- **C++**: Checked using `g++ -std=c++17`
- **Java**: Checked using `javac` (JDK 17)

This ensures that the repository remains 100% build-safe and acts as a bulletproof reference sandbox.

---

## 🎨 Contributor & Creator

<div align="center">

```
  🌌 OOPverse — Engineered for visual & pedagogical excellence.
```

### **Badhon Pain**
#### **BUET CSE '24**
*Department of Computer Science & Engineering*
*Bangladesh University of Engineering and Technology*

---

*"Beautiful code is its own reward, but structured knowledge changes lives."*

</div>