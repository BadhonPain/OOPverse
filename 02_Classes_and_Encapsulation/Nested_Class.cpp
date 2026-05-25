#include <iostream>
using namespace std;

class Outer
{
    int a;

public:
    Outer(int a) : a(a) {}
    void show()
    {
        cout << "From Outer: " << a << endl;
    }

    void innerShow(int x)
    {
        Inner inner(x);
        inner.show();
    }

    // void innerShow(const Inner &in)-> Error : Outer has no access of private info's of Inner
    // {
    //     cout<<in.b<<endl;
    // }

    class Inner
    {
        int b;

    public:
        Inner(int b) : b(b) {}
        void show()
        {
            cout << "From Inner: " << b << endl;
        }

        void outerShow(const Outer &obj)
        {
            cout << "From Inner's Outer Show: " << obj.a << endl;
        }
    };

    class Inner2
    {
    public:
        void showName(string name)
        {
            cout << "Name is: " << name << endl;
        }
    };
};

int main()
{
    Outer outer(10);
    outer.show();
    outer.innerShow(20);
    Outer::Inner inner(30);
    inner.show();
    inner.outerShow(outer);
    Outer::Inner2 in2;
    in2.showName("Badhon");
}