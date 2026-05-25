#include <iostream>
#include <cmath>
using namespace std;

int main() {

    cout << "Hello" << endl;                 // prints Hello
    cout << 123.456789 << endl;              // default floating output

    cout.width(10);                          // set width to 10 (next output only)
    cout << "Hello" << endl;                 // right aligned by default

    cout.width(10);                          // width again for next output
    cout.fill('*');                          // fill empty spaces with '*'
    cout << "Hello" << endl;                 // padded with '*'

    cout.precision(8);                       // total digits (not fixed yet)
    cout << 123.456789 << endl;              // precision effect

    cout.width(12);                          // width = 12
    cout.fill('%');                          // fill with '%'
    cout.setf(ios::left);                    // left alignment
    cout << 123.456789 << endl;              // left aligned with %

    cout.fill(' ');                          // reset fill to space
    cout.setf(ios::right);                   // right alignment again
    cout.precision(4);                       // reduce precision

    for (double x = 2.0; x <= 5; x++) {
        cout.width(7);
        cout << x;                           // print x

        cout.width(12);
        cout << sqrt(x);                     // print sqrt(x)

        cout.width(7);
        cout << x * x << endl;               // print x^2
    }

    return 0;
}