#include <iostream>
#include <cstring>
using namespace std;

class String
{
    int size = 80;
    char *s;

public:
    String()
    {
        s = new char[size];
        s[0] = '\0';
    }
    String(char *str)
    {
        s = new char[size];
        strncpy(s, str, size - 1);
        s[size - 1] = '\0';
    }

    void display()
    {
        cout << s << endl;
    }

    String(const String &obj) // copy constructor
    {
        s = new char[size];
        strcpy(s, obj.s);
    }

    String &operator=(const String &obj) // copy assignment operator
    {
        if (this == &obj)
            return *this;
        delete[] s;
        s = new char[strlen(obj.s) + 1];
        strcpy(s, obj.s);
        return *this;
    }

    String operator+(const String &obj) // operator overloading
    {
        String temp = *this;
        strcpy(temp.s, this->s);
        strcat(temp.s, obj.s);
        return temp;
    }

    ~String()
    {
        cout << "Destructing...." << endl;
        delete[] s;
    }
};

int main()
{
    String s1 = "\nMerry Christmas!  "; // uses constructor 2
    String s2 = "Happy new year!";      // uses constructor 2
    String s3;                          // uses constructor 1
    s1.display();                       // display strings
    s2.display();
    s3.display();
    s3 = s1 + s2; // add s2 to s1,
    // assign to s3
    s3.display(); // display s3
    cout << endl;
    return 0;
}