# Module 06 — STL & Collections

## Overview
Standard containers and algorithms. C++ Standard Template Library (STL) provides vector, list, map, set, and algorithms. Java Collections Framework offers ArrayList, LinkedList, HashMap, HashSet, and streams. Both enable efficient data storage and retrieval.

## Core Concepts
- **Linear Containers**: vector/ArrayList (dynamic array), list/LinkedList (doubly-linked)
- **Double-Ended Queues**: deque/Deque (fast front and back access)
- **Ordered Maps**: map/TreeMap (sorted key-value pairs)
- **Unordered Maps**: unordered_map/HashMap (hash-based lookup)
- **Sets**: set/TreeSet (unique elements, sorted), unordered_set/HashSet (unsorted)
- **Iterators**: Navigate container elements
- **Algorithms**: sort, find, copy, transform, etc.
- **Comparators**: Custom comparison logic
- **Equality and Hashing**: Contracts for proper container behavior

## C++ vs Java: Key Differences

| Feature | C++ | Java |
|---------|-----|------|
| **Semantics** | Value semantics (stores copies) | Reference semantics (stores references) |
| **Algorithms** | Free functions: `std::sort(v.begin(), v.end())` | Method calls: `Collections.sort(list)` or `stream.sorted()` |
| **Iterators** | Explicit iterator objects | Enhanced for-loop or Iterator interface |
| **Lambda Integration** | Supported; used with algorithms | First-class; Streams API based on lambdas |
| **Type Safety** | Compile-time with templates | Runtime with generics + erasure |
| **Performance** | No virtual dispatch; zero-cost abstractions | Method dispatch; GC overhead |
| **Functional Approach** | Limited; STL is procedural | Rich; Streams API (Java 8+) |

## Notable Features

### C++ Highlights
✓ **Value Semantics**: STL stores copies; no aliasing issues  
✓ **Zero-Cost Abstractions**: Template-based; inlines to optimal code  
✓ **Iterator Ranges**: Flexible algorithms work on any range  
✓ **Unordered Containers**: Hash-based for O(1) average lookup  
✓ **Algorithm-Iterator Separation**: Clean, composable design  

### Java Highlights
✓ **Streams API (Java 8+)**: Functional-style data processing  
✓ **Collections Utilities**: Rich Collections class with ready-made algorithms  
✓ **Consistent Interface**: All collections extend Collection interface  
✓ **Automatic Resource Management**: Iterator auto-release in enhanced for-loop  
✓ **Reference Semantics**: Simpler mental model for collections  

## File Organization

### C++ (cpp/)
- `vector.cpp`, `vector_iterator.cpp` — Dynamic arrays
- `list.cpp` — Doubly-linked lists
- `deque.cpp` — Double-ended queues
- `map.cpp`, `set.cpp` — Ordered containers
- `unordered_containers.cpp` — Hash-based containers
- `algorithms.cpp`, `stl_algorithms_lambdas.cpp` — STL algorithms
- `stl_practice*.cpp` — Practice problems

### Java (java/)
- `ArrayListDemo*.java`, `LinkedListDemo.java` — Linear containers
- `HashMapDemo.java`, `HashSetDemo.java` — Hash-based containers
- `DequeDemo.java` — Double-ended queues
- `VectorDemo.java`, `HashTableDemo.java` — Legacy classes
- `IteratorDemo.java` — Iterator patterns
- `CollectionAlgorithms.java` — Collections utilities
- `CustomComparator.java`, `LambdaComparatorDemo.java` — Comparison logic
- `EqualsHashCodeDemo.java` — Proper equals/hashCode implementation

## Learning Path
1. Master ArrayList/vector (most common)
2. Understand LinkedList for insertion-heavy workloads
3. Learn HashMap/unordered_map for key-value lookup
4. Practice TreeMap/set for sorted data
5. Apply algorithms (sort, find, transform)
6. Compose queries with Streams (Java) or ranges (C++)

## Key Takeaways
✓ **Linear vs Hash**: ArrayList fast for iteration; HashMap fast for lookup  
✓ **Value vs Reference**: C++ copies data; Java references objects  
✓ **Algorithms**: Apply generically across container types  
✓ **Custom Comparators**: Provide comparison logic for sorting/ordering  
✓ **Functional Composition (Java)**: Streams enable expressive data pipelines  

---
*Efficient collections and algorithms are the backbone of practical software.*

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
