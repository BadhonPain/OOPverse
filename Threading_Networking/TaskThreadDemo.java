package Threading_Networking;

class PrintChar implements Runnable {
    char ch;
    int times;

    public PrintChar(char ch, int times) {
        this.ch = ch;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(ch + " ");
        }
    }

};

class PrintNum implements Runnable {
    int times;

    public PrintNum(int times) {
        this.times = times;
    }

    @Override
    public void run() {
        Thread thread4 = new Thread(new PrintChar('c', 100));
        thread4.start();
        try {
            for (int i = 1; i <= times; i++) {
                // try {
                // Thread.sleep(1000);
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
                System.out.print(i + " ");
                if (i == 40)
                    thread4.join();
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        // Thread.yield();

    }

};

public class TaskThreadDemo {
    public static void main(String[] args) {
        Runnable PrintA = new PrintChar('a', 100);
        Runnable PrintB = new PrintChar('b', 100);
        Runnable Print100 = new PrintNum(100);

        Thread thread1 = new Thread(PrintA);
        Thread thread2 = new Thread(PrintB);
        Thread thread3 = new Thread(Print100);
        // thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
