# Inheritance Diagrams (Mermaid)

This file contains simple Mermaid class diagrams illustrating common inheritance patterns used in this module. Render with any Mermaid-compatible viewer (GitHub, VS Code Mermaid Preview, or mermaid.live).

---

## 1) Single Inheritance
```mermaid
classDiagram
    class Base {
        +int id
        +void show()
    }
    class Derived {
        +void showDerived()
    }
    Base <|-- Derived
```

## 2) Multi-level Inheritance
```mermaid
classDiagram
    class Grandparent
    class Parent
    class Child
    Grandparent <|-- Parent
    Parent <|-- Child
```

## 3) Multiple Inheritance (C++ style)
```mermaid
classDiagram
    class Base1
    class Base2
    class MultiDerived
    Base1 <|-- MultiDerived
    Base2 <|-- MultiDerived
```

Note: Java does not support multiple class inheritance; use interfaces instead.

## 4) Interface Implementation (Java style)
```mermaid
classDiagram
    class ServiceInterface
    class ServiceImpl
    ServiceInterface <|.. ServiceImpl : implements
```

## 5) Diamond Problem (classical multiple inheritance)
```mermaid
classDiagram
    class Top
    class Left
    class Right
    class Bottom
    Top <|-- Left
    Top <|-- Right
    Left <|-- Bottom
    Right <|-- Bottom
```

Notes and guidance

- C++: multiple inheritance can create the diamond problem; use virtual inheritance (`virtual` base) to avoid duplicate subobjects.
- Java: prefer interfaces (default methods exist since Java 8); interfaces avoid the diamond object-layout issue.
- To preview locally: open this file in VS Code with a Mermaid preview extension, or paste diagram text to https://mermaid.live.

---
Small, focused visuals to complement the module README. If you want these embedded into the module README.md instead, say "embed" and I will merge them inline.