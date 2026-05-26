# Module 07 — I/O & Manipulators

## Overview
Text formatting and stream-based I/O. C++ uses manipulators and stream flags for formatting; Java uses printf-style format strings and utility classes. Both support reading from stdin and writing to stdout with precise control over output appearance.

## Core Concepts
- **Stream Objects**: cout/cin (C++), System.out/in (Java)
- **Formatted Output**: Width, precision, alignment, fill characters
- **Stream Manipulators**: `setw`, `setprecision`, `setfill` (C++)
- **Format Strings**: `printf`, `String.format` (Java)
- **Parsing and Tokenization**: Extract structured data
- **String Operations**: Case conversion, splitting, concatenation
- **Stream State & Flags**: Control formatting globally or locally

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Manipulators** | Persistent state (affects future operations) | Transient format strings (per-call) |
| **Width (`setw`)** | Resets after each output | Not applicable; use format string |
| **Precision** | Sets maximum significant digits | Decimal places in format string |
| **Input** | `cin >>` (type-safe extraction) | `Scanner.nextInt()`, `Integer.parseInt()` |
| **String Class** | No rich string class (std::string useful) | Rich String API with many methods |
| **Formatting** | `cout` with flags/manipulators | `System.out.printf()` or `String.format()` |
| **Locale** | `imbue()` for locale support | Locale-aware by default |

## Notable Features

### C++ Highlights
✓ **Persistent Manipulators**: `setw`, `setprecision` persist until reset  
✓ **Type-Safe Extraction**: `cin >> int_var` prevents common parsing errors  
✓ **Low-Level Control**: Access stream flags directly: `std::ios::left`, `std::ios::hex`  
✓ **Inline Formatting**: Mix manipulators with output: `cout << setw(10) << value`  
✓ **Floating-Point Precision**: Fine control with `fixed`, `scientific` modes  

### Java Highlights
✓ **Format Strings**: Clear, printf-like syntax; easy to read at a glance  
✓ **Rich String API**: charAt, substring, split, replaceAll, etc.  
✓ **Scanner Class**: Unified interface for console and file input  
✓ **StringBuilder**: Efficient string concatenation  
✓ **String.format()**: Reusable format templates  

## File Organization

### C++ (cpp/)
- `fmtflags_enumeration.cpp` — Stream flags and state control
- `manipulator*.cpp` — Manipulator usage (setw, setprecision, setfill)
- `width_precision_fill.cpp` — Detailed formatting examples
- `template.cpp` — Template-based I/O patterns
- `inline_demo.cpp` — Inline formatting techniques

### Java (java/)
- `StringOperations.java` — String manipulation methods
- `ScannerIO.java` — Scanner for formatted input
- `FormattedOutput.java` — printf() and String.format()
- `StringConstructor.java` — String creation patterns
- `StringConversionTest.java` — Type/string conversions
- `StringSplitTest.java` — Parsing and tokenization

## Learning Path
1. Master basic output (cout, System.out)
2. Learn formatters/manipulators for alignment and precision
3. Practice reading input (cin, Scanner)
4. Build format strings for complex output
5. Parse structured text (splitting, tokenization)
6. Handle edge cases (empty strings, whitespace, etc.)

## Key Takeaways
✓ **Persistent vs Transient**: C++ manipulators persist; Java format strings are per-call  
✓ **Precision**: Means different things (C++ significant digits vs Java decimal places)  
✓ **Type-Safe Input (C++)**: `cin >> value` prevents parsing ambiguity  
✓ **String Richness (Java)**: Extensive API for manipulation without separate libraries  
✓ **Format Clarity**: Choose format strings (Java) or manipulators (C++) consistently  

---
*Clear, properly formatted I/O is essential for usable applications.*

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
