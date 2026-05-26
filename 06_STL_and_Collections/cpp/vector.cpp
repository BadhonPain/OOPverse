#include <iostream>
#include <vector>
using namespace std;

int main()
{
    double arr[] = {3.6, 6.2, 1.0, 12.75, 4.33, 7.7, 3.3};
    vector<double> v1(arr, arr + 7);
    vector<double> v2;

    for (auto it = v1.begin(); it != v1.end(); ++it)
    {
        cout << *it << " "; // traversing v1 through iterator
    }
    cout << endl;
    v2.push_back(2.2); // append 2.2
    cout << v2.back() << endl;
    v2.pop_back();             // remove 2.2 from end
    cout << v2.back() << endl; // garbage value

    v1[0] = 20.5;              // replacing first element of v1
    v2.push_back(1);
    v2.push_back(3);

    v1.swap(v2); // swapping v1 and v2
    for (auto it : v2)
    {
        cout << it << " ";
    }
    cout << endl;

    for (auto it : v1)
    {
        cout << it << " ";
    }

    cout << endl;

    v2.insert(v2.begin() + 3, 4.2); // inserting 4.2 at the 3rd position(index 3) of v2 and size increased by 1
    v2.erase(v2.begin() + 1);       // remove the element at 1st position(index 1) and size decremented by 1

    for (auto it : v2)
    {
        cout << it << " ";
    }
    cout << endl;

    cout << "v1 is empty: " << v1.empty() << endl; // 0-> false, 1 -> true
    cout << "size of v2: " << v2.size() << endl;  
    cout<<"capacity of v1: "<<v1.capacity()<<endl;
}