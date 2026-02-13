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

    int speedGreater(Truck t);
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

    friend int Car::speedGreater(Truck t);
};

int Car ::speedGreater(Truck t)
{
    return speed - t.speed;
}

int main()
{
    Car c(5, 70);
    Truck t(500, 60);
    cout << "Speed Gap: " << c.speedGreater(t) << endl;
    return 0;
}