# Type Casting in C++ and Java

---

## What is Type Casting?

Type casting is the process of **converting a value from one data type to another**.

```
int   →  double       (widening)
double →  int         (narrowing — data loss possible)
Base*  →  Derived*    (object casting)
```

> Sometimes conversion is safe and automatic. Sometimes it's risky and must be done explicitly. Casting operators give you control over **how** and **when** this conversion happens.

---

# PART 1 — Type Casting in C++

C++ has **two eras** of casting:

```
Old Style (C-style):    (int) x          ← inherited from C, unsafe
New Style (C++ style):  static_cast<int>(x)  ← type-safe, expressive
```

> Always prefer C++ style casts. They are explicit, searchable, and the compiler can catch misuse.

---

## The 4 C++ Casting Operators

---

### 1. `static_cast<>`

**The most common cast.** Used for well-defined, compile-time conversions between compatible types.

#### Syntax
```cpp
static_cast<target_type>(expression)
```

#### Used For
- Numeric conversions (`int` ↔ `double`, `float` ↔ `int`)
- Pointer conversions up/down an inheritance hierarchy (when you are **sure** of the type)
- Explicit conversions that the compiler would otherwise warn about

#### Examples

```cpp
// Numeric conversion
double pi = 3.14159;
int truncated = static_cast<int>(pi);    // 3 — decimal dropped
cout << truncated;                        // 3

// Avoiding integer division
int a = 7, b = 2;
double result = static_cast<double>(a) / b;  // 3.5
// Without cast: 7/2 = 3 (integer division!)

// Up-cast (Derived → Base) — always safe
class Animal { };
class Dog : public Animal { };

Dog d;
Animal* a_ptr = static_cast<Animal*>(&d);   // ✅ safe upcast
```

#### What It CANNOT Do
```cpp
// ❌ Cannot cast unrelated pointer types
int* p = static_cast<int*>(someDoublePtr);   // ERROR

// ❌ Cannot safely downcast without guarantee
Animal* a = new Animal();
Dog* d = static_cast<Dog*>(a);   // compiles but UNDEFINED BEHAVIOUR
                                  // use dynamic_cast for this!
```

#### Memory View
```
double pi = 3.14159
┌────────────────────────┐
│ 3.14159 (8 bytes)      │
└────────────────────────┘
        │
        │  static_cast<int>
        ▼
┌───────────┐
│3 (4 bytes)│  ← fractional part silently dropped
└───────────┘
```

---

### 2. `dynamic_cast<>`

**The safe downcast.** Used for casting pointers/references **down** an inheritance hierarchy at **runtime**. Requires at least one `virtual` function in the base class (polymorphic type).

#### Syntax
```cpp
dynamic_cast<target_type*>(pointer)
dynamic_cast<target_type&>(reference)
```

#### Used For
- Safely converting `Base*` → `Derived*` at runtime
- Checking if an object truly is of the target type

#### Examples

```cpp
class Animal {
public:
    virtual void speak() { }    // must have at least one virtual function
};

class Dog : public Animal {
public:
    void fetch() { cout << "Fetching!\n"; }
};

class Cat : public Animal { };

int main() {
    Animal* a1 = new Dog();    // Dog stored as Animal pointer
    Animal* a2 = new Cat();    // Cat stored as Animal pointer

    // Safe downcast — attempt to get Dog*
    Dog* d = dynamic_cast<Dog*>(a1);
    if (d != nullptr) {
        d->fetch();            // ✅ "Fetching!" — it really was a Dog
    }

    // Failed downcast — a2 is actually a Cat, not a Dog
    Dog* d2 = dynamic_cast<Dog*>(a2);
    if (d2 == nullptr) {
        cout << "Not a Dog!\n";  // ✅ safely caught — returns nullptr
    }
}
```

#### Pointer vs Reference Behaviour on Failure

```cpp
// Pointer cast — returns nullptr on failure (safe to check)
Dog* d = dynamic_cast<Dog*>(animal_ptr);
if (d == nullptr) { /* handle failure */ }

// Reference cast — throws std::bad_cast on failure
try {
    Dog& d = dynamic_cast<Dog&>(animal_ref);
} catch (std::bad_cast& e) {
    cout << "Cast failed: " << e.what();
}
```

#### `static_cast` vs `dynamic_cast` for Downcasting

```
static_cast (downcast):              dynamic_cast (downcast):
────────────────────────             ────────────────────────
Compile-time only                    Runtime check
No safety check                      Returns nullptr if wrong
Faster                               Slight overhead (RTTI)
Use when 100% sure of type           Use when unsure of type
```

---

### 3. `const_cast<>`

**The only cast that modifies `const` or `volatile`.**  Used to add or (more commonly) **remove** `const` from a variable.

#### Syntax
```cpp
const_cast<target_type>(expression)
```

#### Used For
- Removing `const` from a pointer/reference to pass to a legacy function that doesn't use `const` but doesn't actually modify the data
- Adding `const` (rare)

#### Examples

