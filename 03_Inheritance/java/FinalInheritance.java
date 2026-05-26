// Using final with Inheritance — slide 101

// final method: cannot be overridden by subclass
class A {
    final void f() {
        System.out.println("This is a final method.");
    }
}

class B extends A {
    // void f() { ... } // Error: cannot override final method
}

// final class: cannot be subclassed at all
final class FinalClass {
    // ...
}

// class CannotExtend extends FinalClass { } // Error: cannot subclass a final class

public class FinalInheritance {
    public static void main(String[] args) {
        B obj = new B();
        obj.f(); // calls A's final method
    }
}