#include <iostream>
#include <exception>
using namespace std;

enum ErrorType
{
    InvalidInput,
    DivideByZero,
    OutOfRange
};

void Xtest(int a)
{
    if (a < 0)
        throw InvalidInput;
    else if (a == 0)
        throw DivideByZero;
    else
        throw a;
}

int main()
{
    int a = 0;
    try
    {
        if (a == 0)
            throw DivideByZero;
        else if (a > 10)
            throw OutOfRange;
        else
            throw a;
        Xtest(0);
        Xtest(-5);
        Xtest(2);
        Xtest(20);
    }
    catch (ErrorType e)
    {
        if (e == InvalidInput)
        {
            cout << "Invalid Input" << endl;
        }
        else if (e == DivideByZero)
        {
            cout << "Divide By Zero" << endl;
        }
        else if (e == OutOfRange)
        {
            cout << "Out of Range" << endl;
        }
    }
    catch (int i)
    {
        cout << "Caught an integer: " << i << endl;
    }
    catch (...)
    {
        cout << "Caught a String. " << endl;
    }

    cout << "After Catch..." << endl;
    return 0;
}