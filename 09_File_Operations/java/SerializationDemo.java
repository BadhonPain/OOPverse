import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {

    int id;
    String name;

    Student(int id, String name) {

        this.id = id;
        this.name = name;
    }
}

public class SerializationDemo {

    public static void main(String[] args) {

        try {

            Student s1 =
                    new Student(1, "Badhon Pain");

            FileOutputStream fout =
                    new FileOutputStream("student.dat");

            ObjectOutputStream out =
                    new ObjectOutputStream(fout);

            out.writeObject(s1);

            out.close();
            fout.close();

            System.out.println("Object saved.");
        }
        catch (Exception e) {

            System.out.println(e);
        }
    }
}