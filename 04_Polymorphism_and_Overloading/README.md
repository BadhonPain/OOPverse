# Module 04 — Polymorphism and Overloading

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
