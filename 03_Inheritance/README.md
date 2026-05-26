# Module 03 — Inheritance

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
