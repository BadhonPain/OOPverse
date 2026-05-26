# Module 04 — Polymorphism & Overloading

## Overview
Compile-time (overloading) and runtime (virtual functions) polymorphism. Demonstrates operator overloading, method overloading, function resolution, and extensible type systems through inheritance and interfaces.

## Core Concepts
- **Function/Method Overloading**: Same name, different signatures
- **Operator Overloading**: Custom meaning for +, -, *, etc.
- **Method Overriding**: Replacing base class implementation
- **Virtual Functions**: Dynamic dispatch at runtime
- **Abstract Base Classes**: Define behavior contracts
- **Polymorphic Collections**: Containers of base pointers/references
- **Autoboxing/Unboxing**: Automatic type conversion (Java)

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Operator Overloading** | Full support for most operators | Only `+` for strings; use methods instead |
| **Method Resolution** | Overload resolution at compile-time | Single dispatch based on runtime type |
| **Virtual Keyword** | Explicit; must specify for polymorphism | Implicit; all instance methods virtual |
| **Autoboxing** | No equivalent; use std::variant or templates | Automatic int ↔ Integer, double ↔ Double |
| **Type Casting** | `static_cast`, `dynamic_cast` for polymorphic | `(Type)` cast; check with `instanceof` |
| **Const Correctness** | `const` methods and parameters | No const equivalent |

## Notable Features

### C++ Highlights
✓ **Rich Operator Overloading**: Custom + operator for complex numbers, vectors, etc.  
✓ **Explicit Virtual Keyword**: Clear intent; only polymorphic where marked  
✓ **Compile-Time Overload Resolution**: Predictable, no runtime surprise  
✓ **Copy Assignment Operator**: Full control over object assignment semantics  
✓ **User-Defined Type Conversions**: Implicit or explicit type coercion  

### Java Highlights
✓ **Simplicity**: No operator overloading; consistent method-based API  
✓ **Autoboxing**: Seamless primitive ↔ wrapper conversions  
✓ **Clean Polymorphism**: Virtual by default; focus on behavior contracts  
✓ **Enhanced Dispatch**: Lambdas and functional interfaces for flexible behavior  
✓ **Reflection**: Dynamic invocation and type discovery at runtime  

## File Organization

### C++ (cpp/)
- `function_overloading.cpp` — Multiple signatures
- `constructor_overloading.cpp` — Constructor variants
- `operator_overloading.cpp`, `complex_operator_overloading.cpp` — Custom operators
- `unary_operator_0*.cpp`, `binary_operator_0*.cpp` — Detailed operator types
- `assignment_operator.cpp` — Copy assignment
- `type_conversion_*.cpp`, `conversion_function.cpp` — User-defined conversions
- `virtual_functions.cpp`, `abstraction.cpp` — Runtime polymorphism
- `payment_system.cpp`, `university_system.cpp` — Real-world examples
- `this_ptr.cpp` — Implicit object passing

### Java (java/)
- `MethodOverloading.java` — Method name reuse
- `RuntimePolymorphism.java` — Dynamic dispatch
- `TypeCasting.java` — Upcasting and downcasting
- `AbstractPayment.java` — Polymorphic payment system
- `OperatorStyle.java` — Method-based alternatives
- `AutoboxingDemo.java` — Primitive ↔ wrapper conversion

## Learning Path
1. Master function/method overloading (compile-time polymorphism)
2. Understand operator overloading (C++ advantage)
3. Learn virtual functions and runtime dispatch
4. Build polymorphic hierarchies (payment systems, shapes, etc.)
5. Practice downcasting safely with `dynamic_cast`/`instanceof`
6. Leverage autoboxing (Java) for seamless type conversion

## Key Takeaways
✓ **Overloading**: Enable multiple signatures for flexible APIs  
✓ **Operator Overloading (C++)**: Make custom types feel like built-ins  
✓ **Virtual Functions**: Enable extensible, maintainable designs  
✓ **Polymorphic Collections**: Store mixed types in inheritance hierarchies  
✓ **Autoboxing (Java)**: Simplify wrapper ↔ primitive conversion  

---
*Polymorphism enables flexible, extensible software architecture.*

This module covers compile-time and runtime polymorphism, operator overloading, function/method overloading, type conversion, and abstract classes. C++ provides extensive operator overloading capabilities, while Java achieves similar design patterns through method-based approaches.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Operator overloading | Full support (`+`, `-`, `<<`, `[]`, etc.) | Not supported (except `+` for strings) |
| Method overloading | Supported | Supported |
| Runtime polymorphism | `virtual` functions + base pointers | All non-static methods are polymorphic |
| Abstract classes | Classes with pure virtual methods (`= 0`) | `abstract` keyword |
| Type conversion | User-defined conversion operators | No implicit conversion — use methods |
| `this` pointer | Explicit `this->` pointer | Implicit `this` reference |

## Key Differences

- C++ allows overloading almost all operators; Java prohibits user-defined operator overloading
- C++ uses `virtual` + `= 0` for abstract methods; Java uses the `abstract` keyword
- C++ supports implicit type conversion via conversion operators; Java requires explicit methods
- C++ unary/binary operator overloading can be member or non-member functions
- Java's `@Override` annotation provides compile-time safety that C++ `override` keyword mirrors

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `function_overloading.cpp` | Function overloading by parameter types |
| `constructor_overloading.cpp` | Constructor overloading |
| `Method_Overloading.cpp` | Method overloading in classes |
| `function_overriding.cpp` | Function overriding basics |
| `Method_Overriding.cpp` | Method overriding with `virtual` |
| `operator_overloading.cpp` | Basic operator overloading |
| `OperatorOverloading.cpp` | Extended operator overloading example |
| `Unary_Operator_01.cpp` — `Unary_Operator_06.cpp` | Unary operator overloading series |
| `Binary_Operator_01.cpp`, `Binary_Operator_02.cpp` | Binary operator overloading |
| `Assignment_Operator.cpp` | Assignment operator overloading |
| `Complex.cpp` | Complex number class with operators |
| `Type_Conversion_1.cpp`, `Type_Conversion_2.cpp` | User-defined type conversions |
| `Conversion_Function.cpp` | Conversion operator implementation |
| `virtual_functions.cpp` | Virtual function polymorphism |
| `abstraction.cpp` | Abstract class design |
| `PaymentSystem.cpp` | Polymorphic payment system |
| `this_ptr.cpp` | `this` pointer usage |
| `Implicit_passing.cpp` | Implicit object passing |
| `Access_using_this.cpp` | Member access via `this` |

### Java (`java/`)

| File | Description |
|------|-------------|
| `MethodOverloading.java` | Method overloading by signature |
| `RuntimePolymorphism.java` | Dynamic dispatch with inheritance |
| `TypeCasting.java` | Upcasting and downcasting |
| `AbstractPayment.java` | Abstract class payment system |
| `OperatorStyle.java` | Method-based operator alternatives |
