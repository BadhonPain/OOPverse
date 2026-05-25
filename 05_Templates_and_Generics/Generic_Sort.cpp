#include <iostream>
using namespace std;

template <class X>
void bubbleSort(X *arr, int n)
{
    for (int i = 1; i < n; i++)
    {
        for (int j = n - 1; j >= i; j--)
        {
            if (arr[j - 1] > arr[j])
            {
                X temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

int main()
{
    int iarray[7] = {7, 5, 4, 3, 9, 8, 6};
    double darray[5] = {4.3, 2.5, -0.9, 100.2, 3.0};
    int i;
    cout << "Here is unsorted integer array: ";
    for (i = 0; i < 7; i++)
        cout << iarray[i] << ' ';
    cout << endl;
    cout << "Here is unsorted double array: ";
    for (i = 0; i < 5; i++)
        cout << darray[i] << ' ';
    cout << endl;
    bubbleSort(iarray, 7);
    bubbleSort(darray, 5);
    cout << "Here is sorted integer array: ";
    for (i = 0; i < 7; i++)
        cout << iarray[i] << ' ';
    cout << endl;
    cout << "Here is sorted double array: ";
    for (i = 0; i < 5; i++)
        cout << darray[i] << ' ';
    cout << endl;
    return 0;
}
