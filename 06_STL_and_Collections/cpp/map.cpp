#include <iostream>
#include <map>
using namespace std;

int main()
{
    map<char, int> m;

    for (int i = 0; i < 10; ++i)
        m.insert(pair<char, int>('A' + i, i));

    char ch;

    cout << "Enter key :";
    cin >> ch;
    map<char, int>::iterator p;

    p = m.find(ch);
    if (p != m.end())
        cout << p->second;
    else
        cout << "key is not in map\n";

    return 0;
}