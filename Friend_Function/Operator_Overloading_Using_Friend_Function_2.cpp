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

    void show()
    {
        cout << "(" << x << "," << y << ")" << endl;
    }

    friend Coord operator+(const Coord &obj1, const Coord obj2);
    friend Coord operator+(const Coord &obj, int num);
    friend Coord operator+(int num, const Coord &obj);
    friend Coord operator++(Coord &obj);
    friend Coord operator++(Coord &obj, int notused);
};

Coord operator+(const Coord &obj1, const Coord obj2)
{
    return Coord(obj1.x + obj2.x, obj1.y + obj2.y);
}

Coord operator+(const Coord &obj, int num)
{
    return Coord(obj.x + num, obj.y + num);
}

Coord operator+(int num, const Coord &obj)
{
    return Coord(num + obj.x, num + obj.y);
}

Coord operator++(Coord &obj)
{
    obj.x++;
    obj.y++;
    return obj;
}

Coord operator++(Coord &obj, int notused)
{
   Coord temp = obj;
   obj.x++;
   obj.y++;
   return temp;
}

int main()
{
    Coord c1(1, 2), c2(3, 4);
    Coord c3 = c1 + c2;
    c3.show();
    Coord c4 = c1 + 5;
    c4.show();
    Coord c5 = 5 + c1;
    c5.show();
    ++c1;
    c1.show();
    c1++;
    c1.show();
    return 0;
}