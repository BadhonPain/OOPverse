// Stack design using OOP
#include <iostream>
using namespace std;

class Stack
{
protected:
    enum
    {
        MAX = 3
    };
    int st[MAX];
    int top;

public:
    Stack() : top(-1)
    {
    }
    void push(int val)
    {
        st[++top] = val;
    }

    int pop()
    {
        return st[top--];
    }
};

class Stack2 : public Stack
{
public:
    void push(int val)
    {
        if (top >= MAX - 1)
        {
            cout << "Error: Stack is FULL !" << endl;
            exit(1);
        }
        Stack ::push(val);
    }

    int pop()
    {
        if (top < 0)
        {
            cout << "Error: Stack is Empty !" << endl;
            exit(1);
        }
        return Stack::pop();
    }
};

int main()
{
    Stack2 s1;
    s1.push(11); // push some values onto stack
    s1.push(22);
    s1.push(33);
    cout << endl
         << s1.pop(); // pop some values from stack
    cout << endl
         << s1.pop();
    cout << endl
         << s1.pop();
    cout << endl
         << s1.pop(); // oops, popped one too many...
    cout << endl;
    return 0;
}
