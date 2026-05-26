#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
    cout << hex << 100 << endl;
    cout << oct << 10 << endl;
    cout << setfill('*') << setw(10);
    cout << 100 << " hi" << endl; // octal of 100 will be printed
    cout << 123 << endl;  // octal of 123 will be printed
    cout << dec << 120 << endl; // decimal of 120 will be printed
    return 0;
}