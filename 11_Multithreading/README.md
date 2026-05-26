# Module 11 — Multithreading

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
