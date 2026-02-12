#include <iostream>
using namespace std;

class Counter
{
    int val;

public:
    Counter() : val(0)
    {
    }

    Counter(int k) : val(k)
    {
    }

    int getValue()
    {
        return val;
    }

    Counter operator++()
    {
        ++val;
        return Counter(val);
    }
};
int main()
{

    Counter c1, c2;
    ++c1;
    ++c2;
    Counter c3 = ++c2;
    cout << "Value of c1: " << c1.getValue() << endl;
    cout << "Value of c2: " << c2.getValue() << endl;
    cout << "Value of c3: " << c3.getValue() << endl;
}