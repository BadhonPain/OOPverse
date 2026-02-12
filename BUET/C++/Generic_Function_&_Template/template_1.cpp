#include <iostream>
using namespace std;

template <typename T>
void Swap(T &a, T &b)
{
    T temp = a;
    a = b;
    b = temp;
}
int main()
{
    int a = 5, b = 6;
    char x = 'a', y = 'b';
    string name1 = "Badhon", name2 = "Pain";
    cout << "Before swapping: \na: " << a << " b: " << b << "\nx: " << x << " y: " << y << "\nname1: " << name1 << " name2: " << name2 << endl;
    Swap(a, b);
    Swap(x, y);
    Swap(name1, name2);
    cout << "After swapping: \na: " << a << " b: " << b << "\nx: " << x << " y: " << y << "\nname1: " << name1 << " name2: " << name2 << endl;
}