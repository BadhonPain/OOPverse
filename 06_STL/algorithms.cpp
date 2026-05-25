#include <iostream>
#include <algorithm>
using namespace std;

// Predicate for find_if
bool isEven(int x)
{
    return x % 2 == 0;
}

// Function for transform
double in2cm(double in)
{
    return in * 2.54;
}

// Function for for_each
void print2cm(double in)
{
    cout << in * 2.54 << " ";
}

int main()
{
    int arr[] = {33, 22, 33, 44, 55, 44, 77, 33};
    int pattern[] = {33, 44, 55};
    int dest[11];

    int *ptr;

    // find
    ptr = find(arr, arr + 8, 33);
    cout << "First 33: " << *ptr << endl;

    // find_if
    ptr = find_if(arr, arr + 8, isEven);
    cout << "First even: " << *ptr << endl;

    // count
    int n = count(arr, arr + 8, 33);
    cout << "Count of 33: " << n << endl;

    // sort ascending
    sort(arr, arr + 8);

    // sort descending
    sort(arr, arr + 8, greater<int>());

    // search (needs sorted range typically)
    sort(arr, arr + 8);
    int *p2 = search(arr, arr + 8, pattern, pattern + 3);

    if (p2 == arr + 8)
        cout << "Pattern not found" << endl;
    else
        cout << "Pattern found at index: " << (p2 - arr) << endl;

    // merge (requires sorted arrays)
    sort(arr, arr + 8);
    sort(pattern, pattern + 3);
    merge(arr, arr + 8, pattern, pattern + 3, dest);

    cout << "Merged array: ";
    for (int i = 0; i < 11; i++)
        cout << dest[i] << " ";
    cout << endl;

    double inch[] = {3.6, 6.2, 1.0, 12.75, 4.33, 7.7, 3.3};
    double cm[7];

    // for_each
    cout << "Inch to cm (printed): ";
    for_each(inch, inch + 7, print2cm);
    cout << endl;

    // transform
    transform(inch, inch + 7, cm, in2cm);

    cout << "Stored in cm array: ";
    for (int i = 0; i < 7; i++)
        cout << cm[i] << " ";
    cout << endl;

    return 0;
}