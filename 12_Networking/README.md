# Module 12 — Networking

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
