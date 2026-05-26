#include <iostream>
#include <cstring>
using namespace std;

class Rectangle
{
    char *name;
    int a;
    int b;

public:
    Rectangle(char *name, int a, int b)
    {
        this->name = new char[strlen(name) + 1];
        strcpy(this->name, name);
        this->a = a;
        this->b = b;
    }

    operator double()
    {
        return a * b;
    }

    operator char *()
    {
        return name;
    }
};

int main()
{
    Rectangle r("Rectangle", 5, 10);
    double area = r;

    cout << "Area: " << area << endl;
    char *name = r;
    cout << "Name: " << name << endl;
    return 0;
}