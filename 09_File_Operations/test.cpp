#include <iostream>
#include <iomanip>
using namespace std;

ostream &setup(ostream &out)
{
    out << left << fixed << setprecision(3);
    out.width(10);
    out.fill('%');
    return out;
}
int main()
{
    double number;
    cin >> number;
    cout << setup << number << endl;
}