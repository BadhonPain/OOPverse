public class NestedClasses {

    private String outerField = "Outer class field";

    // Static nested class
    static class StaticNested {
        private String name;

        StaticNested(String name) { this.name = name; }

        void display() {
            System.out.println("  Static nested class: " + name);
            System.out.println("  (Cannot access outer instance fields directly)");
        }
    }

    // Inner class (non-static)
    class Inner {
        private String name;

        Inner(String name) { this.name = name; }

        void display() {
            System.out.println("  Inner class: " + name);
            System.out.println("  Accessing outerField: " + outerField);
        }
    }

    // Method with a local class
    void demonstrateLocalClass() {
        String localVar = "I'm a local variable";

        class LocalHelper {
            void display() {
                System.out.println("  Local class inside method");
                System.out.println("  Accessing localVar: " + localVar);
                System.out.println("  Accessing outerField: " + outerField);
            }
        }

        LocalHelper helper = new LocalHelper();
        helper.display();
    }

    // Interface for anonymous class demo
    interface Greeter {
        void greet(String name);
    }

    // Abstract class for anonymous class demo
    static abstract class Shape {
        abstract double area();
        abstract String type();
    }

    public static void main(String[] args) {
        System.out.println("=== Static Nested Class ===");
        StaticNested staticObj = new StaticNested("Database Config");
        staticObj.display();

        System.out.println("\n=== Inner Class ===");
        NestedClasses outer = new NestedClasses();
        Inner innerObj = outer.new Inner("Logger");
        innerObj.display();

        System.out.println("\n=== Local Class ===");
        outer.demonstrateLocalClass();

        System.out.println("\n=== Anonymous Class (Interface) ===");
        Greeter formalGreeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("  Good day, " + name + "! How do you do?");
            }
        };

        Greeter casualGreeter = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("  Hey " + name + "! What's up?");
            }
        };

        formalGreeter.greet("Professor");
        casualGreeter.greet("Buddy");

        System.out.println("\n=== Anonymous Class (Abstract Class) ===");
        Shape circle = new Shape() {
            double radius = 5.0;

            @Override
            double area() { return Math.PI * radius * radius; }

            @Override
            String type() { return "Circle (r=" + radius + ")"; }
        };

        Shape rectangle = new Shape() {
            double width = 4.0, height = 6.0;

            @Override
            double area() { return width * height; }

            @Override
            String type() { return "Rectangle (" + width + "x" + height + ")"; }
        };

        System.out.println("  " + circle.type() + " -> area = " + String.format("%.2f", circle.area()));
        System.out.println("  " + rectangle.type() + " -> area = " + String.format("%.2f", rectangle.area()));

        System.out.println("\n=== Lambda vs Anonymous Class ===");
        Greeter lambdaGreeter = name -> System.out.println("  (Lambda) Hello, " + name + "!");
        lambdaGreeter.greet("World");
    }
}
