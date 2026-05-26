import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Footballer {

    int jersey;
    String name;

    Footballer(int jersey, String name) {
        this.jersey = jersey;
        this.name = name;
    }

    @Override
    public String toString() {
        return jersey + " - " + name;
    }
}

public class LambdaComparatorDemo {

    public static void main(String[] args) {

        List<Footballer> players = new ArrayList<>();

        players.add(new Footballer(10, "Messi"));
        players.add(new Footballer(7, "Ronaldo"));
        players.add(new Footballer(1, "Badhon"));

        players.sort((a, b) -> a.name.compareTo(b.name));

        System.out.println(players);

        players.sort(Comparator.comparingInt(p -> p.jersey));

        System.out.println(players);
    }
}