#include <iostream>
using namespace std;
// TF: 22-23
template <class T, int N = 1>
class myclass
{
    T x;

public:
    myclass(T d) : x(d) {}

    T getx()
    {
        return x * N;
    }
};

template <int N>
class myclass<int, N>
{
    int x;

public:
    myclass(int num) : x(num) {}

    int getx()
    {
        if (N == 1)
            return x * x;

        return x * N;
    }
};

int
main()
{
    myclass<double> d1(1.1);
    myclass<double, 2> d2(1.1);
    myclass<double, 3> d3(1.1);

    cout << d1.getx() << " "
         << d2.getx() << " "
         << d3.getx() << "\n";

    myclass<int, 4> i1(5);
    myclass<int> i2(5);

    cout << i1.getx() << " "
         << i2.getx();

    return 0;
}