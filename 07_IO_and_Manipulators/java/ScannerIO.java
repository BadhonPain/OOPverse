// Scanner for console input and System.out formatting

import java.util.Scanner;

public class ScannerIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.println("\n===== Profile Summary =====");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.printf("GPA  : %.2f%n", gpa);
        System.out.println("City : " + city);

        System.out.println("\n--- System.out methods ---");
        System.out.print("print: no newline. ");
        System.out.println("println: with newline.");
        System.out.printf("printf: formatted int=%d, float=%.3f, string=%s%n", 42, 3.14159, "hello");

        System.out.println("\n--- Parsing multiple values from one line ---");
        System.out.print("Enter three integers separated by spaces: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        System.out.printf("Sum of %d + %d + %d = %d%n", x, y, z, x + y + z);
        scanner.nextLine();

        System.out.println("\n--- Reading until sentinel ---");
        System.out.println("Enter words (type 'quit' to stop):");
        StringBuilder words = new StringBuilder();
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.equalsIgnoreCase("quit")) break;
            words.append(word).append(" ");
        }
        System.out.println("You entered: " + words.toString().trim());

        System.out.println("\n--- Checking input type ---");
        System.out.print("Enter something (int, double, or text): ");
        scanner.nextLine();
        String input = scanner.nextLine();
        try {
            int val = Integer.parseInt(input);
            System.out.println("Parsed as int: " + val);
        } catch (NumberFormatException e1) {
            try {
                double val = Double.parseDouble(input);
                System.out.println("Parsed as double: " + val);
            } catch (NumberFormatException e2) {
                System.out.println("It's a string: " + input);
            }
        }

        scanner.close();
        System.out.println("\nScanner closed. Done!");
    }
}
