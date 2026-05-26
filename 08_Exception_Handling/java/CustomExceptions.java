// Custom exception classes, throws, and throw

public class CustomExceptions {

    static class InsufficientFundsException extends Exception {
        private final double deficit;

        InsufficientFundsException(double deficit) {
            super(String.format("Insufficient funds: need $%.2f more", deficit));
            this.deficit = deficit;
        }

        double getDeficit() { return deficit; }
    }

    static class InvalidAgeException extends IllegalArgumentException {
        InvalidAgeException(int age) {
            super("Invalid age: " + age + " (must be 0-150)");
        }
    }

    static class AccountLockedException extends RuntimeException {
        AccountLockedException(String accountId) {
            super("Account " + accountId + " is locked");
        }
    }

    static class BankAccount {
        private final String id;
        private double balance;
        private boolean locked;

        BankAccount(String id, double balance) {
            this.id = id;
            this.balance = balance;
            this.locked = false;
        }

        void deposit(double amount) throws IllegalArgumentException {
            if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
            if (locked) throw new AccountLockedException(id);
            balance += amount;
            System.out.printf("  Deposited $%.2f -> Balance: $%.2f%n", amount, balance);
        }

        void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
            if (locked) throw new AccountLockedException(id);
            if (amount > balance) throw new InsufficientFundsException(amount - balance);
            balance -= amount;
            System.out.printf("  Withdrew $%.2f -> Balance: $%.2f%n", amount, balance);
        }

        void lock() { locked = true; }
        double getBalance() { return balance; }
        String getId() { return id; }
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) throw new InvalidAgeException(age);
        System.out.println("  Age " + age + " is valid");
    }

    static void transfer(BankAccount from, BankAccount to, double amount)
            throws InsufficientFundsException {
        System.out.printf("Transferring $%.2f from %s to %s%n", amount, from.getId(), to.getId());
        from.withdraw(amount);
        to.deposit(amount);
        System.out.println("  Transfer complete!");
    }

    public static void main(String[] args) {
        System.out.println("===== Custom Checked Exception =====");
        BankAccount acc = new BankAccount("ACC-001", 100.0);
        try {
            acc.withdraw(50);
            acc.withdraw(75);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.printf("Deficit: $%.2f%n", e.getDeficit());
        }

        System.out.println("\n===== Custom Unchecked Exception =====");
        int[] testAges = {25, -5, 200};
        for (int age : testAges) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("  Caught: " + e.getMessage());
            }
        }

        System.out.println("\n===== RuntimeException (no catch required) =====");
        BankAccount locked = new BankAccount("ACC-002", 500.0);
        locked.lock();
        try {
            locked.deposit(100);
        } catch (AccountLockedException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("\n===== Exception propagation with throws =====");
        BankAccount alice = new BankAccount("ALICE", 200.0);
        BankAccount bob = new BankAccount("BOB", 50.0);
        try {
            transfer(alice, bob, 100);
            transfer(bob, alice, 300);
        } catch (InsufficientFundsException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        System.out.println("\n===== Exception chaining =====");
        try {
            try {
                acc.withdraw(1000);
            } catch (InsufficientFundsException e) {
                throw new RuntimeException("Transaction failed", e);
            }
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause().getMessage());
        }

        System.out.printf("%nFinal balances: Alice=$%.2f, Bob=$%.2f%n",
                alice.getBalance(), bob.getBalance());
    }
}
