#include <iostream>
using namespace std;

class Payment
{
    int amount;

public:
    virtual void pay(int amount)
    {
        cout << amount << " is paid by Someone!" << endl;
    }

    virtual ~Payment()
    {
        cout << "Payment Destructing..." << endl;
    }
};

class CreditCard : public Payment
{
public:
    void pay(int amount)
    {
        cout << amount << " is paid by CreditCard!" << endl;
    }

    ~CreditCard()
    {
        cout << "CreditCard Destructing..." << endl;
    }
};

class Bkash : public Payment
{
public:
    void pay(int amount)
    {
        cout << amount << " is paid by Bkash" << endl;
    }

    ~Bkash()
    {
        cout << "Bkash Destructing..." << endl;
    }
};

int
main()
{
    Payment *p;

    p = new CreditCard();
    p->pay(500);

    delete p;

    p = new Bkash();
    p->pay(500);

    delete p;
}