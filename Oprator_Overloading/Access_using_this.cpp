#include <iostream>
using namespace std;

class Badhon
{
    int roll;

public:
    void set_Roll(int r)
    {
        this->roll = r;
    }

    int get_Roll()
    {
        return this->roll;
    }
};
int main()
{
    Badhon bd;
    bd.set_Roll(87);
    cout << bd.get_Roll() << endl;
}