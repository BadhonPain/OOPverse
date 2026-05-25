#include <iostream>
using namespace std;
class facultyMember
{
public:
    string instituteName;
    string researchArea;
    string name;
};
class Student : public facultyMember
{
public:
    string rollNo;
};
class Teacher : public facultyMember
{
public:
    double salary;
};
int main()
{
    Student s1;
    Teacher t1;
    s1.instituteName = "BUET";
    t1.salary = 30000;
    t1.researchArea = "Machine Learning";
    cout << "Iam a student from " << s1.instituteName << endl;
    cout << "Iam a teacher, specialist at " << t1.researchArea
         << " & with the salary " << t1.salary << endl;
}
