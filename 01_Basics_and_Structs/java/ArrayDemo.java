public class ArrayDemo {
    public static void main(String[] args) {
        // Declare and initialize arrays
        int[] numbers = { 10, 20, 30, 40, 50 };

        System.out.println("1D Array Traversal: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("");

        // For-each loop traversal
        System.out.println("\nFor-each traversal: ");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of elements: " + sum);

    }
}
