import java.io.File;

public class FileClassDemo {

    public static void main(String[] args) {

        File file = new File("badhon.txt");

        System.out.println("File Name: " +
                file.getName());

        System.out.println("Path: " +
                file.getPath());

        System.out.println("Exists: " +
                file.exists());

        System.out.println("Readable: " +
                file.canRead());

        System.out.println("Writable: " +
                file.canWrite());
    }
}