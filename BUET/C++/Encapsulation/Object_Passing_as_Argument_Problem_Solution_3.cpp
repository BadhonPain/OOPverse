#include <iostream>
using namespace std;
// using pointer or reference
class ObArgProb
{
    int *ptr;

public:
    ObArgProb(int a)
    {
        cout << "Contructing..." << endl;
        ptr = new int;
        *ptr = a;
    }

    ~ObArgProb()
    {
        cout << "Destructing..." << endl;
        delete ptr;
    }

    int getP()
    {
        return *ptr;
    }
};

int negateP(ObArgProb *obj) // for using reference: int negateP(ObArgProb &obj)
{
    return -obj->getP();
}

int main()
{
    ObArgProb ob1(10);
    cout << "Before: " << ob1.getP() << endl;
    cout << "Result: " << negateP(&ob1) << endl;
    // cout << "Result: " << negateP(ob1) << endl; (for using reference)
    cout << "After: " << ob1.getP() << endl;
    return 0;

    // Copy the address of the object instead of copying the whole object
}