#include <iostream>
using namespace std;

int main() {
    // Save the original flags so we can restore them later
    ios::fmtflags f = cout.flags();
    
    // First line: Standard formatting
    cout << 123.45 << " Hello " << -10 << " " << 100.0 << " " << 100 << endl;

    // Second line: Set hex, showbase (0x), and showpos (+)
    // unsetf(ios::dec) removes the decimal default
    cout.unsetf(ios::dec);
    cout.setf(ios::hex | ios::showbase | ios::showpos);
    cout << 123.45 << " Hello " << -10 << " " << 100.0 << " " << 100 << endl;

    // Third line: Scientific notation, show decimal point, uppercase letters
    ios::fmtflags f2 = ios::scientific | ios::showpoint | ios::uppercase;
    cout.setf(f2);
    cout << 123.45 << " Hello " << -10 << " " << 100.0 << " " << 100 << endl;

    // Check if decimal is set, then restore original flags
    if (f & ios::dec) cout << "Dec is set" << endl;
    
    // Restore original state
    cout.flags(f);
    
    // Fourth line: Should match the very first line
    cout << 123.45 << " Hello " << -10 << " ";
    cout << 100.0 << " " << 100 << endl;

    return 0;
}