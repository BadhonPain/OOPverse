// try-catch-finally with multiple catch blocks

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("===== Basic try-catch =====");
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        System.out.println("\n===== Multiple catch blocks =====");
        Object[] testData = {"hello", null, 42, new int[]{1, 2}};
        for (Object obj : testData) {
            try {
                System.out.print("Processing: " + obj + " -> ");
                String s = (String) obj;
                System.out.println("Length = " + s.length());
            } catch (ClassCastException e) {
                System.out.println("ClassCastException: not a String");
            } catch (NullPointerException e) {
                System.out.println("NullPointerException: object is null");
            }
        }

        System.out.println("\n===== Multi-catch (union) =====");
        try {
            int[] arr = {1, 2, 3};
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException | NegativeArraySizeException e) {
            System.out.println("Array error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        System.out.println("\n===== finally block =====");
        System.out.println("finally always executes:");
        for (int divisor : new int[]{2, 0}) {
            try {
                System.out.print("  10 / " + divisor + " = ");
                System.out.println(10 / divisor);
            } catch (ArithmeticException e) {
                System.out.println("ERROR (" + e.getMessage() + ")");
            } finally {
                System.out.println("  finally block executed for divisor=" + divisor);
            }
        }

        System.out.println("\n===== finally with return =====");
        System.out.println("getValue() returned: " + getValue());

        System.out.println("\n===== Nested try-catch =====");
        try {
            System.out.println("Outer try");
            try {
                int[] arr = new int[3];
                arr[10] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  Inner catch: " + e.getMessage());
                throw new RuntimeException("Wrapped exception", e);
            }
        } catch (RuntimeException e) {
            System.out.println("  Outer catch: " + e.getMessage());
            System.out.println("  Caused by: " + e.getCause().getClass().getSimpleName());
        }

        System.out.println("\n===== Exception hierarchy demo =====");
        try {
            throw new NumberFormatException("bad number");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught parent type: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }

        System.out.println("\n===== Stack trace info =====");
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Exception caught in main:");
            StackTraceElement[] trace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, trace.length); i++) {
                System.out.println("  at " + trace[i]);
            }
        }
    }

    static String getValue() {
        try {
            return "from try";
        } finally {
            System.out.println("  finally in getValue() runs before return");
        }
    }

    static void methodA() { methodB(); }
    static void methodB() { methodC(); }
    static void methodC() { throw new RuntimeException("Error in methodC"); }
}
