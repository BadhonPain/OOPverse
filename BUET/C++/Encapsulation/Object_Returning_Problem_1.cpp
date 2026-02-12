#include <iostream>
#include <cstring>
using namespace std;

class Samp
{
    char *str;

public:
    Samp() { str = '\0'; }
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
    ob = input();
    ob.show();
    return 0;
}