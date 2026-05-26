abstract class S {
    abstract void call(); // must be implemented by subclass

    // concrete methods are allowed in abstract classes
    void call2() {
        System.out.println("This is a concrete method");
    }
}

class T extends S {
    @Override
    void call() {
        System.out.println("T's implementation of call");
    }
}

// Abstract Figure with abstract area()
abstract class Figure2 {
    double d1, d2;

    Figure2(double a, double b) {
        this.d1 = a;
        this.d2 = b;
    }

    abstract double area();
}

class Rectangle2 extends Figure2 {
    Rectangle2(double a, double b) { super(a, b); }

    @Override
    public double area() {
        System.out.println("Inside area for Rectangle");
        return d1 * d2;
    }
}

class Triangle2 extends Figure2 {
    Triangle2(double a, double b) { super(a, b); }

    @Override
    public double area() {
        System.out.println("Inside area for Triangle");
        return (d1 * d2) / 2;
    }
}

class AbstractDemo {
    public static void main(String[] args) {

        // S s = new S(); // Error: S is abstract, cannot be instantiated
        T t = new T();
        t.call();
        t.call2();

        System.out.println();

        // anonymous subclass — implements abstract method inline
        S s = new S() {
            void call() {
                System.out.println("Call method of an abstract class");
            }
        };
        s.call();

        System.out.println();

        // abstract Figure2 with concrete subclasses
        Rectangle2 r = new Rectangle2(9, 5);
        Triangle2 tr = new Triangle2(10, 8);

        Figure2 ref;
        ref = r;
        System.out.println("Area: " + ref.area());
        ref = tr;
        System.out.println("Area: " + ref.area());
    }
}