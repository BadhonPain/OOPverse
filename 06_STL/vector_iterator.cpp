#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<char> v(10);
    vector<char>::iterator p;
    int i;
    p = v.begin();
    i = 0;
    while (p != v.end())
    {
        *p = i + 'a';
        p++;
        i++;
    }

    for (auto p = v.begin(); p != v.end(); p++)
    {
        cout << *p << " ";
    }
    cout << endl;

    p = v.begin();
    v.insert(p + 2, 5, 'x'); // inserted 5 'x' starting from index 2; size got incremented by 5
    while (p != v.end())
    {
        *p = toupper(*p);
        p++;
    }

    for (auto p = v.begin(); p != v.end(); p++)
    {
        cout << *p << " ";
    }
    cout << endl;
}