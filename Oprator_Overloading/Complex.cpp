#include <iostream>
using namespace std;
// TF: 17-18
class Complex
{
    int real, imag;

public:
    explicit Complex(int r = 0, int i = 0) : real(r), imag(i) {}

    Complex& operator=(const Complex &c)
    {
        if (this == &c)
            return *this;
        this->real = c.real;
        this->imag = c.imag;
        return *this;
    }

    Complex operator+(const Complex &c)
    {
        return Complex(real + c.real, imag + c.imag);
    }

    friend Complex operator+(const Complex &c, int n);
    friend Complex operator+(int n, const Complex &c);

    Complex operator++(int notused)
    {
        Complex temp = *this;
        real++;
        imag++;
        return temp;
    }

    Complex operator++()
    {
        real++;
        imag++;
        return *this;
    }

    friend ostream &operator<<(ostream &out, const Complex &c);

    Complex operator()(int n)
    {
        return Complex(real + n, imag + n);
    }
};

Complex operator+(const Complex &c, int n)
{
    return Complex(c.real + n, c.imag);
}

Complex operator+(int n, const Complex &c)
{
    return Complex(c.real, c.imag + n);
}

ostream &operator<<(ostream &out, const Complex &c)
{
    out << c.real;
    if (c.imag < 0)
        out << c.imag;
    else
        out << "+" << c.imag;
    out << "i" << endl;
    return out;
}

int main()
{
    // Initialization
    Complex comp1(2, 3), comp2(5, 8);
    cout << "Initial values: " << endl;
    cout << "comp1: " << comp1 << endl;
    cout << "comp2: " << comp2 << endl
         << endl;

    // Requirement: comp3 = comp1 + comp2
    Complex comp3 = comp1 + comp2;
    cout << "comp3 = comp1 + comp2: " << comp3 << endl;

    // Requirement: comp3 = comp1 + 10 (Real increases)
    comp3 = comp1 + 10;
    cout << "comp3 = comp1 + 10: " << comp3 << endl;

    // Requirement: comp3 = 10 + comp1 (Imag increases)
    comp3 = 10 + comp1;
    cout << "comp3 = 10 + comp1: " << comp3 << endl;

    // Requirement: comp1++ (Postfix increment)
    cout << "Performing comp1++..." << endl;
    comp1++;
    cout << "After comp1++: " << comp1 << endl;

    // Requirement: ++comp1 (Prefix increment)
    cout << "Performing ++comp1..." << endl;
    ++comp1;
    cout << "After ++comp1: " << comp1 << endl;

    // Requirement: comp3 = comp1(5)
    // comp3.real = comp1.real + 5, comp3.imag = comp1.imag + 5;
    comp3 = comp1(5);
    cout << "comp3 = comp1(5) result: " << comp3 << endl;

    return 0;
}