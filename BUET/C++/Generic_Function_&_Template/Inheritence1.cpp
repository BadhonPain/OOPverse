#include <iostream>
using namespace std;

template <class T>
class Shape
{
public:
    virtual T getArea() = 0;
    virtual void displayName()
    {
        cout << "Shape";
    }
};

template <class T>
class Rectangle : public Shape<T>
{
    T base, height;

public:
    Rectangle(T b, T h) : base(b), height(h) {};

    T getArea() override
    {
        return base * height;
    }

    void displayName() override
    {
        cout << "Rectangle";
    }
};

template <>
class Rectangle<int> : public Shape<int>
{
    int a, b;

public:
    Rectangle(int a, int b) : a(a), b(b) {}

    int getArea() override
    {
        return (a + b) * (a + b);
    }

    void displayName() override
    {
        cout << "Specialized Rectangle<int>";
    }
};

template <class T>
class Circle : public Shape<T>
{
    T radius;

public:
    Circle(T r) : radius(r) {}

    T getArea() override
    {
        return 3.1416 * radius * radius;
    }

    void displayName() override
    {
        cout << "Circle";
    }
};

template <class T>
class Triangle : public Shape<T>
{
    T base, height;

public:
    Triangle(T b, T h) : base(b), height(h) {}

    T getArea() override
    {
        return 0.5 * base * height;
    }

    void displayName() override
    {
        cout << "Triangle";
    }
};

template <class T>
void show(Shape<T> *obj)
{
    obj->displayName();
    cout << "'s Area: " << obj->getArea() << endl;
}

int main()
{
    Rectangle<double> r1(5.0, 3.0);
    Circle<double> c1(2.0);
    Triangle<double> t1(4.0, 6.0);

    Rectangle<int> r2(2, 3); // should use specialized version

    cout << "--- Double Shapes ---" << endl;
    show(&r1);
    show(&c1);
    show(&t1);

    cout << "\n--- Int Specialized ---" << endl;
    show(&r2);

    return 0;
}