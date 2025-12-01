#include <iostream>
using namespace std;
class Student
{
public:
    string name;
    double *cgpaPtr;
    Student(string name, double cgpa)
    {
        this->name = name;
        cgpaPtr = new double;
        *cgpaPtr = cgpa;
    }
    Student(Student &object)
    {
        this->name = object.name;
        cgpaPtr = new double;
        *cgpaPtr = *object.cgpaPtr;
    }
    void showInfo()
    {
        cout << "name is: " << name << endl;
        cout << "cgpa is: " << *cgpaPtr << endl;
    }
};

int main()
{
    Student s1("Badhon", 5.00);
    Student s2(s1);
    s1.showInfo();
    *(s2.cgpaPtr) = 6.45;
    s1.showInfo();
    s2.name = "pain";
    s2.showInfo();
}
