# Module 05 — Templates and Generics

This module covers generic programming: C++ templates and Java generics. Both allow writing type-independent code, but they work fundamentally differently under the hood. C++ templates generate code at compile time via monomorphization, while Java generics use type erasure at runtime.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Syntax | `template <typename T>` | `<T>` with angle brackets |
| Implementation | Compile-time code generation | Type erasure at runtime |
| Primitives | Works with all types including primitives | Requires wrapper classes (`Integer`, `Double`) |
| Specialization | Full and partial specialization | No specialization — use bounded types |
| Constraints | C++20 concepts / SFINAE | Bounded wildcards (`<? extends T>`) |
| Non-type params | Supported (`template <int N>`) | Not supported |

## Key Differences

- C++ templates produce separate compiled code for each type; Java generics erase to `Object`
- C++ templates can accept non-type parameters (e.g., integers); Java generics cannot
- Java wildcards (`? extends`, `? super`) provide variance; C++ has no direct equivalent
- C++ template errors appear at instantiation (often verbose); Java generic errors are cleaner
- C++ templates work with primitives; Java requires autoboxing (`int` → `Integer`)

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `template_1.cpp` | Basic function template |
| `template_2.cpp` | Template with multiple type parameters |
| `template_3.cpp` | Template specialization |
| `Function_Template.cpp` | Function template patterns |
| `Class_Template1.cpp` | Basic class template |
| `Class_Template2.cpp` | Class template with methods |
| `Class_Template3.cpp` | Advanced class template usage |
| `Inheritence1.cpp` | Template inheritance patterns |
| `Generic_Sort.cpp` | Generic sorting with templates |

### Java (`java/`)

| File | Description |
|------|-------------|
| `GenericClass.java` | Generic class with type parameters |
| `GenericMethod.java` | Generic methods and bounded types |
| `WildcardDemo.java` | Wildcards: `?`, `? extends`, `? super` |
| `GenericSort.java` | Generic sorting with `Comparable` |
