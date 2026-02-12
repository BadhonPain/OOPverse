#include <iostream>
using namespace std;
// using copy constructor
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

    ObArgProb(const ObArgProb &obj)
    {
        delete ptr;
        cout << "Copy Consstructor invoked!!!!" << endl;
        ptr = new int;
        *ptr = *obj.ptr;
    }
};

int negateP(ObArgProb obj)
{
    return -obj.getP();
}

int main()
{
    ObArgProb ob1(10);
    cout << "Before: " << ob1.getP() << endl;
    cout << "Result: " << negateP(ob1) << endl;
    cout << "After: " << ob1.getP() << endl;
    return 0;
}