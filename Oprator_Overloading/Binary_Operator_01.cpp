#include <iostream>
using namespace std;

class Distance
{
    int feet;
    float inches;

public:
    Distance()
    {
    }

    Distance(int f, float in) : feet(f), inches(in)
    {
    }
    void getdist()
    {
        cout << "\nEnter feet: ";
        cin >> feet;
        cout << "\nEnter inches: ";
        cin >> inches;
    }

    void showdist()
    {
        cout << "Distance : " << feet << "feet and " << inches << "inches" << endl;
    }

    Distance operator+(const Distance &dist)
    {
        Distance temp = *this;
        temp.feet += dist.feet;
        temp.inches += dist.inches;
        return temp;
    }

    /* Distance operator+(const Distance &dist)
    {
        int f = feet+dist.feet;
        float inch = inches+dist.inches
        return Distance(f,inch);
    } // same thing just different implementation
    */
};

int main()
{
    Distance dist1, dist3, dist4;  // define distances
    dist1.getdist();               // get dist1 from user
    Distance dist2(11, 6.25);      // define, initialize dist2
    dist3 = dist1 + dist2;         // single ‘+’ operator
    dist4 = dist1 + dist2 + dist3; // multiple ‘+’ operators
    // display all lengths
    cout << "dist1 = ";
    dist1.showdist();
    cout << endl;
    cout << "dist2 = ";
    dist2.showdist();
    cout << endl;
    cout << "dist3 = ";
    dist3.showdist();
    cout << endl;
    cout << "dist4 = ";
    dist4.showdist();
    cout << endl;
    return 0;
}
