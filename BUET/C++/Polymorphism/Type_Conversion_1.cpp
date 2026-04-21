#include <iostream>
using namespace std;

class Myclass
{
    int a;

public:
    Myclass(int n) : a(n) {}
    Myclass(const char *ch) : a(atoi(ch)) {}
    int getA()
    {
        return a;
    }
};

int main()
{
    Myclass mc1 = 10; // allowed implicit conversion 
    Myclass mc2 = "1234";
    cout << mc1.getA() << endl;
    cout << mc2.getA() << endl;
}