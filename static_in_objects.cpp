#include <iostream>
using namespace std;

class Number
{
public:
    Number()
    {
        cout << "Iam a constructor\n";
    }
    ~Number()
    {
        cout << "Iam a destructor\n";
    }
};
int main()
{
    if (1)
    {
        static Number n1;
    }
    cout << "This is the end of main function\n";
}