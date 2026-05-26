import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {

    public static void main(String[] args) {

        try {

            FileReader reader = new FileReader("badhon.txt");

            int ch;

            while ((ch = reader.read()) != -1) {

                System.out.print((char) ch);
            }

            reader.close();
        }
        catch (IOException e) {

            System.out.println("File error.");
        }
    }
}