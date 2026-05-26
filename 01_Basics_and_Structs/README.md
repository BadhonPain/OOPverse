# Module 01 — Basics and Structs

This module covers foundational programming constructs: basic I/O, arrays, structs, enums, and namespaces. These building blocks are essential before diving into full object-oriented programming. Both C++ and Java share similar syntax roots but diverge in how they handle low-level constructs like structs and enums.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Structs | First-class `struct` keyword, similar to classes | No structs — use classes or records |
| Enums | Basic enums and scoped `enum class` | Full enum classes with methods and fields |
| Namespaces | `namespace` keyword | `package` declarations |
| Arrays | Raw C-style arrays and `std::array` | Managed arrays with bounds checking |
| Entry point | `int main()` free function | `public static void main(String[] args)` |

## Key Differences

- C++ structs are nearly identical to classes (default `public`); Java has no struct equivalent
- C++ `enum class` provides type safety; Java enums are full objects with constructors and methods
- C++ namespaces are flexible and can be nested/reopened; Java packages map to directory structure
- C++ arrays decay to pointers; Java arrays are objects with a `.length` property

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `01_struct.c` | Basic C-style struct usage |
| `02_struct_1.cpp` | Struct fundamentals in C++ |
| `03_struct_2.cpp` | Advanced struct usage |
| `04_class.cpp` | Transition from struct to class |
| `06_Polymorphism.cpp` | Early polymorphism preview |
| `array_with_objects.cpp` | Arrays containing struct/class objects |
| `basic_2.cpp` | Basic syntax and I/O |
| `basic_syntax.cpp` | Core C++ syntax demonstration |

### Java (`java/`)

| File | Description |
|------|-------------|
| `BasicIO.java` | Standard input/output operations |
| `ArrayDemo.java` | Array creation, traversal, and manipulation |
| `MethodDemo.java` | Method declarations and invocations |
