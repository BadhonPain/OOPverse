# Module 13 — Command Line Arguments

This module covers parsing and using command-line arguments passed to programs at launch. Both languages receive arguments as string arrays, but differ in how the program entry point is structured and how arguments are indexed.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Entry point | `int main(int argc, char* argv[])` | `public static void main(String[] args)` |
| Arg count | `argc` parameter | `args.length` |
| Program name | `argv[0]` (program path) | Not included in `args` |
| First argument | `argv[1]` | `args[0]` |
| Argument type | `char*` (C-string) | `String` object |
| Parsing libraries | `getopt`, CLI11, Boost.Program_options | Apache Commons CLI, JCommander, picocli |

## Key Differences

- C++ includes the program name as `argv[0]`; Java's `args` starts with the first user argument
- C++ arguments are raw C-strings requiring manual conversion; Java arguments are `String` objects
- C++ provides `argc` as a separate count; Java uses `args.length`
- C++ can return exit codes from `main()`; Java uses `System.exit(int)`
- Both require manual parsing for flags/options without third-party libraries

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `cli_arguments.cpp` | Parsing `argc`/`argv` and processing flags |

### Java (`java/`)

| File | Description |
|------|-------------|
| `CliArguments.java` | Parsing `args` array and processing flags |
