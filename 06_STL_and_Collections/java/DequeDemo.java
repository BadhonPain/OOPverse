import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {

    public static void main(String[] args) {

        Deque<String> names = new ArrayDeque<>();

        names.addFirst("Badhon");
        names.addLast("Messi");
        names.push("Ronaldo");

        System.out.println("Front: " + names.getFirst());
        System.out.println("Last: " + names.getLast());

        System.out.println("Removed Front: " + names.removeFirst());

        System.out.println("Current Queue: " + names);

        System.out.println("Top Element: " + names.pop());

        System.out.println(names);
    }
}