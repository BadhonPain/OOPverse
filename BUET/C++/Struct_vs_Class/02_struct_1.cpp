// everything without pointer
#include <iostream>
#include <cstring>
using namespace std;
typedef struct xx
{
private:
    int roll;
    char name[20];
    double cgpa;

public:
    void setRoll(int r)
    {
        roll = r;
    }
    int getRoll()
    {
        return roll;
    }
    void setName(char arr[], int size)
    {
        strcpy(name, arr);
    }
    string getName()
    {
        return name;
    }
    void setCgpa(double cg)
    {
        cgpa = cg;
    }
    double getCgpa()
    {
        return cgpa;
    }

} Student;

int main()
{
    Student s1;
    // cin >> s1.name;
    // cin >> s1.roll;
    // cin >> s1.cgpa; This will generate error bcz of private class
    int s_roll;
    char s_name[20];
    double s_cgpa;
    cout << "Enter Roll: ";
    cin >> s_roll;
    s1.setRoll(s_roll);
    cout << "Roll no is: " << s1.getRoll() << endl;
    cout << "Enter Name: ";
    gets(s_name);
    s1.setName(s_name, sizeof(s_name));
    cout << "Name is: " << s1.getName() << endl;
    cout << "Enter CGPA: ";
    cin >> s_cgpa;
    s1.setCgpa(s_cgpa);
    cout << "CGPA is : " << s1.getCgpa() << endl;

    return 0;
}