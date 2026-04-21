#include <iostream>
using namespace std;
// TF: 23-24
class Complex
{
    int real;
    int imaginary;

public:
    friend istream &operator>>(istream &in, Complex &obj);
    friend ostream &operator<<(ostream &out, const Complex &obj);
};

istream &operator>>(istream &in, Complex &obj)
{
    cout << "Enter real part: ";
    in >> obj.real;
    if (obj.real < 0)
    {
        in.setstate(ios::failbit);
        return in;
    }
    cout << "Enter imaginary part: ";
    in >> obj.imaginary;
    if (obj.imaginary < 0)
    {
        in.setstate(ios::failbit);
        return in;
    }
    return in;
}

ostream &operator<<(ostream &out, const Complex &obj)
{
    out << obj.real << "+" << obj.imaginary << "i" << endl;
    return out; // why we use out here instead cout? check the preview of genericity_decoupling.md and whyOut.cpp
}

int main()
{
    Complex c;
    if (cin >> c)
        cout << "You've entered: " << c;
    else
        cout << "Invalid input !" << endl;
}