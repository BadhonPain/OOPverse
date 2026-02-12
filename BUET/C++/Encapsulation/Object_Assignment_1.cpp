#include <iostream>
using namespace std;

class Badhon
{
    int b, c;

public:
    Badhon(int b, int c)
    {
        this->b = b;
        this->c = c;
    }

    int getB()
    {
        return b;
    }

    int getC()
    {
        return c;
    }
};

class Pain
{
    int a;

public:
    Pain(int a)
    {
        this->a = a;
    }

    int getA()
    {
        return a;
    }
};

int main()
{
    Badhon b1(3, 4), b2(5, 6);
    Pain p(5);

    cout << "In b1: " << b1.getB() << " " << b1.getC() << endl;
    cout << "In b2: " << b2.getB() << " " << b2.getC() << endl;

    b1 = b2;
    // b1=p; -> not valid because different type
    cout << "In b1: " << b1.getB() << " " << b1.getC() << endl;
    cout << "In b2: " << b2.getB() << " " << b2.getC() << endl;
}