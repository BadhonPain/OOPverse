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
    ~Student() // destructor
    {
        cout << "I'm destructor, can i be your type?" << endl;
        delete cgpaPtr; // for dynamically alocated memory
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
    s1.showInfo();
}
