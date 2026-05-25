#include <iostream>
using namespace std;

class Figure
{
    double dim1, dim2;

public:
    Figure();
    Figure(double a, double b)
    {
        dim1 = a;
        dim2 = b;
    }
    virtual double area() = 0;

    virtual void show()
    {
        cout << "Abstract" << endl;
    }
};

class Rectangle : public Figure
{
    double dim1, dim2;

public:
    Rectangle(double a, double b)
    {
        dim1 = a;
        dim2 = b;
    }
    double area()
    {
        return dim1*dim2;
    }
    void show()
    {
        cout<<"Rectangle Area: "<< area()<<endl;
    }
};

class Triangle : public Figure
{
    double dim1, dim2;

public:
    Triangle(double a, double b)
    {
        dim1 = a;
        dim2 = b;
    }
    double area()
    {
        return 0.5*dim1*dim2;
    }
    void show()
    {
        cout<<"Triangle Area: "<< area()<<endl;
    }
};
int main()
{
    Triangle t1(2,5);
    t1.show();
}