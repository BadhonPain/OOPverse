# Module 11 — Multithreading

## Overview
Concurrent execution and synchronization primitives. Explores thread creation, mutual exclusion, condition variables, and thread-safe design patterns. Both C++ and Java enable parallel execution; Java's model is simpler, C++ offers finer control.

## Core Concepts
- **Threads**: Parallel execution paths
- **Thread Creation**: `std::thread` (C++), `Thread`/`Runnable` (Java)
- **Mutual Exclusion (Mutex)**: Prevent data races
- **Locks**: RAII-based or explicit locking
- **Condition Variables**: Coordinate thread execution
- **Synchronization**: Ensure thread safety
- **Join/Wait**: Wait for thread completion
- **Producer-Consumer Pattern**: Coordinated multi-threaded workload
- **Thread Safety**: Designing concurrent data structures

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Thread Creation** | `std::thread(func)` with lambda/function | `new Thread(Runnable)` or extend Thread |
| **Synchronization** | `std::mutex`, `std::lock_guard` (RAII) | `synchronized` keyword or locks |
| **Condition Variables** | `std::condition_variable` explicit | `wait()`/`notify()` on object monitor |
| **Memory Model** | C++11 memory model; atomic operations | Java memory model; happens-before rules |
| **Executor Pattern** | Limited; manual thread pooling | `ExecutorService` built-in |
| **Atomics** | `std::atomic<T>` for atomic types | `java.util.concurrent.atomic` classes |
| **Lock Types** | RAII locks (lock_guard, unique_lock) | explicit Lock objects or synchronized |
| **Performance** | Can be very fast; low overhead | Some overhead from JVM indirection |

## Notable Features

### C++ Highlights
✓ **RAII Locks**: `std::lock_guard` ensures unlock even on exception  
✓ **Atomic Operations**: `std::atomic<T>` for lock-free programming  
✓ **Explicit Control**: Full access to `std::mutex`, `std::condition_variable`  
✓ **Move Semantics**: Efficient thread transfers with `std::move`  
✓ **Memory Barriers**: Fine-grained control over memory ordering  

### Java Highlights
✓ **Synchronized Keyword**: Simple, built-in mutual exclusion  
✓ **Monitor Model**: Every object is a monitor (implicit synchronization)  
✓ **ExecutorService**: Thread pools without manual management  
✓ **Concurrent Collections**: Thread-safe queues, maps without explicit locking  
✓ **Lock Interface**: Reentrant locks and read-write locks  

## File Organization

### C++ (cpp/)
- `multithreading_demo.cpp` — Thread creation, mutexes, condition variables

### Java (java/)
- `ThreadDemo.java` — Thread creation and lifecycle
- `ProducerConsumer.java` — Synchronized producer-consumer pattern

## Learning Path
1. Master basic thread creation and lifecycle
2. Understand mutual exclusion (mutex/synchronized)
3. Practice locks and lock guards (RAII safety)
4. Learn condition variables for thread coordination
5. Implement producer-consumer patterns
6. Apply atomic operations for lock-free approaches
7. Use thread pools (ExecutorService) for scalability

## Key Takeaways
✓ **RAII Locks (C++)**: Automatic unlock prevents deadlocks  
✓ **Synchronized (Java)**: Simpler model; every object is a monitor  
✓ **Condition Variables**: Enable efficient thread coordination  
✓ **Atomic Operations**: Lock-free programming for scalable concurrent code  
✓ **Thread Pools (Java)**: Efficient resource management via ExecutorService  

---
*Correct multithreading is essential for responsive, scalable systems.*

This module covers concurrent programming: creating threads, synchronization, and producer-consumer patterns. C++ provides low-level threading via `<thread>` and `<mutex>`, while Java offers a rich concurrency framework with `Thread`, `Runnable`, and `java.util.concurrent` utilities.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Thread creation | `std::thread` with callable | `Thread` class / `Runnable` interface |
| Mutex | `std::mutex`, `std::lock_guard` | `synchronized` keyword / `ReentrantLock` |
| Condition variable | `std::condition_variable` | `wait()` / `notify()` / `Condition` |
| Atomic operations | `std::atomic<T>` | `AtomicInteger`, `AtomicReference`, etc. |
| Thread pool | Not built-in (use libraries) | `ExecutorService` framework |
| Memory model | C++11 memory model | Java Memory Model (JMM) |

## Key Differences

- Java's `synchronized` keyword is simpler than C++ mutex/lock_guard patterns
- C++ threads can accept any callable (functions, lambdas, functors); Java uses `Runnable`/`Callable`
- Java provides built-in `ExecutorService` for thread pools; C++ requires third-party libraries
- C++ `std::thread` must be `join()`ed or `detach()`ed; Java threads can be daemon threads
- Java's `wait()`/`notify()` is built into `Object`; C++ uses separate `condition_variable`

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `multithreading_demo.cpp` | Thread creation, mutexes, and synchronization |

### Java (`java/`)

| File | Description |
|------|-------------|
| `ThreadDemo.java` | Thread creation with `Thread` and `Runnable` |
| `ProducerConsumer.java` | Producer-consumer with synchronization |
