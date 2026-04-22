#include <iostream>
#include <list>
#include <algorithm>
using namespace std;
// TF: 23-24
int square(int x)
{
    return x * x;
}

int main()
{
    list<int> ll = {20, 16, 12, 8, 4, 3, 6, 9, 12, 15};

    int twelveCount = count(ll.begin(), ll.end(), 12);
    cout << "12 appeared: " << twelveCount << " times" << endl;

    int evenCount = count_if(ll.begin(), ll.end(), [](int x)
                             { return x % 2 == 0; });
    cout << "Total Even numbers: " << evenCount << endl;

    list<int> ll2;
    for (auto it : ll)
    {
        if (it != 12)
            ll2.push_back(it);
    }
    cout << "List without 12: ";
    for (auto it : ll2)
    {
        cout << it << " ";
    }
    cout << endl;

    reverse(ll.begin(), ll.end());

    cout << "After reversing(Original List): ";
    for (auto it : ll)
    {
        cout << it << " ";
    }
    cout << endl;

    list<int> ll3(ll.size());
    transform(ll.begin(), ll.end(), ll3.begin(), square);
    cout << "Sqaure of Original List: ";
    for (auto it : ll3)
    {
        cout << it << " ";
    }
    cout << endl;
}