import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo2 {

    public static void main(String[] args) {

        List<Integer> marks = new ArrayList<>();

        marks.add(95);
        marks.add(88);
        marks.add(76);
        marks.add(100);
        marks.add(91);

        // foreach loop
        for (Integer m : marks) {
            System.out.print(m + " ");
        }

        System.out.println();

        // lambda expression
        marks.forEach(x -> System.out.print(x + " "));

        System.out.println();

        // remove element
        marks.remove(2);

        // list to array
        Integer[] arr = new Integer[marks.size()];
        marks.toArray(arr);

        System.out.println(Arrays.toString(arr));

        // array to list
        List<Integer> newList = Arrays.asList(arr);

        System.out.println(newList);
    }
}