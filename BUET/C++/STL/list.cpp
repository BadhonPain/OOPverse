#include <iostream>
#include <list>
using namespace std;

int main() {
    list<int> iList;
    int arr[] = {40, 30, 20, 10};

    for (int j = 0; j < 4; ++j)
        iList.push_back(arr[j]);

    for (auto it : iList) {
        cout << it << " ";
    }
    cout << endl;

    iList.push_back(40);
    iList.push_front(30);

    cout << iList.front() << endl;

    iList.pop_front();
    iList.pop_back();
    iList.pop_back();

    iList.reverse();

    cout << "List 1 reversed: ";
    for (auto it : iList) {
        cout << it << " ";
    }
    cout << endl;

    cout << "Traversing List 1 backward with Iterator: ";

    list<int>::reverse_iterator p;
    p = iList.rbegin();
    while (p != iList.rend())
    {
        cout<<*p<<" ";
        ++p;
    }
    
    cout << endl;

    list<int> iList2 = {1, 2, 3, 4, 5};

    iList.sort();
    iList2.sort();
    iList.merge(iList2);

    cout << "List 1 and List 2 merged: ";
    for (auto p = iList.begin(); p != iList.end(); ++p) {
        cout << *p << " ";
    }
    cout << endl;

    list<int> iList3 = {5, 2, 3, 3, 5};


    iList3.sort();
    iList3.unique();

    cout << "Unique items in List 3: ";
    for (auto it : iList3) {
        cout << it << " ";
    }
    cout << endl;

    return 0;
}