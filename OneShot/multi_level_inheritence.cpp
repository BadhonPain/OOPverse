#include <iostream>
using namespace std;
class Student_1
{
public:
    string schoolName;
    string Standard;
};
class Student_2 : public Student_1
{
public:
    int rollNo;
};
class Student_3 : public Student_2
{
public:
    int age;
};
int main()
{
    Student_3 s1;
    s1.schoolName = "MGHS";
    s1.rollNo = 8;
    s1.Standard = "10th class";
    s1.age = 16;
    cout << s1.schoolName << endl;
    cout << s1.rollNo << endl;
    cout << s1.Standard << endl;
    cout << s1.age << endl;
}
