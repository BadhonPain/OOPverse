#include <iostream>
using namespace std;
class Teacher
{
    private: 
    double salary;
public: //
    string name;
    string dept;
    string subject;

};

int main()
{
    Teacher t1;
    t1.name = "Badhon";
    t1.salary = 250000;
    cout << t1.name << endl;
}
