import java.io.FileWriter;
import java.io.IOException;

public class AppendDemo {

    public static void main(String[] args) {

        try {

            // true means append mode
            FileWriter writer =
                    new FileWriter("badhon.txt", true);

            writer.write("\nFavorite Player: Messi");

            writer.close();

            System.out.println("Data appended.");
        }
        catch (IOException e) {

            System.out.println(e);
        }
    }
}