import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {
    // Unbounded wildcard: matches any type
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // Upper bounded wildcard: matches Number and its subclasses
    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // Lower bounded wildcard: matches Integer and its superclasses
    public static void addIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        addIntegers(intList);
        System.out.print("Integer List: ");
        printList(intList);
        System.out.println("Sum of Integer List: " + sumOfList(intList));

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        doubleList.add(3.5);
        System.out.print("Double List: ");
        printList(doubleList);
        System.out.println("Sum of Double List: " + sumOfList(doubleList));
    }
}
