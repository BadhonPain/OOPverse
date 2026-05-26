# Module 05 — Templates & Generics

## Overview
Generic programming for code reuse across types. C++ templates use compile-time code generation (monomorphization); Java generics use type erasure at runtime. Both enable type-safe containers and algorithms.

## Core Concepts
- **Function Templates**: Generic functions working with multiple types
- **Class Templates**: Generic data structures (Stack, Queue, etc.)
- **Template Specialization**: Custom implementations for specific types
- **Type Parameters**: Placeholder types in generic code
- **Constraints/Bounds**: Limit type parameters (Java wildcards, C++ concepts)
- **Wildcards**: Upper/lower bounds on generic types (Java)
- **Comparable/Comparator**: Generic comparison logic
- **Generic Algorithms**: Sort, find, etc. on templated containers

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Code Generation** | Monomorphization (separate code per type) | Type erasure (single compiled code) |
| **Primitives** | Templates work directly on int, double, etc. | Primitives require wrapper classes |
| **Specialization** | Partial specialization supported | Bounded wildcards only |
| **Performance** | Monomorphization → larger binary, faster code | Type erasure → smaller code, runtime checks |
| **Wildcards** | None; full type parameters | `?`, `? extends T`, `? super T` |
| **Constraints** | Concepts (C++20); duck typing | Interface bounds; `T extends Comparable` |

## Notable Features

### C++ Highlights
✓ **Template Specialization**: Optimize for specific types (e.g., `std::vector<bool>`)  
✓ **Monomorphization**: Full type information at every call site; zero abstraction cost  
✓ **Variadic Templates**: Handle arbitrary numbers of parameters  
✓ **SFINAE**: Enable/disable templates based on type properties  
✓ **Concepts (C++20)**: Compile-time constraints on template parameters  

### Java Highlights
✓ **Type Erasure**: Simpler compiler; no code bloat  
✓ **Bounded Wildcards**: Flexible generic APIs with clear contracts  
✓ **Wrapper Classes**: Seamless use of primitives via autoboxing  
✓ **Reflection**: Inspect generic types at runtime (with limitations)  
✓ **Streams API**: Functional-style generic data processing  

## File Organization

### C++ (cpp/)
- `template_1.cpp`, `template_2.cpp`, `template_3.cpp` — Template fundamentals
- `function_template.cpp` — Generic functions
- `class_template1.cpp`, `class_template2.cpp`, `class_template3.cpp` — Generic classes
- `inheritence1.cpp` — Template inheritance patterns
- `generic_sort.cpp` — Generic sorting with templates

### Java (java/)
- `GenericClass.java` — Generic class with type parameters
- `GenericMethod.java` — Generic methods and bounded types
- `GenericsWithMultiType.java` — Multiple type parameters
- `WildcardDemo.java` — Wildcards and bounds
- `GenericSort.java` — Generic sorting with Comparable

## Learning Path
1. Understand template basics (function templates)
2. Build generic classes (Stack, Queue templates)
3. Apply template specialization (C++)
4. Learn bounded type parameters (Java `extends`)
5. Master wildcards (Java `?`, `? extends`, `? super`)
6. Practice generic algorithms (sorting, searching)

## Key Takeaways
✓ **Templates**: Enable type-safe reuse without runtime overhead  
✓ **Type Erasure (Java)**: Simpler model; use wildcards for flexibility  
✓ **Monomorphization (C++)**: Full optimization; larger binaries  
✓ **Bounds**: Constrain type parameters to ensure valid operations  
✓ **Generic Algorithms**: Sort, find, etc. work uniformly across types  

---
*Templates and generics are foundational to building reusable, type-safe libraries.*

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
