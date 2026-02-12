#include <iostream>
#include <string.h>
using namespace std;

class Father
{
protected:
    char *fptr;

public:
    Father(char *f)
    {
        fptr = new char[strlen(f) + 1];
        strcpy(fptr, f);
    }
    virtual void show()
    {
        cout << "Father: " << fptr << endl;
    }

    virtual ~Father()
    {
        cout << "Father destroyed" << endl;
        delete fptr;
    }
};

class Son : public Father
{
protected:
    char *fp;

public:
    Son(char *f1, char *f2) : Father(f2)
    {
        fp = new char[strlen(f1) + 1];
        strcpy(fp, f1);
    }

    virtual void show()
    {
        cout << "Son: " << fp << endl;
    }

    virtual ~Son()
    {
        cout << "Son destroyed" << endl;
        delete fp;
    }
};

int main()
{
    Father *fp = new Father("Rashid");
    fp->show();
    delete fp;
    fp = new Son("Robin", "Rashid");
    fp->show();
    delete fp;
    return 0;
}