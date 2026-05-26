public class ThreadDemo {

    static int sharedCounter = 0;

    static class CounterThread extends Thread {
        private String name;
        private int count;

        CounterThread(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                System.out.println("  [" + name + "] Count: " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { break; }
            }
            System.out.println("  [" + name + "] Finished!");
        }
    }

    static class RunnableTask implements Runnable {
        private String taskName;

        RunnableTask(String taskName) { this.taskName = taskName; }

        @Override
        public void run() {
            System.out.println("  [" + taskName + "] Running on thread: " + Thread.currentThread().getName());
            try { Thread.sleep(200); } catch (InterruptedException e) { return; }
            System.out.println("  [" + taskName + "] Complete");
        }
    }

    static synchronized void incrementCounter() {
        sharedCounter++;
    }

    static class SyncWorker extends Thread {
        private int iterations;

        SyncWorker(String name, int iterations) {
            super(name);
            this.iterations = iterations;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterations; i++) {
                incrementCounter();
            }
        }
    }

    static class SynchronizedBuffer {
        private final Object lock = new Object();
        private int value = 0;
        private boolean hasValue = false;

        void put(int v) {
            synchronized (lock) {
                while (hasValue) {
                    try { lock.wait(); } catch (InterruptedException e) { return; }
                }
                value = v;
                hasValue = true;
                System.out.println("  [Writer] Put: " + v);
                lock.notifyAll();
            }
        }

        int take() {
            synchronized (lock) {
                while (!hasValue) {
                    try { lock.wait(); } catch (InterruptedException e) { return -1; }
                }
                hasValue = false;
                System.out.println("  [Reader] Got: " + value);
                lock.notifyAll();
                return value;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Extending Thread Class ===");
        CounterThread t1 = new CounterThread("Alpha", 3);
        CounterThread t2 = new CounterThread("Beta", 3);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("\n=== Implementing Runnable ===");
        Thread r1 = new Thread(new RunnableTask("TaskA"), "Worker-1");
        Thread r2 = new Thread(new RunnableTask("TaskB"), "Worker-2");
        r1.start();
        r2.start();
        r1.join();
        r2.join();

        System.out.println("\n=== Lambda Runnable ===");
        Thread lambdaThread = new Thread(() -> {
            System.out.println("  Lambda thread running on: " + Thread.currentThread().getName());
        }, "Lambda-Thread");
        lambdaThread.start();
        lambdaThread.join();

        System.out.println("\n=== Synchronized Counter ===");
        sharedCounter = 0;
        SyncWorker[] workers = new SyncWorker[4];
        for (int i = 0; i < 4; i++) {
            workers[i] = new SyncWorker("Worker-" + i, 10000);
            workers[i].start();
        }
        for (SyncWorker w : workers) {
            w.join();
        }
        System.out.println("  Final counter: " + sharedCounter + " (expected: 40000)");

        System.out.println("\n=== Synchronized Buffer (wait/notify) ===");
        SynchronizedBuffer buffer = new SynchronizedBuffer();
        Thread writer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.put(i);
                try { Thread.sleep(50); } catch (InterruptedException e) { break; }
            }
        });
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                buffer.take();
                try { Thread.sleep(80); } catch (InterruptedException e) { break; }
            }
        });
        writer.start();
        reader.start();
        writer.join();
        reader.join();

        System.out.println("\nAll threads completed successfully!");
    }
}
