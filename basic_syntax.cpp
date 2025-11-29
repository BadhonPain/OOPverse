#include <iostream>
using namespace std;
class Teacher
{
public: // properties / attributes
    string name;
    string dept;
    string subject;
    double salary;
    void changeDept(string department) // method
    {
        dept = department;
    }
};

int main()
{
    Teacher t1;
    t1.name = "Badhon";
    t1.salary = 250000;
    t1.changeDept("mecha");
    cout << t1.name << endl;
    cout << t1.dept << endl;
    cout << t1.salary << endl;
}
