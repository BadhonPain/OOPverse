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

    void getxy(int &a, int &b)
    {
        a = x;
        b = y;
    }

    Coord operator++(int notused);
    Coord operator++();
    Coord operator+(const Coord &obj);
    Coord operator*(const Coord &obj);
    Coord operator+(int num);
    friend Coord operator+(int num, const Coord &obj);
    friend bool operator==(int num, const Coord &obj);
};

Coord Coord ::operator++(int notused)
{
    Coord temp = *this;
    x++;
    y++;
    return temp;
}

Coord Coord::operator++()
{
    x++;
    y++;
    return *this;
}

Coord Coord::operator+(const Coord &obj)
{
    Coord temp = *this;
    temp.x += obj.x;
    temp.y += obj.y;
    return temp;
}

Coord Coord ::operator*(const Coord &obj)
{
    Coord temp = *this;
    temp.x *= obj.x;
    temp.y *= obj.y;
    return temp;
}

Coord Coord ::operator+(int num)
{
    Coord temp = *this;
    temp.x += num;
    temp.y += num;
    return temp;
}

Coord operator+(int num, const Coord &obj)
{
    Coord temp;
    temp.x = obj.x + num;
    temp.y = obj.y + num;
    return temp;
}

bool operator==(int num, const Coord &obj)
{
    return num == obj.x && num == obj.y;
}

int main()
{
    Coord a(10, 20), b(4, 4), c;
    int x, y;
    c = a++;
    c.getxy(x, y);
    cout << x << " " << y << endl;
    a.getxy(x, y);
    cout << x << " " << y << endl;
    c = ++a;
    c.getxy(x, y);
    cout << x << " " << y << endl;
    a.getxy(x, y);
    cout << x << " " << y << endl;
    (a * b).getxy(x, y);
    cout << x << " " << y << endl;
    if (4 == b)
        cout << "Equal" << endl;
    else
        cout << "Not equal" << endl;
    (20 + a).getxy(x, y);
    cout << x << " " << y << endl;
    (a + b + c + 100).getxy(x, y);
    cout << x << " " << y << endl;
    c = a++;
    c.getxy(x, y);
    cout << x << " " << y << endl;
    return 0;
}