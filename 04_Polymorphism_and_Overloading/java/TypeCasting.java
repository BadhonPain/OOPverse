// Widening/narrowing casts, instanceof checks, and pattern matching
public class TypeCasting {

    static class Animal {
        String speak() { return "..."; }
    }

    static class Dog extends Animal {
        String speak() { return "Woof!"; }
        void fetch() { System.out.println("  Dog fetches the ball!"); }
    }

    static class Cat extends Animal {
        String speak() { return "Meow!"; }
        void purr() { System.out.println("  Cat is purring..."); }
    }

    static void identifyAnimal(Animal a) {
        if (a instanceof Dog d) {
            System.out.println("  It's a Dog: " + d.speak());
            d.fetch();
        } else if (a instanceof Cat c) {
            System.out.println("  It's a Cat: " + c.speak());
            c.purr();
        } else {
            System.out.println("  Unknown animal: " + a.speak());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Type Casting ===\n");

        // Primitive widening (implicit)
        System.out.println("--- Primitive Widening (implicit) ---");
        int i = 42;
        long l = i;
        float f = l;
        double d = f;
        System.out.println("  int=" + i + " -> long=" + l + " -> float=" + f + " -> double=" + d);

        // Primitive narrowing (explicit cast required)
        System.out.println("\n--- Primitive Narrowing (explicit) ---");
        double pi = 3.14159;
        int truncated = (int) pi;
        byte small = (byte) 300;  // overflow
        System.out.println("  (int) 3.14159 = " + truncated);
        System.out.println("  (byte) 300    = " + small + "  [overflow!]");

        // Reference upcasting (implicit)
        System.out.println("\n--- Reference Upcasting (implicit) ---");
        Dog dog = new Dog();
        Animal animal = dog;  // upcasting
        System.out.println("  animal.speak() = " + animal.speak());

        // Reference downcasting (explicit, with safety check)
        System.out.println("\n--- Reference Downcasting (explicit) ---");
        if (animal instanceof Dog) {
            Dog downcast = (Dog) animal;
            downcast.fetch();
        }

        // Unsafe downcast demo
        System.out.println("\n--- Unsafe Downcast (ClassCastException) ---");
        Animal genericAnimal = new Cat();
        try {
            Dog wrongCast = (Dog) genericAnimal;
        } catch (ClassCastException e) {
            System.out.println("  Caught: " + e.getMessage());
        }

        // Pattern matching instanceof (Java 16+)
        System.out.println("\n--- Pattern Matching instanceof ---");
        Animal[] animals = { new Dog(), new Cat(), new Animal() };
        for (Animal a : animals) {
            identifyAnimal(a);
        }

        // Numeric casting precision loss
        System.out.println("\n--- Precision Loss ---");
        long bigNum = 123456789012345L;
        float asFloat = bigNum;
        System.out.println("  long:  " + bigNum);
        System.out.println("  float: " + (long) asFloat + "  [precision lost]");
    }
}
