class C {
    int i;

    void show() {
        System.out.println("i in superclass: " + i);
    }
}

class D extends C {
    int i; // this i hides the i in C

    D(int a, int b) {
        super.i = a; // sets i in C
        i = b;       // sets i in D
    }

    void show() {
        System.out.println("i in superclass: " + super.i);
        System.out.println("i in subclass: " + i);
        super.show(); // calls show() from C
    }
}

public class UseSuper {
    public static void main(String[] args) {
        D subOb = new D(1, 2);
        subOb.show();
    }
}