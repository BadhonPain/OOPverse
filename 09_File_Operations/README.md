# Module 09 — File Operations

## Overview
Reading, writing, and manipulating files on disk. Covers sequential and random access, text and binary operations, serialization, and metadata queries. Demonstrates traditional streams (C++/Java) and modern NIO approaches (Java).

## Core Concepts
- **Sequential Access**: Read/write data in order
- **Random Access**: Jump to arbitrary file positions with seek
- **Text Files**: Character data (strings, lines)
- **Binary Files**: Raw byte data (objects, images)
- **Buffered I/O**: Improve performance with buffers
- **File Metadata**: Name, size, permissions, existence checks
- **Serialization**: Convert objects to bytes for storage/transmission
- **Resource Management**: Proper file handle cleanup
- **Path and File Navigation**: Directory operations

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Streams** | `fstream` (unified I/O) | Separate read/write/random hierarchies |
| **Text vs Binary** | Mode flags: `ios::text`, `ios::binary` | Different stream classes entirely |
| **Seekg/Seekp** | Separate input and output pointers | `RandomAccessFile` for unified access |
| **Serialization** | Manual byte-by-byte encoding | `Serializable` interface + ObjectStream |
| **Buffering** | Automatic; user can control | `BufferedReader`/`BufferedWriter` wrappers |
| **NIO** | No equivalent; raw streams only | Java NIO: `Files`, `Path`, `Channels` |
| **File Class** | C++17 `<filesystem>` | `java.io.File` class |
| **Error Handling** | Exception-based or stream state | Exception-based |

## Notable Features

### C++ Highlights
✓ **Unified Streams**: `fstream` for both reading and writing  
✓ **Binary Mode Control**: Explicit binary flag for raw byte access  
✓ **Random Access Pointers**: Separate get/put pointers for precise control  
✓ **Low-Level Access**: Direct file descriptor control available  
✓ **C++17 Filesystem**: Modern `std::filesystem::path` for cross-platform file handling  

### Java Highlights
✓ **Built-in Serialization**: Objects automatically converted to bytes with `Serializable`  
✓ **NIO (Java 7+)**: `Files.readString()`, `Files.writeString()` for simplified I/O  
✓ **Try-with-resources**: Automatic file handle cleanup  
✓ **Consistent API**: All file operations throw checked `IOException`  
✓ **Cross-Platform Paths**: `Path` abstraction handles OS differences  

## File Organization

### C++ (cpp/)
- `write_read.cpp` — Basic file operations
- `sequential_access.cpp` — Reading/writing in order
- `random_access.cpp`, `test_random.cpp` — Seek-based positioning

### Java (java/)
- `FileReadDemo.java` — Text file reading
- `FileWriteDemo.java` — Text file writing
- `AppendDemo.java` — Appending to files
- `RandomAccessDemo.java` — Seek-based access
- `FileCopyDemo.java` — Copying files
- `SerializationDemo.java`, `DeserializationDemo.java` — Object persistence
- `FileClassDemo.java` — File metadata
- `FileOverall.java` — Comprehensive operations (refactored with helper methods)

## Learning Path
1. Master sequential file reading (line-by-line)
2. Practice file writing and appending
3. Learn random access (seeking to positions)
4. Handle file metadata (size, existence, permissions)
5. Implement serialization for custom objects
6. Apply buffering for performance optimization
7. Use try-with-resources for safe cleanup

## Key Takeaways
✓ **Sequential vs Random**: Sequential for large files; random for indexing  
✓ **Buffering**: Essential for I/O performance  
✓ **Serialization (Java)**: Easy object storage without manual encoding  
✓ **try-with-resources (Java)**: Automatic cleanup prevents resource leaks  
✓ **NIO (Java 8+)**: Modern API simplifies common operations  

---
*File I/O is fundamental to persistent, stateful applications.*

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