```cpp
// Legacy function that doesn't modify data but forgot const
void printLabel(char* str) {          // old C-style, no const
    cout << str << endl;
}

int main() {
    const char* msg = "Hello";
    printLabel(msg);                           // ❌ ERROR — can't pass const to non-const
    printLabel(const_cast<char*>(msg));        // ✅ removes const for the call
}
```

#### ⚠️ Danger Zone

```cpp
const int x = 10;
int* p = const_cast<int*>(&x);
*p = 99;    // ❌ UNDEFINED BEHAVIOUR!
            // x was declared const — modifying it is illegal
            // even though it compiles
```

> `const_cast` only safe when the **original variable was not declared `const`** — just passed through a `const` parameter somewhere.

---

### 4. `reinterpret_cast<>`

**The most dangerous cast.** Reinterprets the raw bit pattern of a value as a completely different type. No conversion is done — the same bytes are just read differently.

#### Syntax
```cpp
reinterpret_cast<target_type>(expression)
```

#### Used For
- Low-level programming (hardware registers, embedded systems)
- Converting pointer types with no relationship
- Serialization / memory inspection

#### Examples

```cpp
// Treat an integer as a pointer
int address = 0x00FFAA;
int* ptr = reinterpret_cast<int*>(address);  // treat number as memory address

// Treat any pointer as raw bytes
float f = 3.14f;
unsigned char* bytes = reinterpret_cast<unsigned char*>(&f);
for (int i = 0; i < sizeof(float); i++) {
    printf("%02X ", bytes[i]);   // see raw bytes of the float
}
```

#### Memory View

```
float f = 3.14f
┌─────────────────────────────────────┐
│  01000000 01001000 F5C3 (4 bytes)   │  ← actual bits in memory
└─────────────────────────────────────┘
        │
        │  reinterpret_cast<int*>
        ▼
┌─────────────────────────────────────┐
│  Same bits — now read as int        │  ← no conversion, just reinterpretation
│  1078523331                         │
└─────────────────────────────────────┘
```

> **Use only when absolutely necessary.** Behaviour is platform-dependent and nearly always undefined unless you know exactly what you're doing.

---

## C++ Casting — Quick Comparison

| Cast | Safety | Runtime Check | Use Case |
|---|---|---|---|
| `static_cast` | ✅ Moderate | ❌ No | Numeric, compatible type conversions |
| `dynamic_cast` | ✅ High | ✅ Yes | Safe polymorphic downcasting |
| `const_cast` | ⚠️ Low | ❌ No | Remove/add `const` qualifier |
| `reinterpret_cast` | ❌ Dangerous | ❌ No | Raw bit reinterpretation |

---

## C-Style Cast vs C++ Casts

```cpp
double x = 3.99;

// C-style — does whatever it takes, no safety
int a = (int)x;            // works but which cast is it using? unclear

// C++ style — explicit and searchable
int b = static_cast<int>(x);   // ✅ clear intent, compiler checks it
```

> C-style cast silently tries `const_cast` → `static_cast` → `reinterpret_cast` in sequence. You lose all safety guarantees.

---

# PART 2 — Type Casting in Java

Java casting works differently from C++. There is no `reinterpret_cast` style raw memory access. Java prioritises **safety** through its type system and the JVM.

---

## Two Categories of Casting in Java

```
Java Casting
├── Primitive Casting
│   ├── Widening  (automatic)
│   └── Narrowing (explicit)
│
└── Reference (Object) Casting
    ├── Upcasting   (automatic)
    └── Downcasting (explicit, checked at runtime)
```

---

### Primitive Casting

#### Widening (Implicit — Automatic)
Moving to a **larger** type. No data loss, done automatically.

```
byte → short → int → long → float → double
```

```java
int i = 42;
double d = i;           // ✅ automatic — no cast needed
System.out.println(d);  // 42.0
```

#### Narrowing (Explicit — Manual)
Moving to a **smaller** type. Data loss possible — must cast explicitly.

```java
double pi = 3.14159;
int truncated = (int) pi;        // explicit cast required
System.out.println(truncated);   // 3 — decimal dropped

long big = 1234567890123L;
int small = (int) big;           // data loss! overflow possible
```

---

### Reference (Object) Casting

#### Upcasting — Child → Parent (Automatic)

```java
class Animal { }
class Dog extends Animal { }

Dog d = new Dog();
Animal a = d;           // ✅ automatic upcast — no cast syntax needed
```

#### Downcasting — Parent → Child (Explicit + Runtime Check)

```java
Animal a = new Dog();           // Dog stored as Animal
Dog d = (Dog) a;                // explicit downcast
// JVM checks at runtime: is `a` actually a Dog? ✅ yes

Animal a2 = new Animal();
Dog d2 = (Dog) a2;              // ❌ ClassCastException at runtime!
                                 // a2 is NOT a Dog
```

#### Safe Downcasting with `instanceof`

```java
Animal a = new Dog();

if (a instanceof Dog) {
    Dog d = (Dog) a;       // ✅ safe — we checked first
    d.fetch();
}
```

---

## Auto-Boxing and Unboxing

This is Java's automatic conversion between **primitive types** and their **wrapper class** equivalents.

### Primitive vs Wrapper Types

