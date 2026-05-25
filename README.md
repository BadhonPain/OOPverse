# OOPverse

> A structured, 9-stage C++ learning workspace — from structs to STL, templates to file I/O.

![C++17](https://img.shields.io/badge/C%2B%2B-17-blue?style=flat-square&logo=cplusplus)
![Modules](https://img.shields.io/badge/modules-9-teal?style=flat-square)
![Tutorials](https://img.shields.io/badge/tutorials-5-orange?style=flat-square)
![Level](https://img.shields.io/badge/level-beginner%20→%20advanced-gray?style=flat-square)

---

## What this is

OOPverse is a self-contained C++ learning workspace built around a **9-stage progressive curriculum**. Each module introduces a new layer of complexity — you start with raw structs and end with file I/O, exception handling, and the full STL. Five supplementary tutorial files cover Modern C++ idioms (smart pointers, move semantics, lambdas) with deep inline commentary, written as reference material you can return to repeatedly.

**Who it's for:** Students working through OOP for the first time, developers brushing up on Modern C++11/14/17, or anyone who wants a clean, structured reference they can compile and run locally.

---

## Curriculum

The modules are designed to be worked through in order. Each one builds directly on the last.

| # | Module | Core Topics |
|:--|:-------|:-----------|
| 01 | **Basics & Structs** | C-style `struct` vs. C++ `class`, memory layouts, basic syntax, data representation |
| 02 | **Classes & Encapsulation** | Constructors/destructors, static members, class nesting, deep vs. shallow copy, real-world assignments (`TollBooth.cpp`) |
| 03 | **Inheritance** | Single, multiple, multi-level, hierarchical, and hybrid models. Constructor chaining, virtual destructors, C++ type casting (`static_cast`, `dynamic_cast`, `const_cast`, `reinterpret_cast`) |
| 04 | **Polymorphism & Overloading** | Compile-time polymorphism (function overloading), run-time polymorphism (virtual functions, abstract classes), operator overloading |
| 05 | **Templates & Generics** | Function templates, class templates, generic sorting algorithms |
| 06 | **STL** | Sequential containers (`vector`, `list`, `deque`), associative containers (`map`, `set`), standard algorithms |
| 07 | **I/O & Manipulators** | Stream formatting, width/precision/fill flags, file stream states, inline functions |
| 08 | **Exception Handling** | `try`/`catch` blocks, exception propagation, exception-safe code design |
| 09 | **File Operations** | Text and binary file I/O, sequential and random access (`seekg`/`seekp`), stream state validation |

---

## Modern C++ Tutorials

Five standalone reference files with thorough inline commentary covering intermediate and advanced C++17 idioms. These sit alongside the curriculum modules and are worth revisiting even after you've finished the core path.

| Topic | File | What you'll learn |
|:------|:-----|:------------------|
| **Memory Management** | `02_Classes_and_Encapsulation/smart_pointers.cpp` | `unique_ptr`, `shared_ptr`, `weak_ptr`, RAII principles, breaking cyclic references |
| **Move Semantics** | `02_Classes_and_Encapsulation/rule_of_five.cpp` | Lvalue vs. rvalue references (`&&`), `std::move`, implementing the Rule of Five |
| **Custom Exceptions** | `08_Exception_Handling/custom_exceptions.cpp` | Defining exception hierarchies, overriding `what() noexcept`, catching polymorphically by reference |
| **Modern STL & Lambdas** | `06_STL/stl_algorithms_lambdas.cpp` | Lambda syntax `[captures](params) -> type {}`, `std::sort` with custom comparators, `std::find_if`, `std::transform` |
| **Hash Tables** | `06_STL/unordered_containers.cpp` | `unordered_map` vs. `map`, hash tables vs. balanced trees, O(1) vs. O(log N) benchmarks |

---

## Compile & Run

Any file in the repository compiles the same way. You need `g++` with C++17 support.

**Step 1 — Compile**

```bash
g++ -std=c++17 <filename>.cpp -o <output_name>
```

**Step 2 — Run**

```bash
# Linux / macOS
./<output_name>

# Windows (PowerShell)
.\<output_name>.exe
```

**Example — running the smart pointers tutorial**

```bash
g++ -std=c++17 02_Classes_and_Encapsulation/smart_pointers.cpp -o smart_pointers

# Linux / macOS
./smart_pointers

# Windows
.\smart_pointers.exe
```

---

## Design Philosophy

**Linear by design.** Numbered modules enforce a natural progression — there's no guessing what to study next. Each stage introduces only what the previous one has prepared you for.

**Modern idioms over legacy patterns.** The codebase consistently favors C++11/14/17 constructs: smart pointers over raw `new`/`delete`, range-based loops, `auto`, move semantics, and lambdas. Legacy patterns appear only when teaching them explicitly.

**Commentary as documentation.** The five tutorial files are written to be read, not just run. Inline comments explain the *why* behind each construct, not just the *what*.

**Zero binary clutter.** Compiled binaries are excluded via `.gitignore`. The repository stays source-only, making diffs clean and history readable.

---

## Repository Structure

```
OOPverse/
├── 01_Basics_and_Structs/
├── 02_Classes_and_Encapsulation/
│   ├── smart_pointers.cpp          ← tutorial
│   └── rule_of_five.cpp            ← tutorial
├── 03_Inheritance/
├── 04_Polymorphism_and_Overloading/
├── 05_Templates_and_Generics/
├── 06_STL/
│   ├── stl_algorithms_lambdas.cpp  ← tutorial
│   └── unordered_containers.cpp    ← tutorial
├── 07_IO_and_Manipulators/
├── 08_Exception_Handling/
│   └── custom_exceptions.cpp       ← tutorial
├── 09_File_Operations/
└── .gitignore
```