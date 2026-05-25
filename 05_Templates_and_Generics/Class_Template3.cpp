#include <iostream>
using namespace std;

template <class T, int N = 0>
class Processor
{
    T x;

public:
    Processor(T d) : x(d) {}

    T getx() const
    {
        return x;
    }
};

template <class T, int N>
void execute(const Processor<T, N> &obj)
{
    if (N == 0)
    {
        cout << "Value was reset to 0" << endl;
        return;
    }
    cout << "Processed value: " << obj.getx() * 2 << endl;
}

int main()
{
    Processor<double, 2> p1(5.5);

    Processor<int, 0> p2(10);

    cout << "--- Execution 1 ---" << endl;
    execute(p1);

    cout << "\n--- Execution 2 ---" << endl;
    execute(p2);

    return 0;
}