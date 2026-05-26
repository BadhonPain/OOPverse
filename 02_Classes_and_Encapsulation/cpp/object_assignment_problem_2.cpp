#include <iostream>
#include <cstring>
using namespace std;

class Badhon
{
    int length;
    char *name;

public:
    Badhon(char *s)
    {
        cout << "Constructing...." << endl;
        length = strlen(s);
        name = new char[length];
        strcpy(name, s);
    }

    char *getName()
    {
        return name;
    }

    ~Badhon()
    {
        cout << "Destructing..." << endl;
        delete[] name;
    }
};

int main()
{
    Badhon b("badhon"), c("pain");

    cout << "b: " << b.getName() << endl;
    cout << "c: " << c.getName() << endl;

    b = c;

    cout << "b: " << b.getName() << endl;
    cout << "c: " << c.getName() << endl;
}