import java.util.ArrayList;
import java.util.List;
// ArrayList with custom class
class Student {

    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class ArrayListDemo3 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Badhon Pain"));
        students.add(new Student(2, "Messi"));
        students.add(new Student(3, "Sam Altman"));

        for (Student s : students) {
            System.out.println(s);
        }
    }
}