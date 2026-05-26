// Upcasting, dynamic dispatch, and polymorphic behavior
public class RuntimePolymorphism {

    static abstract class Shape {
        String name;
        Shape(String name) { this.name = name; }
        abstract double area();
        void display() { System.out.printf("  %-12s area = %.2f%n", name, area()); }
    }

    static class Circle extends Shape {
        double radius;
        Circle(double radius) { super("Circle"); this.radius = radius; }
        double area() { return Math.PI * radius * radius; }
    }

    static class Rectangle extends Shape {
        double width, height;
        Rectangle(double w, double h) { super("Rectangle"); width = w; height = h; }
        double area() { return width * height; }
    }

    static class Triangle extends Shape {
        double base, height;
        Triangle(double b, double h) { super("Triangle"); base = b; height = h; }
        double area() { return 0.5 * base * height; }
    }

    static class Square extends Rectangle {
        Square(double side) { super(side, side); name = "Square"; }
    }

    static void printAllAreas(Shape[] shapes) {
        System.out.println("--- Dynamic dispatch via base reference ---");
        for (Shape s : shapes) {
            s.display();
        }
    }

    static double totalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.area();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("=== Runtime Polymorphism ===\n");

        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8),
            new Square(7)
        };

        printAllAreas(shapes);
        System.out.printf("%nTotal area = %.2f%n", totalArea(shapes));

        System.out.println("\n--- Upcasting ---");
        Shape s = new Circle(10);  // upcasting: Circle -> Shape
        System.out.println("Reference type: Shape, actual: " + s.getClass().getSimpleName());
        s.display();  // calls Circle.area() via dynamic dispatch

        System.out.println("\n--- Polymorphic array processing ---");
        Shape biggest = shapes[0];
        for (Shape sh : shapes) {
            if (sh.area() > biggest.area()) biggest = sh;
        }
        System.out.println("Largest shape: " + biggest.name + " (area=" + String.format("%.2f", biggest.area()) + ")");
    }
}
