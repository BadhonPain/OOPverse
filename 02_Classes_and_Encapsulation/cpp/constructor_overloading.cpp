#include <iostream>
using namespace std;
class Human
{
public:
    string name;
    int age;
    Human()
    {
        cout << "Iam a non-parameterized constructor\n";
    }
    Human(string name, int age)
    {
        cout << "Iam a parameterized constructor\n";
        this->name = name;
        this->age = age;
    }
};
int main()
{
    Human h1;
    h1.age = 45;
    cout << h1.age << endl;
    Human h2("George Badhon The Cantor Pain", 19);
    h2.age = 20;
    cout << h2.age << endl;
}