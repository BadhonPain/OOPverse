# Module 09 — File Operations

This module covers file I/O: reading, writing, sequential access, and random access. C++ uses stream-based file I/O (`fstream`), while Java provides multiple abstractions including streams, readers/writers, and the NIO.2 API. Both support text and binary file operations.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| File writing | `ofstream` | `FileWriter` / `BufferedWriter` / `Files` |
| File reading | `ifstream` | `FileReader` / `BufferedReader` / `Scanner` |
| Binary I/O | `fstream` with `ios::binary` | `FileInputStream` / `FileOutputStream` |
| Random access | `seekg()` / `seekp()` / `tellg()` | `RandomAccessFile` |
| Serialization | Manual binary read/write | `Serializable` interface |
| Path handling | `<filesystem>` (C++17) | `java.nio.file.Path` / `Paths` |

## Key Differences

- C++ uses unified `fstream` for read/write; Java has separate stream hierarchies
- C++ file streams are RAII — closed automatically on scope exit; Java requires explicit close
- Java's `Serializable` provides built-in object serialization; C++ requires manual implementation
- C++ random access uses `seekg()`/`seekp()` on streams; Java uses `RandomAccessFile`
- Java's `try-with-resources` ensures file handles are closed; C++ relies on destructors

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `write_read.cpp` | Basic file writing and reading |
| `sequential_access.cpp` | Sequential file access patterns |
| `random_access.cpp` | Random access with `seekg`/`seekp` |
| `testRandom.cpp` | Random access testing |
| `test.cpp` | File operation tests |
| `test2.cpp` | Additional file tests |
| `test3.cpp` | Further file operation examples |

### Java (`java/`)

| File | Description |
|------|-------------|
| `FileReadWrite.java` | Reading and writing text files |
| `RandomAccessDemo.java` | Random access file operations |
| `SerializationDemo.java` | Object serialization and deserialization |
