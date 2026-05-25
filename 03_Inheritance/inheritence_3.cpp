#include <iostream>
using namespace std;
class Student_1
{
public:
    string schoolName;
    string Standard;
    Student_1() // non-parameterized
    {
        cout << "Iam parents class constructor" << endl;
    } // for checking who is called first
    ~Student_1() // non-parameterized
    {
        cout << "Iam parents class destructor" << endl;
    } // for checking who is called first
};
class Student_2 : public Student_1
{
public:
    int rollNo;
    Student_2() // for checking who is called first
    {
        cout << "Iam child class constructor" << endl;
    }
    ~Student_2() // for checking who is called first
    {
        cout << "Iam child class destructor" << endl;
    }
    // calling sequence -> parents class constructor ->child class constructor-> parents class destructor-> child class destructor
    void showInfo()
    {
        cout << "schoolName is: " << schoolName << endl;
        cout << "standard is: " << Standard << endl;
        cout << "rollNo is: " << rollNo << endl;
    }
};

int main()
{
    Student_2 s1;
    s1.schoolName = "MGHS";
    s1.Standard = "10th class";
    s1.rollNo = 8;
    s1.showInfo();
}
