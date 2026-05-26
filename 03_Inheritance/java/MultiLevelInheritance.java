public class MultiLevelInheritance {

    // Grandparent
    static class Vehicle {
        protected String make;
        protected int year;

        Vehicle(String make, int year) {
            this.make = make;
            this.year = year;
            System.out.println("  [Vehicle] constructor");
        }

        void start() {
            System.out.println(make + ": Vehicle starting...");
        }

        void stop() {
            System.out.println(make + ": Vehicle stopping...");
        }

        String info() {
            return make + " (" + year + ")";
        }
    }

    // Parent
    static class Car extends Vehicle {
        protected int doors;

        Car(String make, int year, int doors) {
            super(make, year);
            this.doors = doors;
            System.out.println("  [Car] constructor");
        }

        @Override
        void start() {
            System.out.println(make + ": Turn key, engine roars!");
        }

        void honk() {
            System.out.println(make + ": Beep beep!");
        }

        @Override
        String info() {
            return super.info() + ", " + doors + "-door";
        }
    }

    // Child
    static class ElectricCar extends Car {
        private int batteryCapacity;
        private int chargePercent;

        ElectricCar(String make, int year, int doors, int batteryKwh) {
            super(make, year, doors);
            this.batteryCapacity = batteryKwh;
            this.chargePercent = 100;
            System.out.println("  [ElectricCar] constructor");
        }

        @Override
        void start() {
            System.out.println(make + ": Silent electric start. Battery: " + chargePercent + "%");
        }

        void charge() {
            chargePercent = 100;
            System.out.println(make + ": Fully charged! " + batteryCapacity + " kWh");
        }

        void drive(int km) {
            int drain = km / 5;
            chargePercent = Math.max(0, chargePercent - drain);
            System.out.printf("%s: Drove %d km. Battery: %d%%%n", make, km, chargePercent);
        }

        @Override
        String info() {
            return super.info() + ", " + batteryCapacity + "kWh, charge=" + chargePercent + "%";
        }
    }

    // Another branch from Car
    static class SportsCar extends Car {
        private int horsepower;

        SportsCar(String make, int year, int hp) {
            super(make, year, 2);
            this.horsepower = hp;
            System.out.println("  [SportsCar] constructor");
        }

        @Override
        void start() {
            super.start();
            System.out.println(make + ": " + horsepower + "hp engine ROARS!");
        }

        void turboBoost() {
            System.out.println(make + ": TURBO BOOST! " + (horsepower * 1.3) + "hp!");
        }

        @Override
        String info() {
            return super.info() + ", " + horsepower + "hp";
        }
    }

    public static void main(String[] args) {
        // Constructor chain: Vehicle -> Car -> ElectricCar
        System.out.println("=== Constructor Chain ===");
        ElectricCar tesla = new ElectricCar("Tesla Model 3", 2024, 4, 75);

        System.out.println("\n=== ElectricCar Methods ===");
        tesla.start();     // ElectricCar's override
        tesla.honk();      // Inherited from Car
        tesla.drive(150);  // ElectricCar's own
        tesla.drive(200);
        tesla.charge();
        tesla.stop();      // Inherited from Vehicle
        System.out.println("Info: " + tesla.info());

        // SportsCar branch
        System.out.println("\n=== SportsCar ===");
        SportsCar ferrari = new SportsCar("Ferrari F40", 1992, 478);
        System.out.println();
        ferrari.start();
        ferrari.turboBoost();
        ferrari.honk();
        System.out.println("Info: " + ferrari.info());

        // Polymorphism across all levels
        System.out.println("\n=== Polymorphism Across Levels ===");
        Vehicle[] garage = {
            new Vehicle("Bicycle", 2020),
            new Car("Toyota Camry", 2023, 4),
            new ElectricCar("Rivian R1T", 2024, 4, 135),
            new SportsCar("Porsche 911", 2024, 450)
        };

        System.out.println();
        for (Vehicle v : garage) {
            System.out.print("[" + v.getClass().getSimpleName() + "] ");
            v.start();
        }

        // Method resolution order
        System.out.println("\n=== Info Chain (super calls) ===");
        for (Vehicle v : garage) {
            System.out.println(v.getClass().getSimpleName() + ": " + v.info());
        }

        // Type checking across hierarchy
        System.out.println("\n=== Type Hierarchy ===");
        ElectricCar ev = new ElectricCar("Nissan Leaf", 2024, 4, 40);
        System.out.println();
        System.out.println("ev instanceof ElectricCar: " + (ev instanceof ElectricCar));
        System.out.println("ev instanceof Car: " + (ev instanceof Car));
        System.out.println("ev instanceof Vehicle: " + (ev instanceof Vehicle));
        System.out.println("ev instanceof Object: " + (ev instanceof Object));
    }
}
