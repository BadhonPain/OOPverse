import java.util.Hashtable;

public class HashTableDemo {

    public static void main(String[] args) {

        Hashtable<Integer, String> techLeaders =
                new Hashtable<>();

        techLeaders.put(1, "Elon Musk");
        techLeaders.put(2, "Sam Altman");
        techLeaders.put(3, "Badhon Pain");

        System.out.println(techLeaders);

        System.out.println(
                "Leader at key 2: " +
                techLeaders.get(2)
        );

        techLeaders.remove(1);

        System.out.println(techLeaders);
    }
}