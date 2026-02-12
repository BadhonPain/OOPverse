#include <iostream>
using namespace std;

class Array
{
    int x;

public:
    Array()
    {
        x = 0;
    }
    Array(int n)
    {
        x = n;
    }
    void show()
    {
        cout << x << " ";
    }
};
int main()
{
    Array a1[5];
    Array a2[5] = {1, 2, 3, 4, 5};
    for (int i = 0; i < 5; i++)
    {
        a1[i].show();
        a2[i].show();
        cout << endl;
    }
}