#include <iostream>
#include <string>

using namespace std;

struct Student {
    int roll;
    string name;
    double cgpa;
};

int main() {
    Student s1;
    cout << "Enter student's name: ";
    getline(cin, s1.name);
    cout << "Enter student's roll: ";
    cin >> s1.roll;
    cout << "Enter student's cgpa: ";
    cin >> s1.cgpa;

    cout << "\nName: " << s1.name << endl;
    cout << "Roll: " << s1.roll << endl;
    cout << "CGPA: " << s1.cgpa << endl;

    return 0;
}
