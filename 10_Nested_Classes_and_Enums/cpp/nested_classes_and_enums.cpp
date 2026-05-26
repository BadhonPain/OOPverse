#include <iostream>
#include <string>

using namespace std;

enum class Color { Red, Green, Blue };

class Outer {
    int outerVal = 42;
public:
    class Nested {
    public:
        void print(const Outer& outer) {
            cout << "Outer value accessed: " << outer.outerVal << endl;
        }
    };
};

int main() {
    Outer outer;
    Outer::Nested nested;
    nested.print(outer);

    Color c = Color::Green;
    switch (c) {
        case Color::Red:   cout << "Color: Red" << endl; break;
        case Color::Green: cout << "Color: Green" << endl; break;
        case Color::Blue:  cout << "Color: Blue" << endl; break;
    }
    return 0;
}
