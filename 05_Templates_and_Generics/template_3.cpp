#include <iostream>
using namespace std;

const int TABWIDTH = 8;
// Display data at specified tab position.
template <class X>
void tabOut(X data, int tab)
{
    for (; tab; tab--)
        for (int i = 0; i < TABWIDTH; i++)
            cout << ' ';
    cout << data << "\n";
}

int main()
{
    tabOut("This is a test", 0);
    tabOut(100, 1);
    tabOut('X', 2);
    tabOut(10 / 3, 3);
    return 0;
}
