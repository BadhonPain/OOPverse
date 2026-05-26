#include <iostream>
using namespace std;

class Coord
{
    int x, y;

public:
    Coord(int a, int b)
    {
        x = a;
        y = b;
    }

    Coord operator++()
    {
        x++;
        y++;
    }

    Coord operator+=(Coord ob)
    {
        x+=ob.x;
        y+=ob.y;
        return *this;
    }

    void show()
    {
        cout << "(" << x << "," << y << ")" << endl;
    }
};

int main()
{
    Coord a(10, 20), b(2, 3);
    a+=b;
    a.show();
    ++a;
    a.show();
    b = ++a;
    b.show();
    return 0;
}