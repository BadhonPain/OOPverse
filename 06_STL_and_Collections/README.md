# Module 06 — STL and Collections

This module covers container classes, iterators, and algorithms. C++ provides the Standard Template Library (STL) with value-semantics containers, while Java offers the Collections Framework with reference-based, object-oriented containers. Both provide similar data structures with different API philosophies.

## C++ vs Java Comparison

| Aspect | C++ | Java |
|--------|-----|------|
| Dynamic array | `vector` | `ArrayList` |
| Linked list | `list` (doubly-linked) | `LinkedList` |
| Hash map | `unordered_map` | `HashMap` |
| Sorted map | `map` (red-black tree) | `TreeMap` |
| Set | `set` / `unordered_set` | `HashSet` / `TreeSet` |
| Double-ended queue | `deque` | `ArrayDeque` |
| Iterators | Iterator objects with `begin()`/`end()` | `Iterator` interface, enhanced for-loop |
| Algorithms | `<algorithm>` header, free functions | `Collections` utility class, Streams API |
| Lambdas | `[captures](params){ body }` | `(params) -> body` |

## Key Differences

- C++ STL containers store values (copies); Java collections store object references
- C++ algorithms are free functions operating on iterator ranges; Java uses method calls on collections
- C++ lambdas can capture by value or reference; Java lambdas capture effectively-final variables
- C++ provides both ordered (`map`) and unordered (`unordered_map`) associative containers
- Java Collections Framework is interface-driven (`List`, `Set`, `Map`); C++ STL is template-driven

## Files in This Module

### C++ (`cpp/`)

| File | Description |
|------|-------------|
| `vector.cpp` | `vector` operations and methods |
| `vector_iterator.cpp` | Iterating over vectors |
| `list.cpp` | `list` (doubly-linked list) usage |
| `deque.cpp` | `deque` double-ended queue |
| `map.cpp` | `map` key-value pairs |
| `set.cpp` | `set` unique elements |
| `unordered_containers.cpp` | `unordered_map` and `unordered_set` |
| `algorithms.cpp` | STL algorithms (`sort`, `find`, etc.) |
| `stl_algorithms_lambdas.cpp` | Algorithms with lambda expressions |
| `STL_practice1.cpp` — `STL_practice4.cpp` | STL practice problems |

### Java (`java/`)

| File | Description |
|------|-------------|
| `ArrayListDemo.java` | `ArrayList` operations |
| `LinkedListDemo.java` | `LinkedList` usage |
| `HashMapDemo.java` | `HashMap` key-value pairs |
| `HashSetDemo.java` | `HashSet` unique elements |
| `CollectionAlgorithms.java` | `Collections` utility methods |
| `IteratorDemo.java` | Iterator patterns and enhanced for-loop |
