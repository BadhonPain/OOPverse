import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> footballers = new ArrayList<>();

        footballers.add("Messi");
        footballers.add("Ronaldo");
        footballers.add("Badhon");

        footballers.add(1, "Neymar");

        System.out.println(footballers);

        System.out.println("First Player: " + footballers.get(0));

        System.out.println("Index of Ronaldo: " +
                footballers.indexOf("Ronaldo"));

        footballers.remove(2);

        System.out.println(footballers);
    }
}