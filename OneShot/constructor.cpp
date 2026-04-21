#include <iostream>
using namespace std;
class Teacher
{
private:
    double salary;

public:
    Teacher() // non-parameterized constructor
    {
        dept = "Computer Science";
    }
    Teacher(string n, string d) // parameterized constructor
    {
        name = n;
        dept = d;
    }
    string name;
    string dept;
    void showInfo()
    {
        cout << "instructor: " << name << endl;
        cout << "from dept of " << dept << endl;
    }
};

int main()
{
    Teacher t1("Badhon", "Computer_Science"); // constructor call
    t1.showInfo();
}
