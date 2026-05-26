#include <iostream>
using namespace std;

class TollBooth
{
    unsigned int totalCars;
    // static unsigned int totalCars;
    double totalMoney;

public:
    TollBooth() : totalCars(0),totalMoney(0) {}
    // TollBooth(unsigned int totalCars, double totalMoney) : totalCars(totalCars), totalMoney(totalMoney) {}

    void payingCar()
    {
        totalCars++;
        totalMoney += 0.5;
    }

    void noPayCar()
    {
        totalCars++;
    }

    void display() const
    {
        cout << "Total Cars: " << totalCars << "\nTotal Toll: " << totalMoney << endl;
    }
};

// unsigned int TollBooth:: totalCars = 0;

int main()
{
    TollBooth tollBooth_1;
    TollBooth tollBooth_2;

    
    for (int i = 0; i < 10; i++)
    {
        tollBooth_1.payingCar();
    }
    for (int i = 0; i < 10; i++)
    {
        tollBooth_2.noPayCar();
    }

    tollBooth_1.display();
    tollBooth_2.display();
    
}