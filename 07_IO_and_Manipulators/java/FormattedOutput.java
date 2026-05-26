// printf, String.format, and DecimalFormat usage

import java.text.DecimalFormat;
import java.util.Locale;

public class FormattedOutput {
    public static void main(String[] args) {
        System.out.println("===== printf Format Specifiers =====");
        System.out.printf("Integer:     %d%n", 42);
        System.out.printf("Octal:       %o%n", 42);
        System.out.printf("Hex:         %x  (uppercase: %X)%n", 255, 255);
        System.out.printf("Float:       %f%n", 3.14159);
        System.out.printf("Scientific:  %e%n", 123456.789);
        System.out.printf("Shorter:     %g%n", 123456.789);
        System.out.printf("Character:   %c%n", 'A');
        System.out.printf("String:      %s%n", "OOPverse");
        System.out.printf("Boolean:     %b%n", true);

        System.out.println("\n===== Width and Precision =====");
        System.out.printf("|%10d|%n", 42);
        System.out.printf("|%-10d|%n", 42);
        System.out.printf("|%010d|%n", 42);
        System.out.printf("|%+d|  |%+d|%n", 42, -42);
        System.out.printf("|%10.3f|%n", 3.14159);
        System.out.printf("|%-10.3f|%n", 3.14159);
        System.out.printf("|%.5s|%n", "Hello, World!");

        System.out.println("\n===== Table with printf =====");
        String[][] students = {
            {"Alice", "95", "3.90"},
            {"Bob", "87", "3.45"},
            {"Charlie", "92", "3.78"},
            {"Diana", "100", "4.00"}
        };
        System.out.printf("%-10s %6s %6s%n", "Name", "Score", "GPA");
        System.out.printf("%-10s %6s %6s%n", "----", "-----", "---");
        for (String[] s : students) {
            System.out.printf("%-10s %6d %6.2f%n", s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2]));
        }

        System.out.println("\n===== String.format =====");
        String msg = String.format("Coordinates: (%.2f, %.2f)", 12.3456, 78.9012);
        System.out.println(msg);

        String padded = String.format("[%-20s]", "left-aligned");
        System.out.println(padded);

        String hex = String.format("Color: #%02X%02X%02X", 255, 128, 0);
        System.out.println(hex);

        System.out.println("\n===== Argument Index =====");
        System.out.printf("%1$s has %2$d apples and %2$d oranges.%n", "Alice", 5);
        System.out.printf("%1$tB %1$td, %1$tY%n", java.util.Calendar.getInstance());

        System.out.println("\n===== DecimalFormat =====");
        double value = 12345.6789;

        DecimalFormat df1 = new DecimalFormat("#,###.##");
        System.out.println("Grouped with decimals: " + df1.format(value));

        DecimalFormat df2 = new DecimalFormat("000000.000");
        System.out.println("Zero-padded:           " + df2.format(value));

        DecimalFormat df3 = new DecimalFormat("$#,###.00");
        System.out.println("Currency style:        " + df3.format(value));

        DecimalFormat df4 = new DecimalFormat("#.##%");
        System.out.println("Percentage:            " + df4.format(0.8567));

        DecimalFormat df5 = new DecimalFormat("0.###E0");
        System.out.println("Scientific:            " + df5.format(value));

        System.out.println("\n===== Locale-Aware Formatting =====");
        double amount = 1234567.89;
        System.out.printf(Locale.US, "US:      %,.2f%n", amount);
        System.out.printf(Locale.GERMANY, "Germany: %,.2f%n", amount);
        System.out.printf(Locale.FRANCE, "France:  %,.2f%n", amount);

        System.out.println("\n===== Padding Utility =====");
        String[] labels = {"Name", "Age", "Score", "Grade"};
        String[] values = {"Bob", "21", "93.5", "A"};
        for (int i = 0; i < labels.length; i++) {
            System.out.printf("%-8s : %s%n", labels[i], values[i]);
        }
    }
}
