#include <iostream>
using namespace std;

class Shape
{
    double base, height;

public:
    Shape() {}
    Shape(double base, double height)
    {
        this->base = base;
        this->height = height;
    }

    virtual double area()
    {
        return base * height;
    }

    ~Shape()
    {
        cout << "Shape Destructing..." << endl;
    }
};

class Circle : public Shape
{
    double radius;

public:
    Circle(double radius)
    {
        this->radius = radius;
    }

    double area()
    {
        return 3.1416 * radius * radius;
    }

    ~Circle()
    {
        cout << "Circle Destructing..." << endl;
    }
};

int main()
{
    Shape *s = new Circle(5);
    cout << s->area() << endl;
    delete s;
}