# Module 08 — Exception Handling

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
