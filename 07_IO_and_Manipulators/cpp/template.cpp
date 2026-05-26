#include <iostream>
using namespace std;

template <class T>
class Gen
{
    T val;

public:
    Gen(T v) { val = v; }
    T getval() { return val; }
};

int main()
{
    Gen<int> iob(88);
    Gen<double> dob(22.22);
    Gen<char> cob('X');
    cout << "Value: " << iob.getval() << endl;
    cout << "Value: " << dob.getval() << endl;
    cout << "Value: " << cob.getval() << endl;
    return 0;
}