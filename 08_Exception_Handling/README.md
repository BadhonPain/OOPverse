# Module 08 — Exception Handling

## Overview
Error propagation and recovery strategies. C++ and Java both support try-catch-throw mechanisms, but with key semantic differences. Explores custom exception classes, checked vs unchecked exceptions, and safe program teardown.

## Core Concepts
- **try-catch Blocks**: Capture and handle exceptions
- **throw Statement**: Raise exceptions explicitly
- **Custom Exceptions**: Create domain-specific error types
- **Exception Hierarchy**: Build exception classification trees
- **Checked vs Unchecked Exceptions**: Static vs runtime checking
- **finally Block/Cleanup**: Guaranteed execution regardless of exception
- **try-with-resources**: Automatic resource cleanup (Java 7+)
- **RAII (Resource Acquisition Is Initialization)**: Cleanup via destructors (C++)
- **Exception Safety Guarantees**: Strong, basic, no-throw contracts

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Throw Any Type** | Can throw any object (int, string, custom) | Must throw `Throwable` subclasses |
| **Checked Exceptions** | No compile-time checking | `throws` clause enforced by compiler |
| **Cleanup** | RAII via destructors (deterministic) | `finally`, try-with-resources (best-effort) |
| **Exception Specifications** | `noexcept` (C++11); `throw()` deprecated | `throws` clause (not enforced at runtime) |
| **Stack Unwinding** | Deterministic; destructors always called | GC-based; finally guaranteed |
| **Performance** | Zero-cost if no exception (some models) | Exception creation is expensive |
| **Uncaught Handler** | `std::terminate()` or custom | Handled by JVM; prints stack trace |

## Notable Features

### C++ Highlights
✓ **RAII Cleanup**: Destructors called during stack unwinding; deterministic cleanup  
✓ **Zero-Cost Abstraction**: Modern exceptions optimized for the non-exception path  
✓ **Custom Throwables**: Throw any type (integers, strings, custom objects)  
✓ **noexcept Keyword**: Document functions that never throw  
✓ **Exception Safety Guarantees**: Strong, basic, no-throw contracts  

### Java Highlights
✓ **Checked Exceptions**: Compiler enforces error handling for expected failures  
✓ **Exception Hierarchy**: Standardized exception types; easier to catch specific errors  
✓ **try-with-resources**: Automatic closing of Closeable resources  
✓ **Uniform Semantics**: All errors as exceptions; no return codes  
✓ **Stack Traces**: Detailed debugging information automatically captured  

## File Organization

### C++ (cpp/)
- `intro.cpp` — Exception handling basics
- `try_catch_throw.cpp` — Mechanics of exception flow
- `custom_exceptions.cpp` — User-defined exception classes

### Java (java/)
- `TryCatchDemo.java` — try-catch-finally fundamentals
- `CustomExceptions.java` — User-defined exception classes
- `TryWithResources.java` — Automatic resource management

## Learning Path
1. Understand exception propagation (try-catch-throw)
2. Create custom exception classes for domain errors
3. Use checked exceptions (Java) to enforce error handling
4. Apply RAII patterns (C++) or try-with-resources (Java)
5. Write exception-safe code (guarantee cleanup)
6. Handle multiple exception types with catch chains

## Key Takeaways
✓ **RAII (C++)**: Destructors ensure cleanup during exception unwinding  
✓ **Checked Exceptions (Java)**: Enforce error handling at compile time  
✓ **try-with-resources (Java)**: Simplify resource management  
✓ **Stack Unwinding**: Resources cleaned up in reverse order of construction  
✓ **Custom Exceptions**: Design meaningful error types for domain-specific handling  

---
*Exception handling is critical for robust, maintainable systems.*

This module covers error handling through exceptions: throwing, catching, and defining custom exception types. Both languages use try-catch blocks, but C++ allows throwing any type while Java enforces a strict exception hierarchy rooted in `Throwable`.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Throw | `throw` any type (int, string, object) | `throw` only `Throwable` subclasses |
| Catch | `catch(Type e)` / `catch(...)` | `catch(ExceptionType e)` / multi-catch |
| Custom exceptions | Inherit from `std::exception` | Inherit from `Exception` or `RuntimeException` |
| Checked exceptions | Not supported | `throws` declaration required for checked |
| Finally block | No `finally` — use RAII/destructors | `finally` block for cleanup |
| Resource cleanup | RAII (destructors + smart pointers) | `try-with-resources` (`AutoCloseable`) |
| Exception specs | `noexcept` (C++11+) | `throws` in method signature |

## Key Differences

- C++ can throw any type (even `int`); Java only allows `Throwable` subclasses
- Java distinguishes checked vs. unchecked exceptions; C++ has no such distinction
- C++ uses RAII for guaranteed cleanup; Java uses `finally` and `try-with-resources`
- C++ `catch(...)` catches everything; Java requires specific exception types
- Java's exception hierarchy (`Error`, `Exception`, `RuntimeException`) enforces structure

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `intro.cpp` | Basic exception handling introduction |
| `Try_Catch_Throw.cpp` | Try-catch-throw mechanics |
| `custom_exceptions.cpp` | Custom exception classes |

### Java (`java/`)

| File | Description |
|------|-------------|
| `TryCatchDemo.java` | Try-catch-finally fundamentals |
| `CustomExceptions.java` | User-defined exception classes |
| `TryWithResources.java` | Automatic resource management |
