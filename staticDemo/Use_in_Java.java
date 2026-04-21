package staticDemo;
class Employee {
    // STATIC MEMBER VARIABLE: The "Shared Counter"
    // This exists in the class memory, not in the object memory.
    private static int nextId = 1000; 

    // INSTANCE MEMBER VARIABLE: Unique to each Employee
    private int employeeId; 
    private String name;

    public Employee(String name) {
        this.name = name;
        // Every time a new Employee is created, we use the shared 
        // counter and then increment it.
        this.employeeId = nextId++;
    }

    public void display() {
        System.out.println("Employee: " + name + " | ID: " + employeeId);
    }
}
public class Use_in_Java {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice");
        Employee e2 = new Employee("Bob");
        Employee e3 = new Employee("Charlie");

        e1.display(); // ID: 1000
        e2.display(); // ID: 1001
        e3.display(); // ID: 1002
    }
    
}
