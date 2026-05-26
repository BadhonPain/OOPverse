public class StaticDemo {
    // Static variable - shared across all instances
    private static int instanceCount = 0;
    private static final String COMPANY = "OOPverse Inc.";
    private static double taxRate;

    // Static block - runs once when class is loaded
    static {
        taxRate = 0.15;
        System.out.println("[Static Block] Class loaded. Tax rate initialized to " + taxRate);
    }

    // Another static block - they execute in order
    static {
        System.out.println("[Static Block 2] Company: " + COMPANY);
    }

    // Instance variables
    private String name;
    private double salary;
    private final int id;

    StaticDemo(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = ++instanceCount;
    }

    // Static method - can only access static members
    static int getInstanceCount() {
        return instanceCount;
    }

    static void setTaxRate(double rate) {
        if (rate >= 0 && rate <= 1.0) {
            taxRate = rate;
        }
    }

    static double getTaxRate() {
        return taxRate;
    }

    // Static utility method
    static double calculateTax(double amount) {
        return amount * taxRate;
    }

    // Instance method - can access both static and instance members
    double getNetSalary() {
        return salary - calculateTax(salary);
    }

    void displayInfo() {
        System.out.printf("Employee #%d: %s | Salary: $%.2f | Tax: $%.2f | Net: $%.2f%n",
                id, name, salary, calculateTax(salary), getNetSalary());
    }

    @Override
    public String toString() {
        return String.format("StaticDemo{id=%d, name='%s'}", id, name);
    }

    public static void main(String[] args) {
        System.out.println("\n=== Static Variables ===");
        System.out.println("Company: " + COMPANY);
        System.out.println("Instances before creation: " + StaticDemo.getInstanceCount());

        System.out.println("\n=== Creating Instances ===");
        StaticDemo e1 = new StaticDemo("Alice", 75000);
        StaticDemo e2 = new StaticDemo("Bob", 85000);
        StaticDemo e3 = new StaticDemo("Charlie", 65000);

        System.out.println("Instances after creation: " + StaticDemo.getInstanceCount());

        System.out.println("\n=== Employee Info (Tax Rate: " + getTaxRate() + ") ===");
        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();

        // Changing static variable affects all instances
        System.out.println("\n=== Changing Tax Rate to 0.25 ===");
        StaticDemo.setTaxRate(0.25);
        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();

        // Static method called without instance
        System.out.println("\n=== Static Utility ===");
        System.out.printf("Tax on $100,000: $%.2f%n", StaticDemo.calculateTax(100000));

        // Static vs instance access
        System.out.println("\n=== Access Patterns ===");
        System.out.println("Via class: StaticDemo.getInstanceCount() = " + StaticDemo.getInstanceCount());
        System.out.println("Via instance (works but discouraged): e1.getInstanceCount() = " + e1.getInstanceCount());
    }
}
