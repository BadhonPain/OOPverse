#include <iostream>
using namespace std;

class ObArg
{
    int a;

public:
    ObArg(int a)
    {
        cout << "Contructing..." << endl;
        this->a = a;
    }

    ~ObArg()
    {
        cout << "Destructing..." << endl;
    }

    void setA(int a)
    {
        this->a = a;
    }

    int getA()
    {
        return a;
    }
};

void sqrOb(ObArg obj)
{
    obj.setA(obj.getA() * obj.getA());
    cout << "Inside sqrOb: " << obj.getA() << endl;
}


int main()
{
    ObArg ob1(10);
    cout << "Before sqrOb: " << ob1.getA() << endl;
    sqrOb(ob1);
    cout << "After sqrOb: " << ob1.getA() << endl;
    return 0;
}