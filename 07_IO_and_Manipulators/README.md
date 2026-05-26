# Module 07 — I/O and Manipulators

This module covers formatted input/output, stream manipulators, and inline functions. C++ uses iostream with manipulators and format flags for output control, while Java offers `System.out.printf()`, `String.format()`, and `Scanner` for formatted I/O.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Output | `cout <<` with stream operators | `System.out.println()` / `printf()` |
| Input | `cin >>` | `Scanner` class |
| Formatting | `setw()`, `setprecision()`, `setfill()` | `String.format()`, `printf()` format specifiers |
| Format flags | `ios::fmtflags` enumeration | No equivalent — use format strings |
| Inline functions | `inline` keyword (hint to compiler) | JIT compiler handles inlining automatically |
| String operations | `string` class + C-string functions | `String`, `StringBuilder`, `StringBuffer` |

## Key Differences

- C++ manipulators modify stream state persistently; Java format strings are per-call
- C++ `setw()` resets after each use; `setprecision()` and `setfill()` persist
- C++ `inline` is a suggestion to the compiler; Java's JIT decides inlining at runtime
- Java's `Scanner` provides type-safe parsing; C++ `cin` relies on stream extraction operators
- C++ format flags (`ios::fixed`, `ios::hex`) are bit flags; Java uses format specifier characters

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `fmtflags_Enumeration.cpp` | `ios::fmtflags` for output formatting |
| `manipulator1.cpp` | Basic stream manipulators |
| `manipulator2.cpp` | Advanced manipulators |
| `width_precision_fill.cpp` | `setw`, `setprecision`, `setfill` |
| `Template.cpp` | Template-based I/O |
| `inlineDemo.cpp` | Inline function demonstration |

### Java (`java/`)

| File | Description |
|------|-------------|
| `StringOperations.java` | String manipulation and methods |
| `ScannerIO.java` | `Scanner` for formatted input |
| `FormattedOutput.java` | `printf()` and `String.format()` |
