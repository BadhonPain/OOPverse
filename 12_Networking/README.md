# Module 12 — Networking

## Overview
Socket programming and network communication. Java provides portable, high-level networking APIs; C++ requires platform-specific code. Demonstrates client-server architectures, TCP/IP communication, and data exchange protocols.

## Core Concepts
- **Sockets**: Endpoints for network communication
- **TCP/IP**: Reliable, connection-oriented protocol
- **Server Sockets**: Listen for incoming connections
- **Client Sockets**: Initiate connections
- **Streams**: Read/write data over network
- **Server Loop**: Accept multiple clients
- **Protocol Design**: Message format and exchange
- **Error Handling**: Network failures and timeouts
- **Cross-Platform Compatibility**: Abstract platform differences

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **API** | Platform-specific (Winsock2/POSIX) | Unified cross-platform `java.net` |
| **Socket Type** | `SOCKET` handle or wrapper class | `Socket` and `ServerSocket` objects |
| **Portability** | Requires conditional compilation | Write once, run anywhere |
| **Libraries** | Raw system calls or libraries (Boost.Asio) | Built-in; no external dependencies |
| **SSL/TLS** | OpenSSL or similar library | `javax.net.ssl` built-in |
| **NIO** | Boost.Asio for async I/O | `java.nio` for selectors, channels |
| **HTTP** | libcurl or similar library | `java.net.http.HttpClient` (Java 11+) |
| **Learning Curve** | Steeper; platform specifics | Gentler; higher-level abstractions |

## Notable Features

### C++ Highlights
✓ **Platform-Specific Optimization**: Can access OS-level socket features  
✓ **Low-Level Control**: Access to TCP_NODELAY, SO_KEEPALIVE, etc.  
✓ **Async I/O**: Boost.Asio for scalable event-driven servers  
✓ **Performance**: Can achieve near-kernel efficiency  
✓ **Zero-Copy**: Possible through sendfile and similar mechanisms  

### Java Highlights
✓ **Cross-Platform Portability**: Identical code on Windows, Linux, macOS  
✓ **High-Level Abstractions**: ServerSocket, Socket simplify common patterns  
✓ **Built-in SSL/TLS**: Secure communication without external libraries  
✓ **NIO Selectors**: Scalable multiplexing without platform variance  
✓ **HttpClient API (Java 11+)**: Modern HTTP/2 support built-in  

## File Organization

### C++ (cpp/)
*Note: Networking is platform-specific; detailed examples require Winsock2 (Windows) or POSIX sockets (Unix/Linux) setup.*

### Java (java/)
- `SimpleServer.java` — TCP server accepting connections
- `SimpleClient.java` — TCP client connecting to server

## Learning Path
1. Understand socket concepts (connection, send, receive)
2. Build a simple TCP server (listen, accept, read)
3. Create a TCP client (connect, send, receive)
4. Implement multi-client server (threading or selectors)
5. Design message protocols (encoding/decoding)
6. Add error handling (timeouts, disconnections)
7. Explore SSL/TLS for secure communication

## Key Takeaways
✓ **Platform Portability (Java)**: Write once, network anywhere  
✓ **Platform Optimization (C++)**: Access low-level socket control when needed  
✓ **Client-Server Pattern**: Fundamental architecture for distributed systems  
✓ **Message Protocols**: Design clear message formats for reliable communication  
✓ **Error Resilience**: Network failures are common; design for recovery  

---
*Networking enables scalable, distributed systems.*

This module covers socket programming for network communication. It demonstrates TCP client-server architecture using both languages. Java provides a portable `java.net` API, while C++ networking depends on platform-specific APIs (POSIX sockets or Winsock) or libraries like Boost.Asio.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Socket API | Platform-specific (POSIX/Winsock) | Portable `java.net.Socket` / `ServerSocket` |
| TCP server | `socket()`, `bind()`, `listen()`, `accept()` | `new ServerSocket(port)` |
| TCP client | `socket()`, `connect()` | `new Socket(host, port)` |
| Data transfer | `send()` / `recv()` (raw bytes) | `InputStream` / `OutputStream` wrappers |
| Portability | Requires `#ifdef` or abstraction layers | Write once, run anywhere |
| HTTP support | Third-party libraries | Built-in `HttpURLConnection`, `HttpClient` |

## Key Differences

- Java networking is fully portable; C++ requires platform-specific code or libraries
- Java wraps sockets with stream abstractions; C++ operates on raw file descriptors
- Java's `ServerSocket.accept()` returns a `Socket`; C++ returns a raw descriptor
- C++ requires manual resource cleanup (`close()`); Java can use `try-with-resources`
- Java provides built-in HTTP client APIs; C++ typically uses libcurl or Boost.Beast

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `README.md` | Platform-specific networking notes and setup |

### Java (`java/`)

| File | Description |
|------|-------------|
| `SimpleServer.java` | TCP server accepting client connections |
| `SimpleClient.java` | TCP client connecting to a server |
