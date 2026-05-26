import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Programmer {

    int id;
    String name;

    Programmer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

class SortByName implements Comparator<Programmer> {

    @Override
    public int compare(Programmer p1, Programmer p2) {

        return p1.name.compareTo(p2.name);
    }
}

public class CustomComparator {
// Important for TF
    public static void main(String[] args) {

        List<Programmer> list = new ArrayList<>();

        list.add(new Programmer(3, "Messi"));
        list.add(new Programmer(1, "Badhon"));
        list.add(new Programmer(2, "Sam Altman"));

        Collections.sort(list, new SortByName());

        for (Programmer p : list) {
            System.out.println(p);
        }
    }
}