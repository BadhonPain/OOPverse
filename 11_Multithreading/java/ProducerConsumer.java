import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    static class BoundedBuffer<T> {
        private final Queue<T> queue = new LinkedList<>();
        private final int capacity;

        BoundedBuffer(int capacity) { this.capacity = capacity; }

        synchronized void put(T item) throws InterruptedException {
            while (queue.size() == capacity) {
                System.out.println("  [Producer] Buffer full, waiting...");
                wait();
            }
            queue.add(item);
            System.out.println("  [Producer] Added: " + item + " | Buffer: " + queue.size() + "/" + capacity);
            notifyAll();
        }

        synchronized T take() throws InterruptedException {
            while (queue.isEmpty()) {
                System.out.println("  [Consumer] Buffer empty, waiting...");
                wait();
            }
            T item = queue.poll();
            System.out.println("  [Consumer] Took:  " + item + " | Buffer: " + queue.size() + "/" + capacity);
            notifyAll();
            return item;
        }

        synchronized int size() { return queue.size(); }
    }

    static class Producer implements Runnable {
        private final BoundedBuffer<String> buffer;
        private final String name;
        private final int itemCount;

        Producer(String name, BoundedBuffer<String> buffer, int itemCount) {
            this.name = name;
            this.buffer = buffer;
            this.itemCount = itemCount;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= itemCount; i++) {
                    String item = name + "-Item" + i;
                    buffer.put(item);
                    Thread.sleep(60);
                }
                System.out.println("  [" + name + "] Done producing");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final BoundedBuffer<String> buffer;
        private final String name;
        private final int itemCount;

        Consumer(String name, BoundedBuffer<String> buffer, int itemCount) {
            this.name = name;
            this.buffer = buffer;
            this.itemCount = itemCount;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < itemCount; i++) {
                    String item = buffer.take();
                    Thread.sleep(100);
                }
                System.out.println("  [" + name + "] Done consuming");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Single Producer, Single Consumer ===");
        BoundedBuffer<String> buffer1 = new BoundedBuffer<>(3);
        Thread p1 = new Thread(new Producer("P1", buffer1, 6));
        Thread c1 = new Thread(new Consumer("C1", buffer1, 6));
        p1.start();
        c1.start();
        p1.join();
        c1.join();

        System.out.println("\n=== Multiple Producers, Single Consumer ===");
        BoundedBuffer<String> buffer2 = new BoundedBuffer<>(4);
        Thread pa = new Thread(new Producer("PA", buffer2, 3));
        Thread pb = new Thread(new Producer("PB", buffer2, 3));
        Thread c2 = new Thread(new Consumer("C2", buffer2, 6));
        pa.start();
        pb.start();
        c2.start();
        pa.join();
        pb.join();
        c2.join();

        System.out.println("\nProducer-Consumer demo completed!");
    }
}
