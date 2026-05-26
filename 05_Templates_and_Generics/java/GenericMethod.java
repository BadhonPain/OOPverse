// Generic methods with bounded types
import java.util.Arrays;
import java.util.List;

public class GenericMethod {

    static <T> void printArray(T[] arr) {
        System.out.print("  [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    static <T> int countOccurrences(T[] arr, T target) {
        int count = 0;
        for (T item : arr) {
            if (item.equals(target)) count++;
        }
        return count;
    }

    static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Empty array");
        T max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }

    static <T extends Comparable<T>> T findMin(T[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Empty array");
        T min = arr[0];
        for (T item : arr) {
            if (item.compareTo(min) < 0) min = item;
        }
        return min;
    }

    static <T extends Number> double sum(T[] arr) {
        double total = 0;
        for (T item : arr) total += item.doubleValue();
        return total;
    }

    static <T extends Number & Comparable<T>> T clamp(T value, T min, T max) {
        if (value.compareTo(min) < 0) return min;
        if (value.compareTo(max) > 0) return max;
        return value;
    }

    static <T> boolean contains(T[] arr, T target) {
        for (T item : arr) {
            if (item.equals(target)) return true;
        }
        return false;
    }

    static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Generic Methods ===\n");

        // Unbounded generic method
        System.out.println("--- printArray<T> ---");
        Integer[] ints = {1, 2, 3, 4, 5};
        String[] words = {"alpha", "beta", "gamma"};
        Double[] doubles = {1.1, 2.2, 3.3};
        System.out.print("Integers: "); printArray(ints);
        System.out.print("Strings:  "); printArray(words);
        System.out.print("Doubles:  "); printArray(doubles);

        // Bounded: Comparable
        System.out.println("\n--- Bounded <T extends Comparable<T>> ---");
        System.out.println("Max of ints:   " + findMax(ints));
        System.out.println("Min of ints:   " + findMin(ints));
        System.out.println("Max of words:  " + findMax(words));
        System.out.println("isSorted ints: " + isSorted(ints));
        System.out.println("isSorted words:" + isSorted(words));

        // Bounded: Number
        System.out.println("\n--- Bounded <T extends Number> ---");
        System.out.println("Sum of ints:    " + sum(ints));
        System.out.println("Sum of doubles: " + sum(doubles));

        // Multiple bounds: Number & Comparable
        System.out.println("\n--- Multiple bounds <T extends Number & Comparable<T>> ---");
        System.out.println("clamp(15, 0, 10)  = " + clamp(15, 0, 10));
        System.out.println("clamp(5, 0, 10)   = " + clamp(5, 0, 10));
        System.out.println("clamp(-3, 0, 10)  = " + clamp(-3, 0, 10));
        System.out.println("clamp(3.7, 1.0, 3.5) = " + clamp(3.7, 1.0, 3.5));

        // Count and contains
        System.out.println("\n--- Utility generic methods ---");
        Integer[] data = {1, 3, 5, 3, 7, 3, 9};
        System.out.println("count(3 in data)   = " + countOccurrences(data, 3));
        System.out.println("contains(5, data)  = " + contains(data, 5));
        System.out.println("contains(42, data) = " + contains(data, 42));
    }
}
