public class InterfaceDemo_AllInOne {

    // Basic interface
    interface Drawable {
        void draw();
        double area();
    }

    // Another interface
    interface Resizable {
        void resize(double factor);
        String dimensions();
    }

    // Interface with default and static methods (Java 8+)
    interface Printable {
        void print();

        default void printWithBorder() {
            System.out.println("+" + "-".repeat(30) + "+");
            print();
            System.out.println("+" + "-".repeat(30) + "+");
        }

        static String formatForPrint(String text) {
            return ">> " + text.toUpperCase() + " <<";
        }
    }

    // Interface with constants
    interface GameConstants {
        int MAX_PLAYERS = 4;         // implicitly public static final
        double GRAVITY = 9.81;
        String VERSION = "2.0";
    }

    // Class implementing multiple interfaces (Java's alternative to multiple inheritance)
    static class Circle implements Drawable, Resizable, Printable {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public void draw() {
            System.out.println("Drawing circle with radius " + radius);
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public void resize(double factor) {
            radius *= factor;
            System.out.println("Circle resized to radius " + radius);
        }

        @Override
        public String dimensions() {
            return String.format("radius=%.2f, diameter=%.2f", radius, radius * 2);
        }

        @Override
        public void print() {
            System.out.printf("Circle: %s, area=%.2f%n", dimensions(), area());
        }
    }

    static class Rectangle implements Drawable, Resizable, Printable {
        private double width, height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw() {
            System.out.println("Drawing " + width + "x" + height + " rectangle");
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public void resize(double factor) {
            width *= factor;
            height *= factor;
        }

        @Override
        public String dimensions() {
            return String.format("%.2f x %.2f", width, height);
        }

        @Override
        public void print() {
            System.out.printf("Rectangle: %s, area=%.2f%n", dimensions(), area());
        }
    }

    // Interface extending interfaces
    interface Shape extends Drawable, Resizable {
        String getType();
    }

    static class Triangle implements Shape, Printable {
        private double base, height;

        Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public void draw() { System.out.println("Drawing triangle"); }

        @Override
        public double area() { return 0.5 * base * height; }

        @Override
        public void resize(double factor) { base *= factor; height *= factor; }

        @Override
        public String dimensions() { return String.format("base=%.2f, height=%.2f", base, height); }

        @Override
        public String getType() { return "Triangle"; }

        @Override
        public void print() { System.out.printf("%s: %s, area=%.2f%n", getType(), dimensions(), area()); }
    }

    public static void main(String[] args) {
        // Multiple interface implementation
        System.out.println("=== Multiple Interface Implementation ===");
        Circle circle = new Circle(5);
        circle.draw();
        circle.resize(2);
        circle.print();
        circle.printWithBorder();

        // Interface as type (polymorphism)
        System.out.println("\n=== Interface Polymorphism ===");
        Drawable[] shapes = {
            new Circle(3),
            new Rectangle(4, 6),
            new Triangle(5, 8)
        };

        double totalArea = 0;
        for (Drawable shape : shapes) {
            shape.draw();
            System.out.printf("  Area: %.2f%n", shape.area());
            totalArea += shape.area();
        }
        System.out.printf("Total area: %.2f%n", totalArea);

        // Using Resizable interface reference
        System.out.println("\n=== Resizable Interface ===");
        Resizable[] resizables = { new Circle(10), new Rectangle(3, 4) };
        for (Resizable r : resizables) {
            System.out.println("Before: " + r.dimensions());
            r.resize(0.5);
            System.out.println("After:  " + r.dimensions());
        }

        // Default methods
        System.out.println("\n=== Default Methods ===");
        Printable[] printables = { new Circle(7), new Rectangle(3, 5), new Triangle(6, 4) };
        for (Printable p : printables) {
            p.printWithBorder();
        }

        // Static interface method
        System.out.println("\n=== Static Interface Method ===");
        System.out.println(Printable.formatForPrint("Hello from interface"));

        // Interface constants
        System.out.println("\n=== Interface Constants ===");
        System.out.println("Max players: " + GameConstants.MAX_PLAYERS);
        System.out.println("Gravity: " + GameConstants.GRAVITY);
        System.out.println("Version: " + GameConstants.VERSION);

        // Extended interface
        System.out.println("\n=== Extended Interface (Shape) ===");
        Triangle tri = new Triangle(10, 5);
        Shape shapeRef = tri;
        System.out.println("Type: " + shapeRef.getType());
        System.out.println("Dimensions: " + shapeRef.dimensions());
        System.out.printf("Area: %.2f%n", shapeRef.area());
    }
}
