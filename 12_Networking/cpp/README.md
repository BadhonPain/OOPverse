# C++ Networking

C++ has **no built-in networking library** in the standard. Networking requires OS-level APIs:

| Platform | API | Headers |
|----------|-----|---------|
| Linux/macOS | POSIX Sockets | `<sys/socket.h>`, `<netinet/in.h>`, `<arpa/inet.h>` |
| Windows | Winsock2 | `<winsock2.h>`, `<ws2tcpip.h>` (link with `-lws2_32`) |

## C++ vs Java Networking

| Aspect | C++ | Java |
|--------|-----|------|
| **API** | OS-specific (POSIX/Winsock) | Built-in `java.net.*` |
| **Portability** | Requires `#ifdef` per platform | Write once, run anywhere |
| **Complexity** | Manual socket setup, binding, listening | `new ServerSocket(port)` |
| **Resource Mgmt** | Manual `close()` / `closesocket()` | Try-with-resources |
| **Popular Libraries** | Boost.Asio, POCO, cpp-httplib | Built-in + Netty, OkHttp |

## Why No C++ Code Example?

A portable C++ networking example would require significant platform-specific `#ifdef` blocks, making it unsuitable for a concise OOP teaching module. See the Java examples (`SimpleServer.java` and `SimpleClient.java`) for a clean client-server demo using `java.net.ServerSocket` and `java.net.Socket`.

For C++ networking projects, consider **Boost.Asio** or **cpp-httplib** which abstract away platform differences.
