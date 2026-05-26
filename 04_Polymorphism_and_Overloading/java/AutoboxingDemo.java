// Autoboxing & Auto-unboxing: Automatic conversion between primitives & wrapper objects

import java.util.ArrayList;
import java.util.List;

public class AutoboxingDemo {

    public static void main(String[] args) {
        System.out.println("=== Autoboxing & Auto-unboxing Demo ===\n");

        // --- 1. Basic Autoboxing ---
        System.out.println("--- 1. Autoboxing (primitive → wrapper) ---");
        Integer wrappedInt = 42; // autoboxing: int → Integer
        Double wrappedDouble = 3.14; // autoboxing: double → Double
        Boolean wrappedBool = true; // autoboxing: boolean → Boolean
        Long wrappedLong = 100L; // autoboxing: long → Long
        
        System.out.println("  int 42 → Integer: " + wrappedInt);
        System.out.println("  double 3.14 → Double: " + wrappedDouble);
        System.out.println("  boolean true → Boolean: " + wrappedBool);
        System.out.println("  long 100L → Long: " + wrappedLong);
        System.out.println();

        // --- 2. Basic Auto-unboxing ---
        System.out.println("--- 2. Auto-unboxing (wrapper → primitive) ---");
        int unwrappedInt = wrappedInt; // auto-unboxing: Integer → int
        double unwrappedDouble = wrappedDouble; // auto-unboxing: Double → double
        boolean unwrappedBool = wrappedBool; // auto-unboxing: Boolean → boolean
        long unwrappedLong = wrappedLong; // auto-unboxing: Long → long
        
        System.out.println("  Integer → int: " + unwrappedInt);
        System.out.println("  Double → double: " + unwrappedDouble);
        System.out.println("  Boolean → boolean: " + unwrappedBool);
        System.out.println("  Long → long: " + unwrappedLong);
        System.out.println();

        // --- 3. Arithmetic with Autoboxed Values ---
        System.out.println("--- 3. Arithmetic (auto-unboxing in expressions) ---");
        Integer a = 50;
        Integer b = 25;
        int sum = a + b; // both auto-unboxed for arithmetic
        int product = a * b;
        System.out.println("  Integer 50 + Integer 25 = " + sum);
        System.out.println("  Integer 50 * Integer 25 = " + product);
        System.out.println();

        // --- 4. Collections with Autoboxing ---
        System.out.println("--- 4. Collections (autoboxing) ---");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10); // autoboxing: 10 → Integer
        numbers.add(20); // autoboxing: 20 → Integer
        numbers.add(30); // autoboxing: 30 → Integer
        System.out.println("  List<Integer>: " + numbers);
        System.out.println();

        // --- 5. Accessing from Collections with Auto-unboxing ---
        System.out.println("--- 5. Accessing from Collections (auto-unboxing) ---");
        for (Integer num : numbers) {
            int primitive = num; // auto-unboxing: Integer → int
            System.out.println("  Unboxed: " + primitive + " (type: int)");
        }
        System.out.println();

        // --- 6. Comparison Operations ---
        System.out.println("--- 6. Comparison (auto-unboxing) ---");
        Integer x = 100;
        Integer y = 100;
        if (x == y) {
            System.out.println("  x == y: true (comparing reference in this case, cached)");
        }
        if (x.equals(y)) {
            System.out.println("  x.equals(y): true (comparing value)");
        }
        System.out.println();

        // --- 7. Wrapper Methods (explicit unboxing) ---
        System.out.println("--- 7. Wrapper Methods (explicit unboxing) ---");
        Integer num = 42;
        System.out.println("  Integer.intValue(): " + num.intValue());
        System.out.println("  Double.doubleValue(): " + wrappedDouble.doubleValue());
        System.out.println();

        System.out.println("Autoboxing & Unboxing - transparent wrapper conversion completed!");
    }
}
