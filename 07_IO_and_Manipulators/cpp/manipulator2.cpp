#include <iostream>
#include <iomanip>
using namespace std;

ostream &setup(ostream &os)
{
    os << hex << showbase << uppercase;
    os << setw(10) << setfill('*');
    /*
    Or,
    os.width(10);
    os.fill('*');
    */
    return os;
}

istream &hex_input(istream &in)
{
    in >> hex;
    return in;
}

int main()
{
    int number;
    cout << "Enter a hexadecimal Number: ";
    cin >> hex_input >> number;
    cout << setup << number << endl;
}