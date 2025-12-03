#include <iostream>
using namespace std;
class Student_1
{
public:
    virtual void messi()
    {
        cout << "Que miras, bobo? Anda para alla! from parents class\n";
    }
};
class Student_2 : public Student_1
{
public:
    void messi()
    {
        cout << "Que miras, bobo? Anda para alla! from derived class\n";
    }
};

int main()
{
    Student_2 s1;
    s1.messi();
}
