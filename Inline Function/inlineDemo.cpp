#include <iostream>
using namespace std;

inline int add(int a, int b)
{
    return a + b;
}

int multiply(int a, int b)
{
    return a * b;
}

int main()
{
    int x = 5, y = 10;

    cout << add(x, y) << endl;
    cout << add(20, 30) << endl;

    cout << multiply(x, y) << endl;
    cout << multiply(3, 4) << endl;

    return 0;
}