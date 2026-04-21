# Genericity (Decoupling)

By using a reference to `ostream` instead of hardcoding `cout`, your function becomes **agnostic about where the data is going.**

> `cout` is just **one specific** output stream — the console. A generic `ostream&` parameter unlocks all of these:

---

## Where Can You Write To?

| Stream Type | Class        | Destination              |
|-------------|--------------|--------------------------|
| Console     | `cout`       | Terminal / Screen        |
| File        | `ofstream`   | `.txt`, `.csv`, any file |
| String      | `stringstream` | A string variable in memory |
| Network     | custom stream | Server / Socket          |

---

## Same Function, Different Destinations

```cpp
ostream& operator<<(ostream& out, const Complex& obj) {
    out << obj.real << "+" << obj.imaginary << "i";
    return out;
}
```

```cpp
// ✅ Console
cout << c;

// ✅ File
ofstream file("output.txt");
file << c;

// ✅ String
stringstream ss;
ss << c;
string result = ss.str();

// ✅ All use the SAME operator<< function!
```

---

## The Key Idea

```
        ┌──────────────┐
        │ operator<<   │
        │ (ostream&)   │
        └──────┬───────┘
               │ works with ANY of these
       ┌───────┼───────┐
       ▼       ▼       ▼
    cout     file    string
  (console) (disk)  (memory)
```

> **Hardcoding `cout` = locked to one destination**
> **Using `ostream&` = works everywhere**

This is the essence of **decoupling** — your logic doesn't care *where* data goes, only *how* to format it.
