#include <iostream>
#include <deque>
using namespace std;

int main()
{
    deque<int> deq;

    deq.push_back(30);
    deq.push_front(20);
    deq[1] = 33;

    for (int j = 0; j < deq.size(); ++j)
        cout << deq[j] << " ";

    return 0;
}
