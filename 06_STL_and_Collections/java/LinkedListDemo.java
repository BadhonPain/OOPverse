// LinkedList operations: List + Deque interface
import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListDemo {

    public static void main(String[] args) {
        System.out.println("=== LinkedList Demo ===\n");

        // Basic list operations
        System.out.println("--- Basic Operations ---");
        LinkedList<String> list = new LinkedList<>();
        list.add("B");
        list.add("D");
        list.addFirst("A");
        list.addLast("E");
        list.add(2, "C");
        System.out.println("List:    " + list);
        System.out.println("First:   " + list.getFirst());
        System.out.println("Last:    " + list.getLast());
        System.out.println("Size:    " + list.size());

        // Removal
        System.out.println("\n--- Removal ---");
        list.removeFirst();
        System.out.println("After removeFirst: " + list);
        list.removeLast();
        System.out.println("After removeLast:  " + list);
        list.remove("C");
        System.out.println("After remove(C):   " + list);

        // Deque operations (stack-like)
        System.out.println("\n--- As Stack (push/pop/peek) ---");
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Peek:  " + stack.peek());
        System.out.println("Pop:   " + stack.pop());
        System.out.println("After: " + stack);

        // Queue operations (offer/poll/peek)
        System.out.println("\n--- As Queue (offer/poll/peek) ---");
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue:  " + queue);
        System.out.println("Peek:   " + queue.peek());
        System.out.println("Poll:   " + queue.poll());
        System.out.println("After:  " + queue);

        // Iteration
        System.out.println("\n--- Forward Iteration ---");
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= 5; i++) nums.add(i * 10);

        System.out.print("Enhanced for: ");
        for (int n : nums) System.out.print(n + " ");
        System.out.println();

        System.out.print("Iterator:     ");
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) System.out.print(it.next() + " ");
        System.out.println();

        // Descending iteration
        System.out.println("\n--- Descending Iteration ---");
        System.out.print("Descending:   ");
        var descIt = nums.descendingIterator();
        while (descIt.hasNext()) System.out.print(descIt.next() + " ");
        System.out.println();

        // Modify during iteration
        System.out.println("\n--- Remove During Iteration ---");
        System.out.println("Before: " + nums);
        Iterator<Integer> modIt = nums.iterator();
        while (modIt.hasNext()) {
            if (modIt.next() > 30) modIt.remove();
        }
        System.out.println("After removing > 30: " + nums);

        // Searching
        System.out.println("\n--- Searching ---");
        LinkedList<String> names = new LinkedList<>();
        names.add("Alice"); names.add("Bob"); names.add("Charlie"); names.add("Bob");
        System.out.println("List: " + names);
        System.out.println("indexOf(Bob):     " + names.indexOf("Bob"));
        System.out.println("lastIndexOf(Bob): " + names.lastIndexOf("Bob"));
        System.out.println("contains(Eve):    " + names.contains("Eve"));
    }
}
