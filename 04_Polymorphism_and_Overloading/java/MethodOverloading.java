public class MethodOverloading {
    // Add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Concatenate two strings
    public String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        MethodOverloading demo = new MethodOverloading();

        System.out.println("Adding two ints: " + demo.add(5, 10));
        System.out.println("Adding three ints: " + demo.add(5, 10, 15));
        System.out.println("Adding two doubles: " + demo.add(5.5, 10.5));
        System.out.println("Adding two strings: " + demo.add("Hello, ", "World!"));
    }
}
