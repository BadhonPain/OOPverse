public class ArrayDemo {
    public static void main(String[] args) {
        // Declare and initialize arrays
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("=== 1D Array Traversal ===");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // For-each loop traversal
        System.out.println("\n=== For-each traversal ===");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of elements: " + sum);

        // Multidimensional array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("\n=== 2D Array Traversal ===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
