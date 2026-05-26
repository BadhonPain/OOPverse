import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyDemo {

    public static void main(String[] args) {

        try {

            FileReader source =
                    new FileReader("badhon.txt");

            FileWriter destination =
                    new FileWriter("copy.txt");

            int ch;

            while ((ch = source.read()) != -1) {

                destination.write(ch);
            }

            source.close();
            destination.close();

            System.out.println("File copied successfully.");
        }
        catch (IOException e) {

            System.out.println(e);
        }
    }
}