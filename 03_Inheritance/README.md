# Module 03 — Inheritance

## Overview
Reuse and extension through inheritance hierarchies. Explores single, multi-level, multiple, hierarchical, and hybrid inheritance patterns. Demonstrates virtual functions, abstract classes, type casting, and proper use of the `super`/parent class.

## Core Concepts
- **Single Inheritance**: One base class
- **Multi-level Inheritance**: Chain of inheritance
- **Multiple Inheritance**: From two or more bases (C++ only)
- **Hierarchical Inheritance**: One base, many derived
- **Hybrid Inheritance**: Mix of above patterns
- **Virtual Functions**: Runtime polymorphism preparation
- **Abstract Classes & Pure Virtual**: Enforce contracts
- **Type Casting**: `static_cast`, `dynamic_cast` (C++); upcasting, downcasting (Java)
- **`super` Keyword (Java) / Parent Class Access (C++)**: Call base implementation

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Multiple Inheritance** | Supported directly | Not allowed; use interfaces instead |
| **Virtual Keyword** | Explicit `virtual` required | Automatic; all methods virtual by default |
| **Access Levels** | public/protected/private inheritance modes | Single extends; inheritance is always public-like |
| **Abstract Classes** | `= 0` pure virtual functions | `abstract class` keyword |
| **Interface** | Pure virtual classes; no data | `interface` keyword; separate concept |
| **Type Casting** | `dynamic_cast<>()`, `static_cast<>()` | Direct cast or `instanceof` check |
| **Virtual Destructors** | Must be explicit for polymorphic base | Automatic; not explicitly needed |

## Notable Features

### C++ Highlights
✓ **Multiple Inheritance**: Solve complex problems; beware the diamond problem  
✓ **Explicit Virtual Keyword**: Clear intent when methods are polymorphic  
✓ **Public/Protected/Private Inheritance**: Fine-grained access control  
✓ **`dynamic_cast`**: Safe runtime type checking  
✓ **Virtual Destructors**: Ensure derived resources are cleaned up  

### Java Highlights
✓ **Interfaces**: Clean multiple-inheritance alternative without complexity  
✓ **Default Virtual**: No need for `virtual` keyword; simpler design  
✓ **Default Methods (Java 8+)**: Interfaces can provide implementations  
✓ **Private Methods (Java 9+)**: Interface helper methods for code reuse  
✓ **`super` Keyword**: Explicit parent method/field access  

## File Organization

### C++ (cpp/)
- `single_inheritence.cpp` — Basic inheritance
- `multi_level_inheritence.cpp` — Chain of inheritance
- `multiple_inheritence.cpp` — Two or more bases
- `hierarchial_inheritence.cpp` — One base, many derived
- `hybrid_inheritence.cpp` — Mixed patterns (diamond problem)
- `method_overriding.cpp` — Override base methods
- `virtual_destructor.cpp` — Proper cleanup in polymorphic hierarchies
- `pure_virtual_method.cpp` — Abstract base classes
- `run_time_polymorphism.cpp` — Base pointers/references
- `*_cast.cpp` — Type casting examples

### Java (java/)
- `SingleInheritance.java` — Basic extends
- `MultiLevelInheritance1/2.java` — Inheritance chains
- `InterfaceDemo_AllInOne.java` — Interface implementation
- `AbstractClass.java`, `AbstractDemo.java` — Abstract classes
- `MethodOverriding.java` — @Override annotation
- `DynamicMethodDispatch.java` — Runtime dispatch
- `SuperTest.java`, `UseSuper.java` — super keyword
- `FinalInheritance.java` — Prevent inheritance
- `InterfaceDefaultMethodTest.java`, `InterfaceStaticMethodTest.java` — Java 8+ features
- `InterfacePrivateMethodTest.java` — Java 9+ features

## Learning Path
1. Master single inheritance (parent-child relationship)
2. Build multi-level chains (grandparent → parent → child)
3. Use multiple inheritance wisely (C++); prefer interfaces (Java)
4. Understand virtual functions and runtime dispatch
5. Create abstract bases to enforce contracts
6. Practice downcasting and type checking safely

## Key Takeaways
✓ **Inheritance Hierarchies**: Enable code reuse and polymorphic behavior  
✓ **Virtual Functions**: Essential for runtime polymorphism  
✓ **Abstract Bases**: Define contracts that derived classes must fulfill  
✓ **Type Safety**: Use `dynamic_cast` (C++) and `instanceof` (Java) when downcasting  
✓ **Interfaces (Java)**: Prefer composition of interfaces over complex multiple inheritance  

---
*Inheritance sets the stage for polymorphism and flexible, extensible designs.*

This module covers all forms of inheritance: single, multi-level, multiple, hierarchical, and hybrid. It also explores method overriding, virtual functions, virtual destructors, and type casting. C++ supports multiple inheritance directly, while Java uses interfaces to achieve similar flexibility.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Single inheritance | `class B : public A` | `class B extends A` |
| Multiple inheritance | Supported directly | Not supported — use interfaces |
| Interfaces | Pure virtual classes (abstract) | `interface` keyword |
| Virtual functions | Explicit `virtual` keyword | All methods are virtual by default |
| Virtual destructors | Must declare explicitly | Not needed (GC handles cleanup) |
| Type casting | `static_cast`, `dynamic_cast`, `const_cast`, `reinterpret_cast` | `instanceof` + explicit cast |
| Constructor chaining | Initializer lists | `super()` calls |

## Key Differences

- C++ supports true multiple inheritance with diamond problem resolution via `virtual` base classes
- Java uses `extends` (single class) + `implements` (multiple interfaces) to avoid diamond ambiguity
- C++ requires `virtual` keyword for polymorphic behavior; Java methods are virtual by default
- C++ virtual destructors are critical for proper cleanup; Java's GC eliminates this concern
- C++ offers four specialized cast operators; Java uses a single cast syntax with `instanceof`

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `single_inheritence.cpp` | Single inheritance basics |
| `multi_level_inheritence.cpp` | Multi-level inheritance chain |
| `multiple_inheritence.cpp` | Multiple inheritance from two+ bases |
| `hierarchial_inheritence.cpp` | Hierarchical inheritance tree |
| `hybrid_inheritence.cpp` | Hybrid (diamond) inheritance |
| `inheritence_1.cpp` — `inheritence_4.cpp` | Progressive inheritance examples |
| `modes_of_inheritence_2.cpp` | Public, protected, private inheritance |
| `Basic_Syntax.cpp` | Inheritance syntax fundamentals |
| `Method_Overriding.cpp` | Overriding base class methods |
| `ConstructorChaining.cpp` | Constructor call order in hierarchies |
| `Virtual_Destructor.cpp` | Virtual destructor necessity |
| `Pure_virtual_Method.cpp` | Pure virtual / abstract methods |
| `RunTimePolymorphism.cpp` | Runtime polymorphism via base pointers |
| `Shape.cpp` | Shape hierarchy example |
| `Student.cpp` | Student class hierarchy |
| `Practice.cpp` | Practice problems |
| `Type Casting/` | `static_cast`, `dynamic_cast`, `const_cast`, `reinterpret_cast` |

### Java (`java/`)

| File | Description |
|------|-------------|
| `SingleInheritance.java` | Single inheritance with `extends` |
| `MultiLevelInheritance.java` | Multi-level inheritance chain |
| `InterfaceDemo.java` | Interfaces as a multiple-inheritance alternative |
| `AbstractClass.java` | Abstract classes and methods |
| `MethodOverriding.java` | `@Override` annotation and behavior |
