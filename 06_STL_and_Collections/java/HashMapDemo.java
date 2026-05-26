// HashMap: put, get, iterate, and utility methods
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapDemo {

    public static void main(String[] args) {
        System.out.println("=== HashMap Demo ===\n");

        // Basic operations
        System.out.println("--- Basic Operations ---");
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 28);
        ages.put("Diana", 22);
        System.out.println("Map: " + ages);
        System.out.println("Size: " + ages.size());

        // Access
        System.out.println("\n--- Access ---");
        System.out.println("get(Alice):   " + ages.get("Alice"));
        System.out.println("get(Unknown): " + ages.get("Unknown"));
        System.out.println("getOrDefault: " + ages.getOrDefault("Unknown", -1));
        System.out.println("containsKey:  " + ages.containsKey("Bob"));
        System.out.println("containsVal:  " + ages.containsValue(30));

        // Update
        System.out.println("\n--- Update ---");
        ages.put("Alice", 26);  // overwrite
        ages.putIfAbsent("Eve", 35);
        ages.putIfAbsent("Bob", 99);  // won't overwrite
        System.out.println("After updates: " + ages);

        // Compute operations
        System.out.println("\n--- Compute Operations ---");
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        for (String w : words) {
            wordCount.merge(w, 1, Integer::sum);
        }
        System.out.println("Word counts: " + wordCount);

        wordCount.compute("apple", (k, v) -> v * 10);
        System.out.println("After compute: " + wordCount);

        wordCount.computeIfAbsent("date", k -> 0);
        System.out.println("computeIfAbsent: " + wordCount);

        // Iteration
        System.out.println("\n--- Iteration: entrySet ---");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n--- Iteration: keySet ---");
        System.out.print("Keys: ");
        for (String key : ages.keySet()) System.out.print(key + " ");
        System.out.println();

        System.out.println("\n--- Iteration: values ---");
        System.out.print("Values: ");
        ages.values().forEach(v -> System.out.print(v + " "));
        System.out.println();

        System.out.println("\n--- Iteration: forEach ---");
        ages.forEach((k, v) -> System.out.printf("  %-10s is %d years old%n", k, v));

        // Removal
        System.out.println("\n--- Removal ---");
        ages.remove("Diana");
        ages.remove("Bob", 999);  // won't remove (value mismatch)
        System.out.println("After remove: " + ages);

        // Sorted map with TreeMap
        System.out.println("\n--- TreeMap (sorted keys) ---");
        TreeMap<String, Integer> sorted = new TreeMap<>(ages);
        sorted.put("Zara", 19);
        System.out.println("TreeMap: " + sorted);
        System.out.println("firstKey: " + sorted.firstKey());
        System.out.println("lastKey:  " + sorted.lastKey());

        // Map.of (immutable)
        System.out.println("\n--- Immutable Map ---");
        Map<String, String> capitals = Map.of("BD", "Dhaka", "US", "Washington", "UK", "London");
        System.out.println("Capitals: " + capitals);
    }
}
