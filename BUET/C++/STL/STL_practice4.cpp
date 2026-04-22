#include <iostream>
#include <map>
#include <algorithm>
using namespace std;
// TF: 20-21
class Student
{
    int ID;
    string name, address;
    string mobile_num;
    double cgpa;

public:
    Student() {}
    Student(int ID, string name, string address, string mobile_num, double cgpa)
    {
        this->address = address;
        this->cgpa = cgpa;
        this->ID = ID;
        this->mobile_num = mobile_num;
        this->name = name;
    }

    int getID() const
    {
        return ID;
    }

    void display() const
    {
        cout << "Name: " << name << "\nID: " << ID << "\nAddress: " << address << "\nMobile Number: " << mobile_num << "\nCGPA: " << cgpa << endl;
    }
};

int main()
{
    map<int, Student> record;
    int stuID;
    cout << "Enter Student ID: ";
    cin >> stuID;

    tring stuName, stuAdd, stuNum;
    cout << "Enter Student's Name: ";
    getline(cin, stuName);

    cout << "Enter Student's Address: ";
    getline(cin, stuAdd);

    cout << "Enter Student's Mobile Number: ";
    getline(cin, stuNum);

    double stuGpa;
    cout << "Enter Student's CGPA: ";
    cin >> stuGpa;

    record.insert(pair<int, Student>(stuID, Student(stuID, stuName, stuAdd, stuNum, stuGpa)));
    cout << "Enter Student ID to see all details about him/her: ";
    int target;
    cin >> target;

    map<int, Student>::iterator it = record.find(target);
    if (it != record.end())
    {
        it->second.display();
    }
    else
        cout << "No Match Found !" << endl;
}