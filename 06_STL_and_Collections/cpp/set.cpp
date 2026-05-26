#include <iostream>
#include <set>
#include <string>
using namespace std;

int main()
{
    string names[] = {"Juanita", "Robert", "Mary", "Amanda", "Marie"};
    set<string, less<string>> nameSet(names, names + 5);
    set<string, less<string>>::iterator iter;

    nameSet.insert("Larry");  // Larry added
    nameSet.insert("Robert"); // no effect, already in set
    nameSet.erase("Mary");    // Mary deleted
    iter = nameSet.begin();
    while (iter != nameSet.end())
        cout << *iter++ << "  ";
    string sname;
    cout << "\nEnter a name : ";
    cin >> sname;
    iter = nameSet.find(sname);
    if (iter == nameSet.end())
        cout << "Not found";
    else
        cout << "Found !" << endl;

    return 0;
}
