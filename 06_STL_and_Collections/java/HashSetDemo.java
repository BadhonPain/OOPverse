// HashSet operations and uniqueness enforcement
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point p)) return false;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() { return Objects.hash(x, y); }

        @Override
        public String toString() { return "(" + x + "," + y + ")"; }
    }

    public static void main(String[] args) {
        System.out.println("=== HashSet Demo ===\n");

        // Basic operations
        System.out.println("--- Basic Operations ---");
        HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        boolean added = colors.add("Red");  // duplicate
        System.out.println("Set: " + colors);
        System.out.println("Added duplicate 'Red': " + added);
        System.out.println("Size: " + colors.size());
        System.out.println("Contains Blue: " + colors.contains("Blue"));

        // Removal
        System.out.println("\n--- Removal ---");
        colors.remove("Green");
        System.out.println("After remove(Green): " + colors);

        // Set operations
        System.out.println("\n--- Set Operations ---");
        Set<Integer> a = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<>(Set.of(4, 5, 6, 7, 8));
        System.out.println("A: " + a);
        System.out.println("B: " + b);

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        System.out.println("Union (A ∪ B):        " + union);

        Set<Integer> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        System.out.println("Intersection (A ∩ B): " + intersection);

        Set<Integer> difference = new HashSet<>(a);
        difference.removeAll(b);
        System.out.println("Difference (A - B):   " + difference);

        Set<Integer> symDiff = new HashSet<>(a);
        symDiff.addAll(b);
        Set<Integer> common = new HashSet<>(a);
        common.retainAll(b);
        symDiff.removeAll(common);
        System.out.println("Symmetric diff (A △ B): " + symDiff);

        // Subset check
        Set<Integer> sub = Set.of(2, 3);
        System.out.println(sub + " subset of A: " + a.containsAll(sub));

        // Custom objects with equals/hashCode
        System.out.println("\n--- Custom Objects (equals/hashCode) ---");
        HashSet<Point> points = new HashSet<>();
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(1, 2));  // duplicate
        System.out.println("Points: " + points);
        System.out.println("Contains (1,2): " + points.contains(new Point(1, 2)));

        // LinkedHashSet preserves insertion order
        System.out.println("\n--- LinkedHashSet (insertion order) ---");
        LinkedHashSet<String> ordered = new LinkedHashSet<>();
        ordered.add("Banana"); ordered.add("Apple"); ordered.add("Cherry");
        System.out.println("LinkedHashSet: " + ordered);

        // TreeSet keeps sorted order
        System.out.println("\n--- TreeSet (sorted order) ---");
        TreeSet<String> sorted = new TreeSet<>();
        sorted.add("Banana"); sorted.add("Apple"); sorted.add("Cherry"); sorted.add("Date");
        System.out.println("TreeSet: " + sorted);
        System.out.println("first: " + sorted.first() + ", last: " + sorted.last());
        System.out.println("headSet(Cherry): " + sorted.headSet("Cherry"));
        System.out.println("tailSet(Cherry): " + sorted.tailSet("Cherry"));

        // Deduplicate a list
        System.out.println("\n--- Deduplication ---");
        var withDups = java.util.List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        var unique = new TreeSet<>(withDups);
        System.out.println("With duplicates: " + withDups);
        System.out.println("Deduplicated:    " + unique);
    }
}
