#include <iostream>
using namespace std;

class alpha
{
    int data;

public:
    alpha()
    {
    }
    alpha(int x) : data(x)
    {
    }

    void display()
    {
        cout << data;
    }

    alpha &operator=(alpha &alp)
    {
        this->data = alp.data;
        cout << "\nAssignment operator invoked";
        return *this;
    }
};

int main()
{
    alpha a1(37);
    alpha a2, a3;
    a3 = a2 = a1; // invoke overloaded =, twice
    cout << "\na2=";
    a2.display(); // display a2
    cout << "\na3=";
    a3.display(); // display a3
    cout << endl;
    return 0;
}