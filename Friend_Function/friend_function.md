# Friend Function

A **friend function** is not a member of a class but still has access to the **private members** of the class.

> It's a regular non-member function — declared inside the class with the `friend` keyword, but defined outside like a normal function.

---

## Key Variations

- A **regular non-member function** can be a friend of a class.
  *(See `General_Use.cpp`)*

- A **member of one class** can be a friend of another class.
  *(See `General_Use_2.cpp`)*

---

## Uses

### 1. Operator Overloading
Allows operators like `+`, `<<`, `>>` to access private data of a class without being a member.

```cpp
class Complex {
    int real, imaginary;
public:
    friend ostream& operator<<(ostream& out, const Complex& obj);
};
```

---

### 2. Creation of Certain Types of I/O Functions
Input/output operators (`>>` and `<<`) must be non-member functions — friend makes this possible while still accessing private data.

```cpp
friend istream& operator>>(istream& in,  Complex& obj);
friend ostream& operator<<(ostream& out, const Complex& obj);
```

---

### 3. One Function to Access Private Members of Two or More Classes
A single function can be a friend of multiple classes, allowing it to work with private data of all of them at once.

```cpp
class A {
    int x;
    friend void show(A, B);  // friend of A
};

class B {
    int y;
    friend void show(A, B);  // friend of B
};

void show(A a, B b) {
    cout << a.x << " " << b.y;  // accesses private of BOTH
}
```

---

## Quick Summary

| Property | Detail |
|---|---|
| Member of class? | ❌ No |
| Access to private? | ✅ Yes |
| Declared where? | Inside the class with `friend` keyword |
| Defined where? | Outside the class, like a normal function |
| Can friend multiple classes? | ✅ Yes |
