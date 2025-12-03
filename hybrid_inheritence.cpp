#include <iostream>
using namespace std;
class human
{
public:
    string name;
    int age;
};
class Student : public human
{
public:
    string rollNo;
};
class Teacher : public human
{
public:
    double salary;
};
class underGradStudent : public Student
{
public:
    int level;
    int term;
};
class facultyMember : public Student, public Teacher
{
public:
    string instituteName;
    string researchArea;
};
int main()
{
    underGradStudent u1;
    u1.level = 1;
    u1.term = 2;
    facultyMember f1;
    f1.salary = 100000;
    Teacher t1;
    t1.age = 56;
    cout << "Iam a under graduate student at level " << u1.level << " term " << u1.term << endl;
    cout << "Iam a faculty member with a salary of " << f1.salary << endl;
    cout << "Iam a teacher and my age is  " << t1.age << endl;
}
