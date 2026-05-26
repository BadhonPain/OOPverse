// Collections utility algorithms: sort, shuffle, binarySearch, etc.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionAlgorithms {

    public static void main(String[] args) {
        System.out.println("=== Collection Algorithms ===\n");

        // Sorting
        System.out.println("--- Collections.sort ---");
        List<Integer> nums = new ArrayList<>(List.of(38, 27, 43, 3, 9, 82, 10));
        System.out.println("Original:    " + nums);
        Collections.sort(nums);
        System.out.println("Sorted:      " + nums);
        Collections.sort(nums, Comparator.reverseOrder());
        System.out.println("Reverse:     " + nums);

        // Binary search (list must be sorted)
        System.out.println("\n--- Collections.binarySearch ---");
        Collections.sort(nums);
        System.out.println("Sorted list: " + nums);
        int idx = Collections.binarySearch(nums, 27);
        System.out.println("binarySearch(27): index=" + idx);
        int notFound = Collections.binarySearch(nums, 50);
        System.out.println("binarySearch(50): " + notFound + " (negative = not found)");

        // Shuffle
        System.out.println("\n--- Collections.shuffle ---");
        List<String> cards = new ArrayList<>(List.of("A♠", "K♥", "Q♦", "J♣", "10♠", "9♥", "8♦"));
        System.out.println("Before: " + cards);
        Collections.shuffle(cards);
        System.out.println("After:  " + cards);

        // Min, Max
        System.out.println("\n--- Collections.min / max ---");
        System.out.println("List: " + nums);
        System.out.println("Min: " + Collections.min(nums));
        System.out.println("Max: " + Collections.max(nums));

        List<String> words = List.of("banana", "apple", "cherry", "date");
        System.out.println("Words: " + words);
        System.out.println("Min (lex): " + Collections.min(words));
        System.out.println("Max (lex): " + Collections.max(words));
        System.out.println("Longest:   " + Collections.max(words, Comparator.comparingInt(String::length)));

        // Frequency
        System.out.println("\n--- Collections.frequency ---");
        List<Integer> data = List.of(1, 3, 5, 3, 7, 3, 9, 1);
        System.out.println("Data: " + data);
        System.out.println("Frequency of 3: " + Collections.frequency(data, 3));
        System.out.println("Frequency of 1: " + Collections.frequency(data, 1));
        System.out.println("Frequency of 99: " + Collections.frequency(data, 99));

        // Reverse
        System.out.println("\n--- Collections.reverse ---");
        List<String> letters = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        System.out.println("Before: " + letters);
        Collections.reverse(letters);
        System.out.println("After:  " + letters);

        // Rotate
        System.out.println("\n--- Collections.rotate ---");
        List<Integer> rotatable = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println("Original:      " + rotatable);
        Collections.rotate(rotatable, 2);
        System.out.println("Rotate right 2:" + rotatable);
        Collections.rotate(rotatable, -1);
        System.out.println("Rotate left 1: " + rotatable);

        // Swap
        System.out.println("\n--- Collections.swap ---");
        List<String> swappable = new ArrayList<>(List.of("X", "Y", "Z"));
        System.out.println("Before: " + swappable);
        Collections.swap(swappable, 0, 2);
        System.out.println("After swap(0,2): " + swappable);

        // Fill and nCopies
        System.out.println("\n--- Collections.fill / nCopies ---");
        List<String> filled = new ArrayList<>(Collections.nCopies(5, "?"));
        System.out.println("nCopies(5, ?): " + filled);
        Collections.fill(filled, "X");
        System.out.println("fill(X):       " + filled);

        // Disjoint
        System.out.println("\n--- Collections.disjoint ---");
        List<Integer> listA = List.of(1, 2, 3);
        List<Integer> listB = List.of(4, 5, 6);
        List<Integer> listC = List.of(3, 4, 5);
        System.out.println("A=" + listA + " B=" + listB + " C=" + listC);
        System.out.println("disjoint(A, B): " + Collections.disjoint(listA, listB));
        System.out.println("disjoint(A, C): " + Collections.disjoint(listA, listC));

        // Unmodifiable
        System.out.println("\n--- Collections.unmodifiableList ---");
        List<String> immutable = Collections.unmodifiableList(letters);
        System.out.println("Unmodifiable: " + immutable);
        try {
            immutable.add("F");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify: " + e.getClass().getSimpleName());
        }
    }
}
