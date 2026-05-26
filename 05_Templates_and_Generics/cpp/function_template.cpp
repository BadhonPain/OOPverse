#include <iostream>
using namespace std;
// TF: 21-22
template <typename T>
void myfunc(T t1, T t2, char ch)
{
    if (ch == '+')
        cout << t1 + t2 << endl;
    else if (ch == '*')
        cout << t1 * t2 << endl;
    else if (ch == '-')
        cout << t1 - t2 << endl;
    else
        cout << "Invalid Input" << endl;
}

int main()
{
    myfunc(10.5, 4.3, '+');
    myfunc(4, 8, '*');
    myfunc(10.5, 4.5, '-');
    myfunc(3, 6, 'a');

    return 0;
}