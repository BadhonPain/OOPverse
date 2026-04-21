package Threading_Networking;

public class TaskThreadDemo_2 {
    public static void main(String[] args) {
        CustomThread PrintName = new CustomThread("I hate T");
        PrintName.start();
        CustomThread PrintMsg = new CustomThread("I love Coding");
        PrintMsg.start();
    }
}

class CustomThread extends Thread {
    private String name;

    public CustomThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(name + " ");
        }
    }

};
