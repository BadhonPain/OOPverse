#include <iostream>
#include <stdexcept>
#include <string>

class InsufficientFundsException : public std::exception {
private:
    std::string m_message;
    double m_amountRequested;
    double m_currentBalance;

public:
    InsufficientFundsException(double requested, double balance) 
        : m_amountRequested(requested), m_currentBalance(balance) {
        m_message = "Insufficient Funds! Requested: $" + std::to_string(m_amountRequested) 
                    + ", Balance: $" + std::to_string(m_currentBalance);
    }

    const char* what() const noexcept override {
        return m_message.c_str();
    }

    double getRequestedAmount() const noexcept { return m_amountRequested; }
    double getCurrentBalance() const noexcept { return m_currentBalance; }
};

class BankAccount {
private:
    std::string m_owner;
    double m_balance;

public:
    BankAccount(const std::string& owner, double initialBalance) 
        : m_owner(owner), m_balance(initialBalance) {
        if (initialBalance < 0) {
            throw std::invalid_argument("Initial balance cannot be negative!");
        }
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw std::invalid_argument("Deposit must be positive!");
        }
        m_balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw std::invalid_argument("Withdrawal must be positive!");
        }
        if (amount > m_balance) {
            throw InsufficientFundsException(amount, m_balance);
        }
        m_balance -= amount;
    }
};

int main() {
    try {
        BankAccount badAccount("Alice", -50.0);
    } 
    catch (const std::invalid_argument& e) {
        std::cout << "Caught expected error: " << e.what() << "\n";
    }

    try {
        BankAccount myAccount("Bob", 100.0);
        myAccount.withdraw(150.0);
    } 
    catch (const InsufficientFundsException& e) {
        std::cout << "Caught custom error: " << e.what() << "\n";
        std::cout << "  Requested: $" << e.getRequestedAmount() << "\n";
    }
    catch (const std::exception& e) {
        std::cout << "Caught error: " << e.what() << "\n";
    }

    return 0;
}
