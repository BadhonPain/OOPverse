#include <iostream>
using namespace std;

class Number
{
public:
    int x;
    void incX()
    {
        x++;
    }
};
int main()
{
    Number n1;
    n1.x = 12;
    cout << n1.x << endl;
    Number n2;
    n2.x = 21;
    cout << n2.x << endl;
}