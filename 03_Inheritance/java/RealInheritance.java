class Box {
    double width, height, depth;

    // copy constructor
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // default cube with side 1
    Box() { width = height = depth = 1; }

    // cube with given side length
    Box(double len) { width = height = depth = len; }

    double volume() { return width * height * depth; }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight(double w, double h, double d, double m) {
        width = w; height = h; depth = d; weight = m;
    }
}

public class RealInheritance {
    public static void main(String[] args) {
        BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
        System.out.println(weightBox.weight);

        // superclass reference can point to subclass object
        Box plainBox = weightBox; // OK
        System.out.println(plainBox.volume()); // OK, volume() is in Box
        // System.out.println(plainBox.weight); // Error: weight not in Box

        Box box = new Box(1, 2, 3); // OK
        // BoxWeight wbox = box; // Error: can't assign Box ref to BoxWeight
    }
}