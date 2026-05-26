// Generic sorting with Comparable interface
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenericSort {

    static class Student implements Comparable<Student> {
        String name;
        double gpa;
        int age;

        Student(String name, double gpa, int age) {
            this.name = name;
            this.gpa = gpa;
            this.age = age;
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.gpa, this.gpa); // descending by GPA
        }

        @Override
        public String toString() {
            return String.format("%-8s GPA=%.2f Age=%d", name, gpa, age);
        }
    }

    // Generic bubble sort — works with any Comparable type
    static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Generic insertion sort with custom Comparator
    static <T> void insertionSort(List<T> list, Comparator<T> cmp) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && cmp.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    static <T> void printList(String label, List<T> list) {
        System.out.println(label);
        for (T item : list) System.out.println("  " + item);
    }

    public static void main(String[] args) {
        System.out.println("=== Generic Sort ===\n");

        // Sorting Integers with Comparable
        System.out.println("--- Sorting Integers (Comparable) ---");
        List<Integer> nums = new ArrayList<>(List.of(64, 25, 12, 22, 11));
        System.out.println("Before: " + nums);
        bubbleSort(nums);
        System.out.println("After:  " + nums);

        // Sorting Strings
        System.out.println("\n--- Sorting Strings (Comparable) ---");
        List<String> words = new ArrayList<>(List.of("banana", "apple", "cherry", "date"));
        System.out.println("Before: " + words);
        bubbleSort(words);
        System.out.println("After:  " + words);

        // Sorting Students with natural ordering (GPA descending)
        System.out.println("\n--- Students: Natural Order (GPA desc) ---");
        List<Student> students = new ArrayList<>(List.of(
            new Student("Alice", 3.8, 21),
            new Student("Bob", 3.5, 22),
            new Student("Charlie", 3.9, 20),
            new Student("Diana", 3.7, 23),
            new Student("Eve", 4.0, 21)
        ));
        Collections.sort(students);
        printList("Sorted by GPA (descending):", students);

        // Custom Comparator: by name
        System.out.println("\n--- Students: Custom Comparator (by name) ---");
        students.sort(Comparator.comparing(s -> s.name));
        printList("Sorted by name:", students);

        // Custom Comparator: by age, then GPA
        System.out.println("\n--- Students: Multi-key (age asc, GPA desc) ---");
        students.sort(Comparator.comparingInt((Student s) -> s.age)
                                .thenComparing(Comparator.comparingDouble((Student s) -> s.gpa).reversed()));
        printList("Sorted by age, then GPA:", students);

        // Using our generic insertionSort with lambda
        System.out.println("\n--- Generic insertionSort with Comparator ---");
        List<String> names = new ArrayList<>(List.of("Zara", "Mike", "Anna", "Leo"));
        System.out.println("Before: " + names);
        insertionSort(names, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("By length: " + names);
        insertionSort(names, Comparator.reverseOrder());
        System.out.println("Reverse:   " + names);
    }
}
