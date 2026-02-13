#include <iostream>
using namespace std;

class Truck;

class Car
{
    int passanger;
    int speed;

public:
    Car(int p, int s)
    {
        passanger = p;
        speed = s;
    }

    friend int speedGreater(Car c, Truck t);
};

class Truck
{
    int weight;
    int speed;

public:
    Truck(int w, int s)
    {
        weight = w;
        speed = s;
    }

    friend int speedGreater(Car c, Truck t);
};

int speedGreater(Car c, Truck t)
{
    return c.speed - t.speed;
}

int main()
{
    Car c(5, 70);
    Truck t(500, 60);
    cout << "Speed Gap: " << speedGreater(c, t) << endl;
    return 0;
}