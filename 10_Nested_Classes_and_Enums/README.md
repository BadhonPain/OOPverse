# Module 10 — Nested Classes & Enums

## Overview
Inner classes, nested classes, anonymous classes, and enum types. Explores scoping, accessibility, and advanced enum features. Demonstrates how nested constructs enable cleaner, more encapsulated designs.

## Core Concepts
- **Static Nested Classes (C++)**: Nested structures/classes without instance dependency
- **Inner Classes (Java)**: Access outer instance; implicit `this` reference
- **Local Classes**: Defined inside methods; limited scope
- **Anonymous Classes**: Inline class definitions for one-time use
- **Enums**: Type-safe enumeration with methods, constructors, and fields
- **Enum Methods**: Custom behavior for each constant
- **Nested Interfaces**: Interface definitions inside classes
- **Access Control**: Scoping and visibility of nested entities

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Nested Classes** | One type; can be accessed statically | Four types: static inner, inner, local, anonymous |
| **Instance Access** | No implicit outer reference | Inner classes can access outer `this` |
| **Encapsulation** | Same scope as outer class | Can be private; better encapsulation |
| **Enums** | `enum class` (type-safe) only | Full class-like objects with methods |
| **Enum Methods** | Methods via `enum class` | All enums support methods |
| **Anonymous** | Lambdas (C++11+) for single-use | Anonymous inner classes |
| **Syntax** | `OuterClass::NestedClass` | `OuterClass.NestedClass` |

## Notable Features

### C++ Highlights
✓ **Scoped Enums**: `enum class` prevents name collisions and implicit int conversions  
✓ **Nested Class Scope**: Controlled via private/public access specifiers  
✓ **Lambda Expressions**: Modern alternative to function objects  
✓ **Enum Underlying Type**: Specify `enum class Type : unsigned char`  
✓ **Static Nested Access**: Use qualified names `Outer::Nested`  

### Java Highlights
✓ **Inner Class Binding**: Access enclosing instance fields and methods  
✓ **Anonymous Classes**: Inline implementation for interfaces/abstract classes  
✓ **Local Classes**: Hide classes used only within a method  
✓ **Enum Richness**: Enums with fields, methods, constructors, and generics  
✓ **Nested Interfaces**: Inner interfaces for logical grouping  

## File Organization

### C++ (cpp/)
- `nested_classes_and_enums.cpp` — Nested classes and scoped enums

### Java (java/)
- `NestedClasses.java` — Static inner, inner, local, anonymous classes
- `EnumDemo.java` — Enum methods, constructors, inheritance
- `EnumBasicDemo.java` — Basic enum usage
- `EnumConstructor.java` — Enum constructor patterns

## Learning Path
1. Understand nested class scope and access
2. Create static nested classes for logical grouping
3. Use inner classes to access outer state
4. Define anonymous classes for one-time implementations
5. Build enums with custom methods and fields
6. Practice enum iteration and value lookup

## Key Takeaways
✓ **Nested Classes**: Improve encapsulation and logical organization  
✓ **Static Nested**: Used when no outer instance access needed  
✓ **Inner Classes (Java)**: Enable closure-like behavior over outer state  
✓ **Enums as Objects (Java)**: Rich type-safe alternatives to static constants  
✓ **Anonymous Classes**: Quick implementations without named class definitions  

---
*Nested constructs and enums enable flexible, well-organized code structures.*

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
