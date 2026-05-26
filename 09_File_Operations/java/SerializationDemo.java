// ObjectOutputStream/ObjectInputStream and Serializable

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String name;
        private final int age;
        private final double gpa;
        private transient String tempNote; // not serialized

        Student(String name, int age, double gpa, String tempNote) {
            this.name = name;
            this.age = age;
            this.gpa = gpa;
            this.tempNote = tempNote;
        }

        @Override
        public String toString() {
            return String.format("Student{name='%s', age=%d, gpa=%.2f, tempNote='%s'}",
                    name, age, gpa, tempNote);
        }
    }

    static class Course implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String title;
        private final List<Student> students;

        Course(String title) {
            this.title = title;
            this.students = new ArrayList<>();
        }

        void addStudent(Student s) { students.add(s); }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Course: " + title + "\n");
            for (Student s : students) {
                sb.append("    ").append(s).append("\n");
            }
            return sb.toString();
        }
    }

    static class Config implements Serializable {
        private static final long serialVersionUID = 2L;
        private final String appName;
        private final int version;
        private final boolean debugMode;

        Config(String appName, int version, boolean debugMode) {
            this.appName = appName;
            this.version = version;
            this.debugMode = debugMode;
        }

        @Override
        public String toString() {
            return String.format("Config{app='%s', v%d, debug=%b}", appName, version, debugMode);
        }
    }

    public static void main(String[] args) {
        String filename = "sd_data.ser";

        System.out.println("===== Serializing a single object =====");
        Student original = new Student("Alice", 20, 3.85, "Temporary session data");
        System.out.println("  Before: " + original);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(original);
            System.out.println("  Serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Serialize error: " + e.getMessage());
            return;
        }

        System.out.println("\n===== Deserializing =====");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student loaded = (Student) ois.readObject();
            System.out.println("  After:  " + loaded);
            System.out.println("  (notice tempNote is null - it's transient)");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialize error: " + e.getMessage());
        }

        System.out.println("\n===== Serializing object graph =====");
        String courseFile = "sd_course.ser";
        Course course = new Course("Object-Oriented Programming");
        course.addStudent(new Student("Bob", 21, 3.5, "note1"));
        course.addStudent(new Student("Charlie", 22, 3.9, "note2"));
        course.addStudent(new Student("Diana", 20, 3.7, "note3"));

        System.out.println("  Original:");
        System.out.print("  " + course);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(courseFile))) {
            oos.writeObject(course);
            System.out.println("  Serialized course with " + course.students.size() + " students");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(courseFile))) {
            Course loaded = (Course) ois.readObject();
            System.out.println("\n  Deserialized:");
            System.out.print("  " + loaded);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== Multiple objects in one stream =====");
        String multiFile = "sd_multi.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(multiFile))) {
            oos.writeObject(new Student("Eve", 19, 3.6, "x"));
            oos.writeObject(new Config("OOPverse", 2, true));
            oos.writeInt(42);
            oos.writeUTF("End of data");
            System.out.println("  Wrote multiple objects and primitives");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(multiFile))) {
            Student s = (Student) ois.readObject();
            Config c = (Config) ois.readObject();
            int num = ois.readInt();
            String msg = ois.readUTF();
            System.out.println("  Read back:");
            System.out.println("    " + s);
            System.out.println("    " + c);
            System.out.println("    int: " + num);
            System.out.println("    String: " + msg);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== Serialized file sizes =====");
        System.out.printf("  %-20s : %d bytes%n", filename, new File(filename).length());
        System.out.printf("  %-20s : %d bytes%n", courseFile, new File(courseFile).length());
        System.out.printf("  %-20s : %d bytes%n", multiFile, new File(multiFile).length());

        new File(filename).delete();
        new File(courseFile).delete();
        new File(multiFile).delete();
        System.out.println("\nCleanup complete.");
    }
}
