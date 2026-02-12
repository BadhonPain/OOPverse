#include <iostream>
using namespace std;

class Point
{
    int x, y;

public:
    Point(int a, int b)
    {
        x = a;
        y = b;
    }

    Point operator+(const Point &ob) 
    {
        this->x = x + ob.x;
        this->y = y + ob.y;
        return *this;
    }

    void show()
    {
        cout << "(" << x << "," << y << ")" << endl;
    }
};
int main()
{
    Point p1(1, 2), p2(3, 4);
    Point p3 = p1 + p2;
    p3.show();
}