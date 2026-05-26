#include <iostream>
#include <exception>
using namespace std;
// TF : 23-24
int divide()
{
    int a = 10;
    int d = 0;
    if (d == 0)
        throw runtime_error("Can't divide by zero");

    return a / d;
}
int main()
{
    try
    {
        cout << divide() << endl;
    }
    catch (exception &e)
    {
        cout << "Found Exception: " << e.what() << endl;
    }

    cout << "After catch" << endl;
}