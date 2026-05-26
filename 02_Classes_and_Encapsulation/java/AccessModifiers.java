public class AccessModifiers {
    public String publicField = "I'm accessible everywhere";
    private String privateField = "I'm only accessible inside this class";
    protected String protectedField = "I'm accessible in subclasses and same package";
    String defaultField = "I'm accessible within the same package (package-private)";

    public void publicMethod() {
        System.out.println("[public] " + publicField);
        System.out.println("[public] Can access private: " + privateField);
    }

    private void privateMethod() {
        System.out.println("[private] Secret internal logic");
    }

    protected void protectedMethod() {
        System.out.println("[protected] Available to subclasses and same package");
    }

    void defaultMethod() {
        System.out.println("[default] Available within same package only");
    }

    // Private method accessed indirectly through public API
    public void doWork() {
        System.out.println("doWork() delegates to private helper...");
        privateMethod();
    }

    // Inner class can access outer class's private members
    static class InnerHelper {
        void accessOuter(AccessModifiers outer) {
            System.out.println("\n=== Inner Class Access ===");
            System.out.println("public: " + outer.publicField);
            System.out.println("private: " + outer.privateField);
            System.out.println("protected: " + outer.protectedField);
            System.out.println("default: " + outer.defaultField);
            outer.privateMethod();
        }
    }

    // Subclass within same file
    static class Child extends AccessModifiers {
        void testAccess() {
            System.out.println("\n=== Child Class Access ===");
            System.out.println("public: " + publicField);
            // System.out.println(privateField); // COMPILE ERROR
            System.out.println("protected: " + protectedField);
            System.out.println("default: " + defaultField);

            publicMethod();
            // privateMethod(); // COMPILE ERROR
            protectedMethod();
            defaultMethod();
        }
    }

    // Encapsulation example: private field + public getter/setter
    static class BankAccount {
        private double balance;
        private final String accountId;

        BankAccount(String accountId, double initialBalance) {
            this.accountId = accountId;
            this.balance = Math.max(0, initialBalance);
        }

        public double getBalance() { return balance; }
        public String getAccountId() { return accountId; }

        public boolean deposit(double amount) {
            if (amount <= 0) return false;
            balance += amount;
            logTransaction("DEPOSIT", amount);
            return true;
        }

        public boolean withdraw(double amount) {
            if (amount <= 0 || amount > balance) return false;
            balance -= amount;
            logTransaction("WITHDRAW", amount);
            return true;
        }

        private void logTransaction(String type, double amount) {
            System.out.printf("  [LOG] %s: $%.2f | Balance: $%.2f%n", type, amount, balance);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Direct Access ===");
        AccessModifiers obj = new AccessModifiers();
        System.out.println("public: " + obj.publicField);
        // System.out.println(obj.privateField); // COMPILE ERROR
        System.out.println("protected: " + obj.protectedField);
        System.out.println("default: " + obj.defaultField);

        System.out.println("\n=== Method Access ===");
        obj.publicMethod();
        // obj.privateMethod(); // COMPILE ERROR
        obj.protectedMethod();
        obj.defaultMethod();

        // Private accessed through public API
        System.out.println("\n=== Private via Public API ===");
        obj.doWork();

        // Inner class access
        InnerHelper helper = new InnerHelper();
        helper.accessOuter(obj);

        // Subclass access
        Child child = new Child();
        child.testAccess();

        // Encapsulation in action
        System.out.println("\n=== Encapsulation: BankAccount ===");
        BankAccount account = new BankAccount("ACC-001", 1000);
        System.out.println("Account: " + account.getAccountId());
        System.out.println("Balance: $" + account.getBalance());
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(5000);
        System.out.println("Final balance: $" + account.getBalance());
    }
}
