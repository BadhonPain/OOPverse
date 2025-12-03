#include <iostream>
using namespace std;
class Student
{
public:
    string instituteName;
    string rollNo;
};
class Teacher
{
public:
    string name;
    double salary;
};
class facultyMember : public Student, public Teacher
{
public:
    string researchArea;
};
int main()
{
    facultyMember f1;
    f1.instituteName = "BUET";
    f1.researchArea = "Machine Learning";
    f1.salary = 30000;
    cout << f1.instituteName << endl;
    cout << f1.salary << endl;
    cout << f1.researchArea << endl;
}
