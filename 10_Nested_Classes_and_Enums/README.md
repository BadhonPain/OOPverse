# Module 10 — Nested Classes and Enums

This module covers nested (inner) classes and enumerations. Both languages support nesting classes within classes, but Java offers richer enum types that can contain fields, methods, and constructors. C++ provides scoped `enum class` for type-safe enumerations.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Nested classes | Defined inside enclosing class | Static inner, inner, local, anonymous classes |
| Outer access | No implicit access to outer members | Non-static inner classes access outer `this` |
| Enums | `enum` (unscoped) and `enum class` (scoped) | Full classes with fields, methods, constructors |
| Enum values | Integer constants | Object instances |
| Enum methods | Not supported (use switch) | Supported — enums can have behavior |
| Enum iteration | Not built-in | `values()` method returns all constants |

## Key Differences

- Java has four kinds of nested classes (static, inner, local, anonymous); C++ has one
- Java inner classes hold a reference to the enclosing instance; C++ nested classes do not
- Java enums are full objects with methods and can implement interfaces
- C++ `enum class` provides type safety and scoping but no methods
- Java anonymous classes are largely replaced by lambdas since Java 8

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `nested_classes_and_enums.cpp` | Nested classes and scoped enums |

### Java (`java/`)

| File | Description |
|------|-------------|
| `NestedClasses.java` | Static inner, inner, local, and anonymous classes |
| `EnumDemo.java` | Enums with fields, methods, and constructors |
