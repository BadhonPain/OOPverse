import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {

        Vector<String> players = new Vector<>();

        players.add("Messi");
        players.add("Ronaldo");
        players.add("Badhon Pain");

        System.out.println("Vector Size: " + players.size());

        System.out.println(players);

        players.remove("Ronaldo");

        System.out.println(players);

        System.out.println("First Player: " + players.firstElement());
    }
}