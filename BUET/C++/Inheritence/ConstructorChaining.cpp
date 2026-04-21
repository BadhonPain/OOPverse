#include <iostream>
using namespace std;

class Vehicle
{
    int speed;

public:
    Vehicle()
    {
        cout << "Default of Vehicle Invoked..." << endl;
    }

    Vehicle(int speed) : speed(speed) {}

    int getSpeed()
    {
        return speed;
    }
};

class Car : public Vehicle
{
    string brand;

public:
    Car() { cout << "Default of Car Invoked...." << endl; }
    Car(string brand, int speed) : Vehicle(speed), brand(brand) {}

    void display()
    {
        cout << "Brand: " << brand << endl;
        cout << "Speed: " << Vehicle::getSpeed() << endl;
    }
};

int main()
{
    Car *c1;
    Car c2;   // see the differences 
    new Car();
    Car c("Toyota", 120);
    c.display();
}