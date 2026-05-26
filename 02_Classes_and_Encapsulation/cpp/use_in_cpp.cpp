#include <iostream>
#include <string>

class UserAccount {
private:
    // 1. Declaration: Telling the class "this variable exists"
    static int userCount; 
    std::string username;

public:
    UserAccount(std::string name) : username(name) {
        userCount++; // Modifying the shared variable
    }

    // 2. Static Member Function: Operates on class scope
    static int getTotalUsers() {
        return userCount;
    }
};

// 3. Definition: Actually allocating memory for the static variable.
// This must be done outside the class
int UserAccount::userCount = 0;

int main() {
    UserAccount u1("Alice");
    UserAccount u2("Bob");

    // Accessing static function using the Scope Resolution Operator (::)
    std::cout << "Total users: " << UserAccount::getTotalUsers() << std::endl;

    return 0;
}