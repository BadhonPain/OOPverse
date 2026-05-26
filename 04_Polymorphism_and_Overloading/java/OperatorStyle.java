// Java's approach: no operator overloading — use equals(), compareTo(), toString()
import java.util.Arrays;
import java.util.Objects;

public class OperatorStyle {

    static class Money implements Comparable<Money> {
        final int cents;
        final String currency;

        Money(double amount, String currency) {
            this.cents = (int) Math.round(amount * 100);
            this.currency = currency;
        }

        Money add(Money other) {
            if (!currency.equals(other.currency))
                throw new IllegalArgumentException("Currency mismatch: " + currency + " vs " + other.currency);
            return new Money(0, currency) {{ }};
        }

        Money plus(Money other) {
            if (!currency.equals(other.currency))
                throw new IllegalArgumentException("Currency mismatch");
            Money result = new Money(0, currency);
            return new Money((cents + other.cents) / 100.0, currency);
        }

        Money minus(Money other) {
            if (!currency.equals(other.currency))
                throw new IllegalArgumentException("Currency mismatch");
            return new Money((cents - other.cents) / 100.0, currency);
        }

        Money times(double factor) {
            return new Money((cents * factor) / 100.0, currency);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Money m)) return false;
            return cents == m.cents && currency.equals(m.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cents, currency);
        }

        @Override
        public int compareTo(Money other) {
            if (!currency.equals(other.currency))
                throw new IllegalArgumentException("Cannot compare different currencies");
            return Integer.compare(cents, other.cents);
        }

        @Override
        public String toString() {
            return String.format("%s %.2f", currency, cents / 100.0);
        }
    }

    static class Vector2D {
        final double x, y;

        Vector2D(double x, double y) { this.x = x; this.y = y; }

        Vector2D plus(Vector2D v) { return new Vector2D(x + v.x, y + v.y); }
        Vector2D minus(Vector2D v) { return new Vector2D(x - v.x, y - v.y); }
        Vector2D scale(double s) { return new Vector2D(x * s, y * s); }
        double dot(Vector2D v) { return x * v.x + y * v.y; }
        double magnitude() { return Math.sqrt(x * x + y * y); }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Vector2D v)) return false;
            return Double.compare(x, v.x) == 0 && Double.compare(y, v.y) == 0;
        }

        @Override
        public int hashCode() { return Objects.hash(x, y); }

        @Override
        public String toString() { return String.format("(%.1f, %.1f)", x, y); }
    }

    public static void main(String[] args) {
        System.out.println("=== Java Operator Style ===\n");

        // Money: equals() instead of ==
        System.out.println("--- Money (equals, compareTo, toString) ---");
        Money a = new Money(29.99, "USD");
        Money b = new Money(15.50, "USD");
        Money c = new Money(29.99, "USD");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a.equals(c)      = " + a.equals(c));
        System.out.println("a == c            = " + (a == c) + "  (reference, not value!)");
        System.out.println("a.compareTo(b)    = " + a.compareTo(b) + "  (positive = a > b)");
        System.out.println("a.plus(b)         = " + a.plus(b));
        System.out.println("a.minus(b)        = " + a.minus(b));
        System.out.println("a.times(3)        = " + a.times(3));

        // Sorting with compareTo
        System.out.println("\n--- Sorting with Comparable ---");
        Money[] prices = {
            new Money(99.99, "USD"), new Money(5.00, "USD"),
            new Money(42.50, "USD"), new Money(12.75, "USD")
        };
        Arrays.sort(prices);
        System.out.print("Sorted: ");
        for (Money m : prices) System.out.print(m + "  ");
        System.out.println();

        // Vector2D: method-based "operators"
        System.out.println("\n--- Vector2D (method-based arithmetic) ---");
        Vector2D v1 = new Vector2D(3, 4);
        Vector2D v2 = new Vector2D(1, 2);

        System.out.println("v1           = " + v1);
        System.out.println("v2           = " + v2);
        System.out.println("v1.plus(v2)  = " + v1.plus(v2));
        System.out.println("v1.minus(v2) = " + v1.minus(v2));
        System.out.println("v1.scale(2)  = " + v1.scale(2));
        System.out.println("v1.dot(v2)   = " + v1.dot(v2));
        System.out.println("v1.magnitude = " + String.format("%.2f", v1.magnitude()));
        System.out.println("v1.equals(v1)= " + v1.equals(new Vector2D(3, 4)));

        // String comparison reminder
        System.out.println("\n--- String: equals() vs == ---");
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println("s1 == s2       = " + (s1 == s2) + "   (reference check)");
        System.out.println("s1.equals(s2)  = " + s1.equals(s2) + "  (value check)");
        System.out.println("s1.compareTo(s2) = " + s1.compareTo(s2));
    }
}
