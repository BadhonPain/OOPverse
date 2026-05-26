public class ClassBasics {
    // Encapsulated fields
    private String name;
    private int age;
    private double gpa;

    // Default constructor
    ClassBasics() {
        this.name = "Unknown";
        this.age = 0;
        this.gpa = 0.0;
    }

    // Parameterized constructor
    ClassBasics(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        setGpa(gpa);
    }

    // Constructor chaining with this()
    ClassBasics(String name) {
        this(name, 18, 0.0);
    }

    // Getters
    String getName() { return name; }
    int getAge() { return age; }
    double getGpa() { return gpa; }

    // Setters with validation
    void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age: " + age);
        }
    }

    void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA: " + gpa);
        }
    }

    // Business logic method
    String getHonorStatus() {
        if (gpa >= 3.8) return "Summa Cum Laude";
        if (gpa >= 3.5) return "Magna Cum Laude";
        if (gpa >= 3.0) return "Cum Laude";
        return "No Honors";
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, gpa=%.2f, honors='%s'}",
                name, age, gpa, getHonorStatus());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClassBasics)) return false;
        ClassBasics other = (ClassBasics) obj;
        return name.equals(other.name) && age == other.age
                && Double.compare(gpa, other.gpa) == 0;
    }

    public static void main(String[] args) {
        // Default constructor
        System.out.println("=== Constructors ===");
        ClassBasics s1 = new ClassBasics();
        System.out.println("Default: " + s1);

        // Parameterized constructor
        ClassBasics s2 = new ClassBasics("Alice", 21, 3.85);
        System.out.println("Parameterized: " + s2);

        // Chained constructor
        ClassBasics s3 = new ClassBasics("Bob");
        System.out.println("Chained: " + s3);

        // Encapsulation - setters validate input
        System.out.println("\n=== Encapsulation (Validation) ===");
        s3.setAge(20);
        s3.setGpa(3.55);
        System.out.println("After valid updates: " + s3);

        s3.setAge(-5);
        s3.setGpa(5.0);
        System.out.println("After invalid updates: " + s3);

        // Getters
        System.out.println("\n=== Getters ===");
        System.out.println("Name: " + s2.getName());
        System.out.println("Age: " + s2.getAge());
        System.out.println("GPA: " + s2.getGpa());

        // toString and equals
        System.out.println("\n=== toString / equals ===");
        ClassBasics s4 = new ClassBasics("Alice", 21, 3.85);
        System.out.println("s2: " + s2);
        System.out.println("s4: " + s4);
        System.out.println("s2.equals(s4): " + s2.equals(s4));
        System.out.println("s2 == s4: " + (s2 == s4));
    }
}
