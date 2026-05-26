import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {

    public static void main(String[] args) {

        try {

            FileWriter writer = new FileWriter("badhon.txt");

            writer.write("Name: Badhon Pain\n");
            writer.write("University: BUET\n");
            writer.write("Dream : Leave BUET");

            writer.close();

            System.out.println("File written successfully.");
        }
        catch (IOException e) {

            System.out.println("Error occurred.");
        }
    }
}