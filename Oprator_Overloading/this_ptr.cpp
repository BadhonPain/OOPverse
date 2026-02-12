// The member functions of every object have access to a sort of magic pointer named 'this',
// which points to the object itself.

#include <iostream>
using namespace std;

class where
{
private:
    char charray[10]; // occupies 10 bytes
public:
    void reveal()
    {
        cout << "\nMy object's address is: " << this;
    }
};

int main()
{
    where w1, w2, w3; // make three objects
    w1.reveal();      // see where they are
    w2.reveal();
    w3.reveal();
    cout << endl;
    return 0;
}
