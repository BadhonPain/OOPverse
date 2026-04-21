#include <iostream>
using namespace std;
class Teacher
{
private:
    double salary;

public:
    string name;
    string dept;
    string subject;
    void setSalary(double s) // setter function
    {
        salary = s;
    }
    double getSalary() // getter function
    {
        return salary;
    }
};

int main()
{
    Teacher t1;
    t1.name = "Badhon";
    // t1.salary = 250000; we can't print salary now in this way bcz the salary is private but we can print using stter and getter
    // double z;
    // cin >> z;
    // t1.setSalary(z); user input
    t1.setSalary(100000);
    cout << t1.getSalary() << endl;
    cout << t1.name << endl;
}
