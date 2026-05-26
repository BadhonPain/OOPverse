#include <iostream>
using namespace std;

class Base
{
public:
    void print() // try with virtual
    {
        cout << "From Base !" << endl;
    }
};

class Derived : public Base
{
public:
    void print()
    {
        cout << "From Derived !" << endl;
    }
};

class MyClass
{
};

int main()
{
    float pi = 3.1416;
    int num = static_cast<int>(pi);
    cout << num << endl;

    double piAgain = static_cast<double>(22) / 7;
    // double piAgain = static_cast<float>(22)/7; -> also correct
    cout << piAgain << endl;

    Derived *d = new Derived();
    d->print();
    Base *b = static_cast<Base *>(d); // upcasting
    b->print();                       // From Derived !(with virtual)
    b = new Base();
    b->print();

    Base *base = new Base();
    Derived *derived = static_cast<Derived *>(base); // downcasting
    derived->print();                                // From Base !(with virtual)
    derived = new Derived();
    derived->print();

    // MyClass* myClass = static_cast<MyClass*>(derived); -> not supported
}