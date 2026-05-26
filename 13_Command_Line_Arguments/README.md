# Module 13 — Command-Line Arguments

## Overview
Parsing and processing runtime arguments. Both C++ and Java accept command-line parameters, but differ in how arguments are passed and accessed. Demonstrates flag parsing, validation, and configuration from the command line.

## Core Concepts
- **Arguments Array**: How to access passed parameters
- **Argument Parsing**: Extract and interpret arguments
- **Flag Handling**: Parse named options (--flag, -f)
- **Positional Arguments**: Required parameters in order
- **Optional Arguments**: With default values
- **Value Arguments**: Flags with associated values (--file=name.txt)
- **Error Handling**: Invalid arguments, missing values
- **Help/Usage**: Document expected arguments
- **Configuration**: Build program behavior from arguments

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Parameter Access** | `int main(int argc, char* argv[])` | `public static void main(String[] args)` |
| **Program Name** | Included in `argv[0]` | Not included; `args` starts with first user argument |
| **Argument Type** | C-strings (`char*`) | `String` objects |
| **Argument Count** | Explicit `argc` parameter | Implicit: `args.length` |
| **Exit Code** | Return from `main(int)` | `System.exit(code)` |
| **Argument Libraries** | Manual parsing or third-party (getopt) | Manual parsing or libraries (Apache Commons CLI) |
| **Null Termination** | Last `argv` element is NULL | N/A; array has fixed length |

## Notable Features

### C++ Highlights
✓ **Program Name Access**: `argv[0]` provides program invocation name  
✓ **Manual Control**: Full flexibility in parsing strategies  
✓ **getopt Utilities**: POSIX standard for option parsing  
✓ **C-String Efficiency**: No conversion overhead  
✓ **Explicit Count**: `argc` makes array bounds clear  

### Java Highlights
✓ **String Objects**: Easier manipulation than C-strings  
✓ **Clean Array Semantics**: `args` is a proper array with `.length`  
✓ **Library Support**: Rich ecosystem (Apache Commons CLI, picocli)  
✓ **Type Conversion**: Parse strings to int/double with clear API  
✓ **Consistency**: Same mechanism across all Java programs  

## File Organization

### C++ (cpp/)
- `cli_arguments.cpp` — Parsing `argc`/`argv` and processing flags

### Java (java/)
- `CliArguments.java` — Argument parsing and flag handling
- `CommandLineTest.java` — Testing command-line scenarios

## Learning Path
1. Understand basic argument access (argv/args)
2. Parse positional arguments
3. Handle named flags (--flag, -f)
4. Support value-paired arguments (--key=value)
5. Validate arguments and provide error messages
6. Build help/usage documentation
7. Create flexible configuration systems

## Examples

### C++ Invocation
```bash
./program arg1 arg2 --flag --key=value
// argv[0] = "./program"
// argv[1] = "arg1"
// argv[2] = "arg2"
// argv[3] = "--flag"
// argv[4] = "--key=value"
// argc = 5
```

### Java Invocation
```bash
java Program arg1 arg2 --flag --key=value
// args[0] = "arg1"
// args[1] = "arg2"
// args[2] = "--flag"
// args[3] = "--key=value"
// args.length = 4
```

## Key Takeaways
✓ **Program Name Inclusion (C++)**: First argument is the program name; skip in processing  
✓ **Array Bounds (Java)**: Use `args.length` for iteration without NULL checks  
✓ **Type Conversion**: Parse strings to appropriate types (int, boolean, etc.)  
✓ **Error Handling**: Validate arguments; provide meaningful error messages  
✓ **Help Documentation**: Make command-line interface discoverable (--help)  

---
*Command-line argument parsing is fundamental to building configurable tools.*
