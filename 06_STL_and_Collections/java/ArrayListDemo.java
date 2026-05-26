// ArrayList operations and iteration
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        System.out.println("=== ArrayList Demo ===\n");

        // Creation and basic operations
        System.out.println("--- Basic Operations ---");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        System.out.println("List: " + fruits);
        System.out.println("Size: " + fruits.size());

        // Access
        System.out.println("\n--- Access ---");
        System.out.println("get(0):    " + fruits.get(0));
        System.out.println("get(2):    " + fruits.get(2));
        System.out.println("indexOf:   " + fruits.indexOf("Cherry"));
        System.out.println("contains:  " + fruits.contains("Banana"));

        // Modification
        System.out.println("\n--- Modification ---");
        fruits.set(1, "Blueberry");
        System.out.println("After set(1, Blueberry): " + fruits);
        fruits.add(2, "Coconut");
        System.out.println("After add(2, Coconut):   " + fruits);
        fruits.remove("Date");
        System.out.println("After remove(Date):      " + fruits);
        fruits.remove(0);
        System.out.println("After remove(index 0):   " + fruits);

        // Iteration methods
        System.out.println("\n--- Iteration: for-i ---");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print(fruits.get(i) + " ");
        }
        System.out.println();

        System.out.println("\n--- Iteration: enhanced for ---");
        for (String f : fruits) {
            System.out.print(f + " ");
        }
        System.out.println();

        System.out.println("\n--- Iteration: forEach lambda ---");
        fruits.forEach(f -> System.out.print(f.toUpperCase() + " "));
        System.out.println();

        // Bulk operations
        System.out.println("\n--- Bulk Operations ---");
        ArrayList<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1, 9, 3, 7, 4, 6));
        System.out.println("Original:  " + numbers);
        Collections.sort(numbers);
        System.out.println("Sorted:    " + numbers);
        Collections.reverse(numbers);
        System.out.println("Reversed:  " + numbers);
        System.out.println("Min: " + Collections.min(numbers) + ", Max: " + Collections.max(numbers));

        // Sublist
        System.out.println("\n--- Sublist ---");
        Collections.sort(numbers);
        List<Integer> sub = numbers.subList(2, 5);
        System.out.println("Full list: " + numbers);
        System.out.println("subList(2,5): " + sub);

        // removeIf
        System.out.println("\n--- removeIf ---");
        ArrayList<Integer> data = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        data.removeIf(n -> n % 2 == 0);
        System.out.println("After removing evens: " + data);

        // List.of (immutable) vs ArrayList (mutable)
        System.out.println("\n--- Immutable vs Mutable ---");
        List<String> immutable = List.of("X", "Y", "Z");
        ArrayList<String> mutable = new ArrayList<>(immutable);
        mutable.add("W");
        System.out.println("Immutable: " + immutable);
        System.out.println("Mutable:   " + mutable);
    }
}
