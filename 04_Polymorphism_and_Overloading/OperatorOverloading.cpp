#include <iostream>
using namespace std;

class Complex
{
    int real, ima;

public:
    Complex(int real, int ima) : real(real), ima(ima) {}

    Complex operator+(const Complex &c)
    {
        return Complex(real + c.real, ima + c.ima);
    }

    Complex operator-(const Complex &c)
    {
        return Complex(real - c.real, ima - c.ima);
    }

    Complex operator*(const Complex &c)
    {
        return Complex(real * c.real - ima * c.ima, real * c.ima + c.real * ima);
    }

    void display()
    {
        cout << real;
        if (ima < 0)
            cout << ima;
        else
            cout << "+" << ima;
        cout << "i" << endl;
    }
};

int main()
{
    Complex c1(2, 3), c2(4, 5);
    Complex c3 = c1 + c2; // 6+8i
    Complex c4 = c1 - c2; // -2-2i
    Complex c5 = c1 * c2; // -7+22i
    cout << "Addition: ";
    c3.display();
    cout << "Subtraction: ";
    c4.display();
    cout << "Multiplication: ";
    c5.display();
}