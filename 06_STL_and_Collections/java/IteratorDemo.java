// Iterator pattern, enhanced for loop, and stream API basics
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IteratorDemo {

    public static void main(String[] args) {
        System.out.println("=== Iterator Demo ===\n");

        List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "Diana", "Eve"));

        // Classic iterator
        System.out.println("--- Classic Iterator ---");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Enhanced for loop
        System.out.println("\n--- Enhanced For Loop ---");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // forEach with lambda
        System.out.println("\n--- forEach Lambda ---");
        names.forEach(n -> System.out.print(n.toLowerCase() + " "));
        System.out.println();

        // Safe removal during iteration
        System.out.println("\n--- Safe Removal with Iterator ---");
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Before: " + nums);
        Iterator<Integer> numIt = nums.iterator();
        while (numIt.hasNext()) {
            if (numIt.next() % 3 == 0) numIt.remove();
        }
        System.out.println("After removing multiples of 3: " + nums);

        // ListIterator: bidirectional
        System.out.println("\n--- ListIterator (bidirectional) ---");
        ListIterator<String> listIt = names.listIterator();
        System.out.print("Forward:  ");
        while (listIt.hasNext()) {
            System.out.print("[" + listIt.nextIndex() + "]=" + listIt.next() + " ");
        }
        System.out.println();
        System.out.print("Backward: ");
        while (listIt.hasPrevious()) {
            System.out.print("[" + listIt.previousIndex() + "]=" + listIt.previous() + " ");
        }
        System.out.println();

        // ListIterator modification
        System.out.println("\n--- ListIterator Modification ---");
        ListIterator<String> modIt = names.listIterator();
        while (modIt.hasNext()) {
            String s = modIt.next();
            if (s.length() <= 3) modIt.set(s.toUpperCase());
        }
        System.out.println("Short names uppercased: " + names);

        // Stream API basics
        System.out.println("\n--- Stream API Basics ---");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // filter + collect
        List<Integer> evens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Evens: " + evens);

        // map + collect
        List<String> squared = numbers.stream()
            .map(n -> n + "²=" + (n * n))
            .collect(Collectors.toList());
        System.out.println("Squares: " + squared);

        // reduce
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // chained operations
        double avgOfEvens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);
        System.out.println("Avg of evens: " + avgOfEvens);

        // count, min, max
        long count = numbers.stream().filter(n -> n > 5).count();
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("Count > 5: " + count + ", Max: " + max);

        // Stream with strings
        System.out.println("\n--- Stream: String Processing ---");
        List<String> allNames = List.of("Alice", "Bob", "Charlie", "Ana", "Brian", "Amy");

        List<String> aNames = allNames.stream()
            .filter(n -> n.startsWith("A"))
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Names starting with A: " + aNames);

        Map<Integer, List<String>> byLength = allNames.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + byLength);

        String joined = allNames.stream().collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);

        // IntStream
        System.out.println("\n--- IntStream ---");
        int rangeSum = IntStream.rangeClosed(1, 100).sum();
        System.out.println("Sum 1-100: " + rangeSum);

        int[] fibLike = IntStream.iterate(1, n -> n * 2).limit(10).toArray();
        System.out.print("Powers of 2: ");
        for (int f : fibLike) System.out.print(f + " ");
        System.out.println();
    }
}
