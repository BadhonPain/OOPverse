#include <iostream>
#include <cstring>
using namespace std;

class Samp
{
    char *str;

public:
    Samp() { str = nullptr; }
    ~Samp()
    {
        cout << "Destructing..." << endl;
        delete str;
    }

    void show()
    {
        cout << str << endl;
    }

    void set(char *s)
    {
        str = new char[strlen(s) + 1];
        strcpy(str, s);
    }
};

Samp input()
{
    Samp s;
    s.set("It is Badhon Pain");
    return s;
}

int main()
{
    Samp ob;
    // ob = input(); -> run this, removing comment and see the problem
    ob.show();
    return 0;
}