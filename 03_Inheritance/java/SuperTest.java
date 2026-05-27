// super() must always be the first statement in a subclass constructor

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
    Box() {
        width = height = depth = 1;
    }

    // cube with given side length
    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }
}

public class SuperTest {
    static class BoxWeightNew extends Box {
        double weight;

        // copy constructor using super
        BoxWeightNew(BoxWeightNew ob) {
            super(ob);
            weight = ob.weight;
        }

        BoxWeightNew(double w, double h, double d, double m) {
            super(w, h, d); // calls Box(double, double, double)
            weight = m;
        }

        BoxWeightNew() {
            super(); // must be first statement
            weight = 1;
        }

        BoxWeightNew(double len, double m) {
            super(len); // calls Box(double)
            weight = m;
        }

        void print() {
            System.out.println("Box(" + width + ", " + height + ", " + depth + ", " + weight + ")");
        }
    }

    public static void main(String[] args) {
        BoxWeightNew box1 = new BoxWeightNew(10, 20, 15, 34.3);
        BoxWeightNew box2 = new BoxWeightNew(2, 3, 4, 0.076);
        BoxWeightNew box3 = new BoxWeightNew();
        BoxWeightNew cube = new BoxWeightNew(3, 2);
        BoxWeightNew clone = new BoxWeightNew(box1);

        box1.print();
        box2.print();
        box3.print();
        cube.print();
        clone.print();
    }
}