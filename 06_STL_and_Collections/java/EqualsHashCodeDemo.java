import java.util.HashSet;

class Player {

    int id;
    String name;

    Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Player))
            return false;

        Player p = (Player) obj;

        return this.id == p.id &&
               this.name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return id + name.hashCode();
    }
}

public class EqualsHashCodeDemo {
// Super Important for TF
    public static void main(String[] args) {

        HashSet<Player> players = new HashSet<>();

        players.add(new Player(10, "Messi"));
        players.add(new Player(10, "Messi"));
        players.add(new Player(7, "Ronaldo"));
        players.add(new Player(1, "Badhon"));

        System.out.println("Size: " + players.size());

        for (Player p : players) {
            System.out.println(p.id + " " + p.name);
        }
    }
}