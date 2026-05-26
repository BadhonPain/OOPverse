public class MethodDemo {
    // Static method
    public static int add(int a, int b) {
        return a + b;
    }

    // Instance method
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Java always passes arguments by value (copies the reference for objects)
    public static void modifyValues(int x, int[] arr) {
        x = 99;         // Primitive copy is modified locally
        arr[0] = 99;    // Reference copy points to same array, so change persists
    }

    public static void main(String[] args) {
        int sum = add(5, 7);
        System.out.println("Sum from static method: " + sum);

        MethodDemo demo = new MethodDemo();
        demo.greet("Alice");

        int a = 10;
        int[] numbers = {1, 2, 3};
        System.out.println("\nBefore modifyValues: a = " + a + ", numbers[0] = " + numbers[0]);
        modifyValues(a, numbers);
        System.out.println("After modifyValues:  a = " + a + ", numbers[0] = " + numbers[0]);
    }
}
