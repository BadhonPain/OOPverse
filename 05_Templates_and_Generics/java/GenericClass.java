// Generic class with type parameter <T>
import java.util.Arrays;

public class GenericClass {

    static class Box<T> {
        private T content;

        Box(T content) { this.content = content; }

        T get() { return content; }
        void set(T content) { this.content = content; }
        boolean isEmpty() { return content == null; }

        @Override
        public String toString() { return "Box[" + content + "]"; }
    }

    static class Pair<A, B> {
        final A first;
        final B second;

        Pair(A first, B second) { this.first = first; this.second = second; }

        @Override
        public String toString() { return "(" + first + ", " + second + ")"; }
    }

    static class Stack<T> {
        private Object[] data;
        private int top;

        @SuppressWarnings("unchecked")
        Stack(int capacity) {
            data = new Object[capacity];
            top = -1;
        }

        void push(T item) {
            if (top >= data.length - 1) throw new RuntimeException("Stack overflow");
            data[++top] = item;
        }

        @SuppressWarnings("unchecked")
        T pop() {
            if (top < 0) throw new RuntimeException("Stack underflow");
            return (T) data[top--];
        }

        @SuppressWarnings("unchecked")
        T peek() {
            if (top < 0) throw new RuntimeException("Stack empty");
            return (T) data[top];
        }

        int size() { return top + 1; }
        boolean isEmpty() { return top < 0; }

        @Override
        public String toString() {
            return "Stack" + Arrays.toString(Arrays.copyOf(data, top + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Generic Class ===\n");

        // Box with different types
        System.out.println("--- Box<T> ---");
        Box<String> strBox = new Box<>("Hello Generics");
        Box<Integer> intBox = new Box<>(42);
        Box<Double> dblBox = new Box<>(3.14);

        System.out.println("String box: " + strBox);
        System.out.println("Integer box: " + intBox);
        System.out.println("Double box: " + dblBox);

        strBox.set("Updated!");
        System.out.println("After set: " + strBox);

        // Pair with two type parameters
        System.out.println("\n--- Pair<A, B> ---");
        Pair<String, Integer> nameAge = new Pair<>("Alice", 30);
        Pair<Integer, Boolean> idActive = new Pair<>(101, true);
        Pair<String, Pair<Double, Double>> location = new Pair<>("HQ", new Pair<>(23.8, 90.4));

        System.out.println("Name-Age: " + nameAge);
        System.out.println("ID-Active: " + idActive);
        System.out.println("Nested pair: " + location);

        // Generic Stack
        System.out.println("\n--- Stack<T> ---");
        Stack<String> stack = new Stack<>(5);
        stack.push("first");
        stack.push("second");
        stack.push("third");
        System.out.println("Stack: " + stack);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("After pop: " + stack + " (size=" + stack.size() + ")");

        Stack<Integer> numStack = new Stack<>(3);
        numStack.push(10);
        numStack.push(20);
        System.out.println("\nInt stack: " + numStack);
    }
}
