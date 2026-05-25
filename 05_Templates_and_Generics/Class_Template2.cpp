#include <iostream>
using namespace std;
// TF: 17-18
template <class T>
class myCalculator
{
    T n1, n2;

public:
    myCalculator(T n1, T n2)
    {
        this->n1 = n1;
        this->n2 = n2;
    }

    void displayResult()
    {
        cout << "Numbers are: " << n1 << " and " << n2 << endl;
        cout << "Addition: " << n1 + n2 << endl;
        cout << "Subtraction: " << n1 - n2 << endl;
        cout << "Product: " << n1 * n2 << endl;
        cout << "Division: " << n1 / n2 << endl;
    }
};

int main()
{
    myCalculator<int> intCalc(7, 4);
    myCalculator<float> floatCalc(3.4, 6.2);

    cout << "Int results:" << endl;
    intCalc.displayResult();

    cout << endl
         << "Float results:" << endl;
    floatCalc.displayResult();

    return 0;
}