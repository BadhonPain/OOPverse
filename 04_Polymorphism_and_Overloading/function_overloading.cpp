#include <iostream>
using namespace std;
class Human
{
public:
    void getAge()
    {
        cout << "Iam default stage shower\n";
    }
    void getAge(string stage)
    {
        cout << "Iam specific staged age shower\n& You are " << stage << endl;
        ;
    }
    void getAge(int age)
    {
        cout << "Iam age shower\n& Your age is " << age << endl;
    }
};
int main()
{
    Human h1;
    h1.getAge("young");
    h1.getAge(19);
}