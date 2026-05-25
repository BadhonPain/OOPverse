#include <iostream>
using namespace std;

class Number
{
public:
    int value;

    Number(int v = 0)
    {
        value = v;
    }

    Number operator+(const Number &obj)
    {
        return Number(value + obj.value);
    }
};

int main()
{
    Number a(5);
    Number b(7);
    Number c = a + b;
    cout << "Result: " << c.value << endl;
}
