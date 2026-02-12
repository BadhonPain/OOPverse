#include <iostream>
using namespace std;

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

    // trying to delete same memory twice 
    // solution: 1. use pointer or reference
    //           2. use copy constructor
}