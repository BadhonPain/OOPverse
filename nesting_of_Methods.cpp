#include <iostream>
#include <string>
using namespace std;

class Binary
{
private:
    string bin;

public:
    void readNum();
    void checkNum();
    void onesComplement();
    void display();
};

void Binary ::readNum()
{
    cout << "Enter a Binary Number : " << endl;
    cin >> bin;
    checkNum();
}
void Binary ::checkNum()
{
    for (int i = 0; i < bin.length(); i++)
    {
        if (bin.at(i) != '0' && bin.at(i) != '1')
        {
            cout << "Incorrect Binary Format !" << endl;
            exit(0);
        }
    }
}
void Binary ::onesComplement()
{
    for (int i = 0; i < bin.length(); i++)
    {
        if (bin.at(i) == '0')
        {
            bin.at(i) = '1';
        }
        else if (bin.at(i) == '1')
        {
            bin.at(i) = '0';
        }
    }
}
void Binary ::display()
{
    cout << bin << endl;
}

int main()
{
    Binary binNum;
    binNum.readNum();
    binNum.onesComplement();
    binNum.display();
}