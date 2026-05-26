public class SingleInheritance {

    static class Animal {
        protected String name;
        protected int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("  Animal constructor: " + name);
        }

        void eat() {
            System.out.println(name + " is eating.");
        }

        void sleep() {
            System.out.println(name + " is sleeping.");
        }

        String describe() {
            return String.format("%s (age %d)", name, age);
        }

        @Override
        public String toString() {
            return "Animal{" + describe() + "}";
        }
    }

    static class Dog extends Animal {
        private String breed;

        Dog(String name, int age, String breed) {
            super(name, age);  // Must call super() first
            this.breed = breed;
            System.out.println("  Dog constructor: " + breed);
        }

        void bark() {
            System.out.println(name + " says: Woof! Woof!");
        }

        void fetch(String item) {
            System.out.println(name + " fetches the " + item + "!");
        }

        // Overriding parent method
        @Override
        void eat() {
            super.eat();  // Call parent version
            System.out.println(name + " wags tail while eating.");
        }

        @Override
        String describe() {
            return super.describe() + ", breed: " + breed;
        }

        @Override
        public String toString() {
            return "Dog{" + describe() + "}";
        }
    }

    static class Cat extends Animal {
        private boolean indoor;

        Cat(String name, int age, boolean indoor) {
            super(name, age);
            this.indoor = indoor;
            System.out.println("  Cat constructor: indoor=" + indoor);
        }

        void purr() {
            System.out.println(name + " purrs contentedly.");
        }

        @Override
        void eat() {
            System.out.println(name + " eats delicately.");
        }

        @Override
        public String toString() {
            return String.format("Cat{%s, indoor=%s}", describe(), indoor);
        }
    }

    public static void main(String[] args) {
        // Constructor chain
        System.out.println("=== Constructor Chain ===");
        Dog dog = new Dog("Rex", 5, "German Shepherd");

        System.out.println("\n=== Inherited + Own Methods ===");
        dog.eat();
        dog.sleep();
        dog.bark();
        dog.fetch("ball");

        // Cat
        System.out.println("\n=== Cat ===");
        Cat cat = new Cat("Whiskers", 3, true);
        cat.eat();
        cat.sleep();
        cat.purr();

        // Polymorphism via parent reference
        System.out.println("\n=== Polymorphism (Parent Reference) ===");
        Animal animalRef = new Dog("Buddy", 2, "Labrador");
        animalRef.eat();     // Calls Dog's eat() - runtime polymorphism
        animalRef.sleep();   // Calls Animal's sleep() - inherited
        // animalRef.bark(); // COMPILE ERROR - Animal doesn't know about bark()

        // instanceof and casting
        System.out.println("\n=== instanceof and Casting ===");
        Animal[] animals = {
            new Dog("Max", 4, "Poodle"),
            new Cat("Luna", 2, false),
            new Dog("Rocky", 6, "Bulldog")
        };

        System.out.println();
        for (Animal a : animals) {
            System.out.println(a);
            if (a instanceof Dog d) {  // Pattern matching (Java 16+)
                d.bark();
            } else if (a instanceof Cat c) {
                c.purr();
            }
        }

        // super keyword usage
        System.out.println("\n=== super Keyword ===");
        System.out.println("Dog describe (calls super.describe): " + dog.describe());
    }
}
