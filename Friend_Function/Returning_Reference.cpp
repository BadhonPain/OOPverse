#include <iostream>
using namespace std;

class Coord
{
    int x, y;

public:
    Coord() {};

    Coord(int a, int b)
    {
        x = a;
        y = b;
    }

    friend istream &operator>>(istream &in, Coord &obj);
    friend ostream &operator<<(ostream &out, Coord &obj);
    Coord &operator+=(const Coord &obj);
};

istream &operator>>(istream &in, Coord &obj)
{
    cout << "Enter coordinates: ";
    in >> obj.x >> obj.y;
    return in;
}

ostream &operator<<(ostream &out, Coord &obj)
{
    out << "(" << obj.x << "," << obj.y << ")";
    return out;
}

Coord &Coord::operator+=(const Coord &obj)
{
    x += obj.x;
    y += obj.y;
    return *this;
}

int main()
{
    Coord a(10, 20), b;
    int x, y;
    cin >> b;
    cout << b << endl;
    a += b;
    cout << a << endl;
    return 0;
}