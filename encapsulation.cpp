// Encapsulation is nothing new, it's simply define and use a class
//  it is basically used to hide sensitive data and controlled access -> simply we have to use private class
#include <iostream>
using namespace std;
class bankAccount
{
private:
    double balance;
    double password;

public:
    string username;
    double accNumber;
};

int main()
{
    bankAccount acc1;
    acc1.accNumber = 123;
    acc1.username = "badhon pain";
    cout << acc1.username << endl;
    cout << acc1.accNumber << endl; // but we can't see the sensitive duo directly
}
