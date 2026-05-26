import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Student implements Serializable {

    int id;
    String name;

    Student(int id, String name) {

        this.id = id;
        this.name = name;
    }
}

public class DeserializationDemo {

    public static void main(String[] args) {

        try {

            FileInputStream fin =
                    new FileInputStream("student.dat");

            ObjectInputStream in =
                    new ObjectInputStream(fin);

            Student s =
                    (Student) in.readObject();

            System.out.println(s.id);
            System.out.println(s.name);

            in.close();
            fin.close();
        }
        catch (Exception e) {

            System.out.println(e);
        }
    }
}