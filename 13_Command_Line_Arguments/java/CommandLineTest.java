/**
 *  How to run:
 *  javac CommandLineTest.java
 *  java CommandLineTest Badhon 87 BUET
 *
 *   Output:
 *   3        ← args.length (number of arguments passed)
 *   Badhon
 *   87
 *   BUET
 * ─────────────────────────────────────────────────────────────────────────────
 **/
public class CommandLineTest {
 
    public static void main(String[] args) {
 
        // Print total number of arguments passed
        System.out.println(args.length);
 
        // Print each argument one by one
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}