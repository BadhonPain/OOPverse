# Module 02 — Classes & Encapsulation

## Overview
Deep dive into object-oriented design: class structure, data hiding, access modifiers, constructors, destructors, lifecycle management, and memory semantics. Contrasts manual C++ memory management with Java's garbage collection.

## Core Concepts
- **Classes & Objects**: Blueprint for objects
- **Constructors & Destructors**: Initialization and cleanup
- **Access Control**: public, private, protected, package-private
- **Encapsulation**: Data hiding through getters/setters
- **Static Members**: Shared across all instances
- **The `this` Pointer/Reference**: Access to current object
- **Object Lifecycle**: Creation, usage, destruction

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Memory** | Manual (`new`/`delete`); can use stack | Automatic garbage collection |
| **Destructors** | Explicit cleanup required (`~ClassName`) | No destructors; use `finally` or try-with-resources |
| **Resource Management** | RAII pattern; Rule of 5 | No RAII; relies on GC |
| **Static** | Shared across instances; linkage control | Shared across instances; simple model |
| **Const** | Rich const semantics (`const this`) | Final references only |
| **Copy Semantics** | Shallow/deep copy explicit (copy constructor) | Only shallow reference copying |
| **Smart Pointers** | `unique_ptr`, `shared_ptr` for safety | No equivalent; GC handles all |

## Notable Features

### C++ Highlights
✓ **RAII (Resource Acquisition Is Initialization)**: Automatic cleanup via destructors  
✓ **Rule of 5**: Copy/move constructors and assignment ensure correct semantics  
✓ **Const Correctness**: Prevents unintended modifications to const objects  
✓ **Smart Pointers**: Type-safe memory management without manual delete  
✓ **Copy vs Move**: Differentiate between expensive copies and efficient moves  

### Java Highlights
✓ **Simplicity**: No manual memory management or destructors  
✓ **Consistency**: Garbage collection always works (predictable cleanup)  
✓ **Try-with-resources**: Automatic closing of resources (Java 7+)  
✓ **Shallow Copying**: Simpler default semantics (references, not value copies)  

## File Organization

### C++ (cpp/)
- `constructor.cpp`, `constructor_overloading.cpp` — Constructor varieties
- `copy_constructor.cpp`, `deep_copy.cpp`, `shallow_copy.cpp` — Copy semantics
- `destructor.cpp` — Cleanup and finalization
- `encapsulation.cpp` — Data hiding patterns
- `static_in_variables_1/2.cpp`, `static_in_objects.cpp` — Static members
- `rule_of_five.cpp` — Modern C++ resource management
- `smart_pointers.cpp` — Safe memory with unique_ptr, shared_ptr
- `this_operator.cpp`, `nesting_of_methods.cpp` — Method chaining
- `dangling_pointer.cpp` — Common pitfalls
- `object_assignment_*`, `object_passing_*`, `object_returning_*` — Object mechanics

### Java (java/)
- `ClassBasics.java` — Class structure and fields
- `StaticDemo.java` — Static members across instances
- `CopyConstructor.java` — Copy patterns in Java
- `AccessModifiers.java` — public/private/protected scoping
- `FriendlyAccess.java` — Package-level access

## Learning Path
1. Understand class construction and initialization
2. Master access modifiers and encapsulation
3. Learn static members and class-level data
4. Study object lifecycle (creation → usage → cleanup)
5. Compare C++ RAII vs Java garbage collection

## Key Takeaways
✓ **Encapsulation**: Hide implementation details behind public interfaces  
✓ **RAII (C++)**: Ensure resources are always cleaned up properly  
✓ **Garbage Collection (Java)**: Simplifies memory management at the cost of less predictable timing  
✓ **Static Members**: Share data and behavior across all instances  

---
*Solid understanding of encapsulation is critical before moving to inheritance.*

This module explores class design, constructors, destructors, encapsulation, and memory management. It covers the full lifecycle of objects from creation to destruction, including copy/move semantics and smart pointers. Java and C++ take fundamentally different approaches to memory ownership.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Memory management | Manual (`new`/`delete`) + smart pointers | Automatic garbage collection |
| Destructors | Deterministic `~ClassName()` | `finalize()` (deprecated); use `try-with-resources` |
| Copy semantics | Copy constructor + assignment operator | `clone()` method or copy constructors by convention |
| Move semantics | Move constructor + `std::move` | No equivalent — references are lightweight |
| Access modifiers | `public`, `private`, `protected` (per-block) | `public`, `private`, `protected`, package-private |
| Friend functions | `friend` keyword grants access | No equivalent — use package-private access |
| Static members | `static` keyword in class | `static` keyword, similar usage |
| Rule of 3/5 | Must implement for resource-owning classes | Not applicable |

## Key Differences

- C++ requires explicit resource management (Rule of 3/5); Java relies on garbage collection
- C++ smart pointers (`unique_ptr`, `shared_ptr`) provide RAII; Java has no equivalent pattern
- C++ `friend` functions break encapsulation intentionally; Java uses package-level access instead
- C++ supports deep vs. shallow copy control; Java's `clone()` is shallow by default
- C++ destructors run deterministically at scope exit; Java finalization is non-deterministic

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `constructor.cpp` | Basic constructor usage |
| `constructor_overloading.cpp` | Multiple constructor signatures |
| `copy_constructor.cpp` | Copy constructor implementation |
| `deep_copy.cpp` | Deep copy vs. shallow copy |
| `shallow_copy.cpp` | Shallow copy pitfalls |
| `destructor.cpp` | Destructor behavior and ordering |
| `encapsulation.cpp` | Getters, setters, data hiding |
| `static_in_variables_1.cpp` | Static variable lifetime |
| `static_in_variables_2.cpp` | Static member variables |
| `static_in_objects.cpp` | Static members shared across objects |
| `smart_pointers.cpp` | `unique_ptr`, `shared_ptr`, `weak_ptr` |
| `rule_of_five.cpp` | Rule of 5: copy/move/destructor |
| `this_operator.cpp` | `this` pointer usage |
| `nesting_of_Methods.cpp` | Method chaining and nesting |
| `Nested_Class.cpp` | Nested class definitions |
| `DanglingPointer.cpp` | Dangling pointer demonstration |
| `TollBooth.cpp` | OOP practice problem |
| `Object_Assignment_1.cpp` | Object assignment basics |
| `Object_Assignment_Problem_2.cpp` | Assignment operator pitfalls |
| `Object_Assignment_Problem_Solution_3.cpp` | Fixing assignment issues (part 1) |
| `Object_Assignment_Problem_Solution_4.cpp` | Fixing assignment issues (part 2) |
| `Object_Passing_as_Argument_1.cpp` | Passing objects to functions |
| `Object_Passing_as_Argument_Problem_2.cpp` | Pass-by-value issues |
| `Object_Passing_as_Argument_Problem_Solution_3.cpp` | Pass-by-reference solution |
| `Object_Passing_as_Argument_Problem_Solution_4.cpp` | Move semantics solution |
| `Object_Returning_Problem_1.cpp` | Returning objects from functions |
| `Object_Returning_Problem_Solution_2.cpp` | RVO and return optimization |
| `Use_in_CPP.cpp` | `using` declarations in C++ |

### Java (`java/`)

| File | Description |
|------|-------------|
| `ClassBasics.java` | Class structure, fields, methods, constructors |
| `StaticDemo.java` | Static fields and methods |
| `CopyConstructor.java` | Copy constructor pattern in Java |
| `AccessModifiers.java` | Public, private, protected, package-private |
| `FriendlyAccess.java` | Package-level access as a friend alternative |
