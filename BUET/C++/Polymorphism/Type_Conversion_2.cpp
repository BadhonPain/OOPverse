#include <iostream>
using namespace std;

class Myclass
{
    int a;

public:
    explicit Myclass(int n) : a(n) {} // prevents implicit conversion
    explicit Myclass(const char *ch) : a(atoi(ch)) {}  // prevents implicit conversion
    int getA()
    {
        return a;
    }
};

int main()
{
    Myclass mc1(10);
    // Myclass mc1 = 10;  -> Error
    // Myclass mc2 = "1234"; -> Error
    Myclass mc2("1234");
    cout << mc1.getA() << endl;
    cout << mc2.getA() << endl;
}