import java.util.Scanner;

public class BasicIO {
    public static void main(String[] args) {
        // Variables and primitive data types
        int age = 20;
        double salary = 50000.50;
        char grade = 'A';
        boolean isStudent = true;

        System.out.println("=== Basic variables ===");
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Is Student: " + isStudent);

        // Type casting: Widening (implicit) and Narrowing (explicit)
        int intVal = 100;
        double doubleVal = intVal; // implicit widening
        System.out.println("\nImplicit cast (int to double): " + doubleVal);

        double pi = 3.14159;
        int roughPi = (int) pi; // explicit narrowing
        System.out.println("Explicit cast (double to int): " + roughPi);

        // Basic input using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your name: ");
        if (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            System.out.println("Hello, " + name + "!");
        }
        scanner.close();
    }
}
