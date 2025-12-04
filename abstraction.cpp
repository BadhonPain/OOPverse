#include <iostream>
using namespace std;
class Draw
{
public:
    virtual void draw()
    {
    }
};
class Circle
{
public:
    void draw()
    {
        cout << "It is a circle\n";
    }
};
class Rectangle
{
public:
    void draw()
    {
        cout << "It is a rectangle\n";
    }
};
int main()
{
    Circle c1;
    c1.draw();
    Rectangle r1;
    r1.draw();
}