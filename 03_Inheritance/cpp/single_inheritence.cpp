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

int main()
{
    Student_2 s1;
    s1.schoolName = "MGHS";
    s1.rollNo = 8;
    cout << s1.schoolName << endl;
    cout << s1.rollNo << endl;
}
