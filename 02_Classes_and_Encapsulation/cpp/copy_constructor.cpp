#include <iostream>
using namespace std;
class Teacher
{

public:
    Teacher(string name, string dept)
    {
        this->name = name;
        this->dept = dept;
    }
    Teacher(Teacher &newObj) // custom copy constructor
    {
        cout << "Now, you're into custom copy constructor" << endl;
        this->name = newObj.name;
        this->dept = newObj.dept;
    }
    string name;
    string dept;
    void showInfo()
    {
        cout << "instructor: " << name << endl;
        cout << "from dept of " << dept << endl;
    }
};

int main()
{
    Teacher t1("Badhon", "Computer_Science");
    // t1.showInfo();
    Teacher t2(t1); // default copy constructor
    cout << t2.dept << endl;
    t2.showInfo();
}
