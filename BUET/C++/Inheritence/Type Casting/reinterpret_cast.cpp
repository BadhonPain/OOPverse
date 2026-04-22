#include <iostream>
using namespace std;

struct mystruct {
    int a = 5;
    char c = 'a';
};

class A {
public:
    void display() {
        cout << "Class A" << endl;
    }
};

class B {
public:
    void display() {
        cout << "Class B" << endl;
    }
};

int main() {
    int* p = new int(65);

    char* ch = reinterpret_cast<char*>(p);
    cout << *p << endl;
    cout << *ch << endl;
    cout << p << endl;

    mystruct s;

    int* iptr = reinterpret_cast<int*>(&s);
    cout << *iptr << endl;

    iptr++;
    cout << *iptr << endl;

    B* b = new B();
    b->display();

    A* a = reinterpret_cast<A*>(b);
    a->display();

    return 0;
}