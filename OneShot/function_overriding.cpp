#include <iostream>
using namespace std;
class Student_1
{
public:
    string schoolName;
    string Standard;
    void showInfo()
    {
        cout << "Iam a function in parents class, developed by Badhon Pain\n";
    }
};
class Student_2 : public Student_1
{
public:
    int rollNo;
    void showInfo()
    {
        cout << "Iam a function in derived class, developed by Badhon Pain\n";
    }
};

int main()
{
    Student_1 s1; 
    s1.showInfo();
}
