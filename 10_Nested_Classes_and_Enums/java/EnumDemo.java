import java.util.EnumSet;
import java.util.EnumMap;

public class EnumDemo {

    enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6);

        private final double mass;
        private final double radius;

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        double surfaceGravity() {
            final double G = 6.67300E-11;
            return G * mass / (radius * radius);
        }

        double surfaceWeight(double otherMass) {
            return otherMass * surfaceGravity();
        }
    }

    enum Day {
        MONDAY("Work"), TUESDAY("Work"), WEDNESDAY("Work"),
        THURSDAY("Work"), FRIDAY("Work"),
        SATURDAY("Rest"), SUNDAY("Rest");

        private final String type;

        Day(String type) { this.type = type; }

        String getType() { return type; }

        boolean isWeekend() { return type.equals("Rest"); }
    }

    enum Operation {
        ADD("+") {
            public double apply(double a, double b) { return a + b; }
        },
        SUBTRACT("-") {
            public double apply(double a, double b) { return a - b; }
        },
        MULTIPLY("*") {
            public double apply(double a, double b) { return a * b; }
        },
        DIVIDE("/") {
            public double apply(double a, double b) { return a / b; }
        };

        private final String symbol;

        Operation(String symbol) { this.symbol = symbol; }

        public abstract double apply(double a, double b);

        @Override
        public String toString() { return symbol; }
    }

    public static void main(String[] args) {
        System.out.println("=== Enum with Fields & Methods (Planet) ===");
        double earthWeight = 75.0;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("  Weight on %-8s: %6.2f N%n", p, p.surfaceWeight(mass));
        }

        System.out.println("\n=== Enum with Constructor (Day) ===");
        for (Day d : Day.values()) {
            System.out.printf("  %-10s -> %s %s%n", d, d.getType(),
                    d.isWeekend() ? "(Weekend!)" : "");
        }

        System.out.println("\n=== Enum with Abstract Method (Operation) ===");
        double x = 10, y = 3;
        for (Operation op : Operation.values()) {
            System.out.printf("  %.0f %s %.0f = %.2f%n", x, op, y, op.apply(x, y));
        }

        System.out.println("\n=== Enum Built-in Methods ===");
        System.out.println("  Planet.valueOf(\"MARS\"): " + Planet.valueOf("MARS"));
        System.out.println("  Day.FRIDAY.ordinal(): " + Day.FRIDAY.ordinal());
        System.out.println("  Day.FRIDAY.name(): " + Day.FRIDAY.name());
        System.out.println("  Operation.values().length: " + Operation.values().length);

        System.out.println("\n=== EnumSet ===");
        EnumSet<Day> weekdays = EnumSet.of(Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY,
                Day.THURSDAY, Day.FRIDAY);
        EnumSet<Day> weekend = EnumSet.complementOf(weekdays);
        System.out.println("  Weekdays: " + weekdays);
        System.out.println("  Weekend:  " + weekend);

        EnumSet<Day> workFromHome = EnumSet.of(Day.MONDAY, Day.FRIDAY);
        System.out.println("  WFH days: " + workFromHome);

        System.out.println("\n=== EnumMap ===");
        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);
        schedule.put(Day.MONDAY, "Team standup");
        schedule.put(Day.WEDNESDAY, "Code review");
        schedule.put(Day.FRIDAY, "Sprint demo");
        schedule.put(Day.SATURDAY, "Relax");
        for (var entry : schedule.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
