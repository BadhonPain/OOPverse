#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;
// TF: 23-24
class Complex
{
    int real;
    int imaginary;

public:
    Complex(int real, int imaginary) : real(real), imaginary(imaginary) {}

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
    return out;
}

int main()
{
    Complex c(3, 8);

    // 1. Works with console
    cout << c << endl;

    // 2. Works with files (No changes needed to operator<<!)
    ofstream file("output.txt");
    file << c;

    // 3. Works with strings (No changes needed to operator<<!)
    stringstream ss;
    ss << c;
    string s = ss.str(); // "3+8i" is now in the string s
}