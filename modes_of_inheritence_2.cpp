#include <iostream>
using namespace std;
class Student_1
{
public:
    string schoolName;
    string Standard;
    Student_1(string schoolName, string Standard) // parameterized
    {
        cout << "Iam parents class constructor" << endl;
        this->schoolName = schoolName;
        this->Standard = Standard;
    }
};
class Student_2 : private Student_1 // now we can't access it's info; check line 37
{
public:
    int rollNo;
    Student_2(string schoolName, string Standard, int rollNo) : Student_1(schoolName, Standard) // for checking who is called first
    {
        cout << "Iam child class constructor" << endl;
        this->rollNo = rollNo;
    }

    void showInfo()
    {
        cout << "schoolName is: " << schoolName << endl;
        cout << "standard is: " << Standard << endl;
        cout << "rollNo is: " << rollNo << endl;
    }
};

int main()
{
    Student_2 s1("MGHS", "10th class", 8);
    s1.showInfo();
    // cout<< s1.schoolName << endl; this line is generating error
}
