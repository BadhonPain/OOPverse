#include <iostream>
using namespace std;

class Counter
{
protected:
    int count;

public:
    Counter() : count(0)
    {
    }
    Counter(int val) : count(val)
    {
    }
    int get_count()
    {
        return count;
    }

    Counter operator++()
    {
        return Counter(++count);
    }
};

class CountDn : public Counter
{
public:
    Counter operator--()
    {
        return Counter(--count);
    }
};

int main()
{
    CountDn c1;                        // c1 of class CountDn
    cout << "\nc1=" << c1.get_count(); // display c1
    ++c1;
    ++c1;
    ++c1;
    cout << "\nc1=" << c1.get_count(); // display it--c1; --c1;                           //decrement c1, twice
    --c1;
    --c1;                              // increment c1, 3 times
    cout << "\nc1=" << c1.get_count(); // display it
    cout << endl;
    return 0;
}