| Primitive | Wrapper Class |
|---|---|
| `int` | `Integer` |
| `double` | `Double` |
| `float` | `Float` |
| `long` | `Long` |
| `boolean` | `Boolean` |
| `char` | `Character` |
| `byte` | `Byte` |
| `short` | `Short` |

> **Why do wrapper classes exist?** Java collections (`ArrayList`, `HashMap`, etc.) can only store **objects**, not primitives. Wrapper classes let you store primitives in collections.

---

### Auto-Boxing — Primitive → Object (Automatic)

The compiler automatically wraps a primitive into its wrapper class object.

```java
// Manual (old way):
int x = 5;
Integer obj = Integer.valueOf(x);   // manual boxing

// Auto-boxing (modern Java):
int x = 5;
Integer obj = x;    // ✅ compiler does Integer.valueOf(x) automatically
```

```java
// Works seamlessly with collections
ArrayList<Integer> list = new ArrayList<>();
list.add(10);   // ✅ auto-boxes int 10 → Integer(10) automatically
list.add(20);
list.add(30);
```

---

### Unboxing — Object → Primitive (Automatic)

The compiler automatically extracts the primitive value from a wrapper object.

```java
// Manual (old way):
Integer obj = new Integer(42);
int x = obj.intValue();   // manual unboxing

// Auto-unboxing (modern Java):
Integer obj = 42;
int x = obj;    // ✅ compiler does obj.intValue() automatically
```

```java
// Works seamlessly in arithmetic
Integer a = 10;
Integer b = 20;
int sum = a + b;    // ✅ auto-unboxed → 10 + 20 = 30
```

---

### Auto-Boxing + Unboxing Flow

```
BOXING (primitive → object):
────────────────────────────
int x = 5
    │
    │  auto-box
    ▼
┌──────────────────────┐
│  Integer object      │
│  ┌────────────────┐  │
│  │  value = 5     │  │   ← stored on Heap
│  └────────────────┘  │
└──────────────────────┘

UNBOXING (object → primitive):
───────────────────────────────
┌──────────────────────┐
│  Integer object      │
│  ┌────────────────┐  │
│  │  value = 5     │  │
│  └────────────────┘  │
└──────────────────────┘
    │
    │  auto-unbox
    ▼
int x = 5    ← back on Stack
```

---

### ⚠️ Common Auto-Boxing Pitfalls

#### 1. NullPointerException on Unboxing

```java
Integer obj = null;
int x = obj;    // ❌ NullPointerException!
                // tries to call obj.intValue() on null
```

#### 2. `==` Compares References, Not Values

```java
Integer a = 127;
Integer b = 127;
System.out.println(a == b);    // ✅ true  (cached range: -128 to 127)

Integer c = 128;
Integer d = 128;
System.out.println(c == d);    // ❌ false! (outside cache — new objects)
System.out.println(c.equals(d)); // ✅ true  (always use equals() for objects)
```

> Java caches `Integer` objects in the range **-128 to 127**. Outside this range, each auto-box creates a new object — `==` compares references, not values.

#### 3. Performance Overhead in Loops

```java
// ❌ BAD — auto-boxing/unboxing 1 million times
Long sum = 0L;
for (long i = 0; i < 1_000_000; i++) {
    sum += i;    // unbox sum, add i, rebox result — every iteration!
}

// ✅ GOOD — use primitive
long sum = 0L;
for (long i = 0; i < 1_000_000; i++) {
    sum += i;    // pure primitive, no overhead
}
```

---

## Java Casting — Quick Summary

| Type | Direction | Automatic? | Risk |
|---|---|---|---|
| Widening (primitive) | small → large | ✅ Yes | None |
| Narrowing (primitive) | large → small | ❌ Manual | Data loss |
| Upcasting (object) | Child → Parent | ✅ Yes | None |
| Downcasting (object) | Parent → Child | ❌ Manual | `ClassCastException` |
| Auto-Boxing | primitive → Wrapper | ✅ Yes | `NullPointerException` |
| Unboxing | Wrapper → primitive | ✅ Yes | `NullPointerException` |

---

# C++ vs Java — Final Comparison

| Feature | C++ | Java |
|---|---|---|
| Numeric casting | `static_cast<int>(x)` | `(int) x` |
| Safe downcast | `dynamic_cast<Dog*>(ptr)` | `(Dog) obj` + `instanceof` |
| Remove const | `const_cast<T>(x)` | No equivalent |
| Raw bit reinterpret | `reinterpret_cast<T>(x)` | No equivalent (unsafe) |
| Primitive ↔ Object | Manual / not applicable | Auto-boxing / unboxing |
| Failed cast (pointer) | Returns `nullptr` | Throws `ClassCastException` |
| Memory safety | Programmer's responsibility | JVM enforces at runtime |

---

## Golden Rules

> **C++:** Use `static_cast` by default. Use `dynamic_cast` when safety matters. Avoid `reinterpret_cast` unless doing low-level work. Never use C-style casts.

> **Java:** Always use `instanceof` before downcasting. Use primitives in performance-critical loops — avoid unnecessary auto-boxing. Always use `.equals()` to compare wrapper objects, never `==`.
