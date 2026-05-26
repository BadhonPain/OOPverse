// Java has no 'friend' keyword. Package-private (default) access is the closest equivalent.
// Classes in the same file share a compilation unit and can access each other's default members.

public class FriendlyAccess {

    // Package-private class simulating "friend" access
    static class Engine {
        private int rpm = 0;
        private boolean running = false;

        // Package-private methods - accessible by "friend" classes in same package
        void start() {
            running = true;
            rpm = 800;
        }

        void setRpm(int rpm) {
            if (running && rpm >= 0 && rpm <= 8000) {
                this.rpm = rpm;
            }
        }

        void stop() {
            rpm = 0;
            running = false;
        }

        // Public read-only access for everyone
        public int getRpm() { return rpm; }
        public boolean isRunning() { return running; }

        @Override
        public String toString() {
            return String.format("Engine{running=%s, rpm=%d}", running, rpm);
        }
    }

    // Car can access Engine's package-private methods (acting as "friend")
    static class Car {
        private String model;
        private Engine engine;

        Car(String model) {
            this.model = model;
            this.engine = new Engine();
        }

        void drive() {
            System.out.println(model + ": Starting engine...");
            engine.start();
            engine.setRpm(3000);
            System.out.println(model + ": " + engine);
        }

        void park() {
            System.out.println(model + ": Parking...");
            engine.setRpm(800);
            engine.stop();
            System.out.println(model + ": " + engine);
        }
    }

    // Alternative pattern: granting access via inner interface
    static class SecureVault {
        private String secret = "TOP_SECRET_DATA";
        private int accessCount = 0;

        // "Friend key" pattern - only classes that implement FriendAccess can access
        interface FriendKey {}

        // Method only accessible with friend key
        String getSecret(FriendKey key) {
            accessCount++;
            return secret;
        }

        int getAccessCount() { return accessCount; }
    }

    // Trusted class implements the friend key
    static class TrustedAgent implements SecureVault.FriendKey {
        private String name;

        TrustedAgent(String name) { this.name = name; }

        void readVault(SecureVault vault) {
            String data = vault.getSecret(this);
            System.out.println("Agent " + name + " read: " + data);
        }
    }

    // Untrusted class cannot implement FriendKey if it's not visible
    static class UntrustedAgent {
        void tryRead(SecureVault vault) {
            // vault.getSecret(???); // Cannot call - no FriendKey implementation
            System.out.println("UntrustedAgent: Cannot access vault secret!");
        }
    }

    // Another pattern: accessor object
    static class Database {
        private String connectionString = "jdbc:mysql://localhost/prod";

        // Accessor class acts as a controlled gateway
        static class Accessor {
            private static boolean authorized = false;

            static void authorize() { authorized = true; }

            static String getConnectionString(Database db) {
                if (!authorized) throw new SecurityException("Not authorized");
                return db.connectionString;
            }
        }
    }

    public static void main(String[] args) {
        // Package-private "friend" access
        System.out.println("=== Package-Private (Friend-like) Access ===");
        Car car = new Car("Tesla Model 3");
        car.drive();
        car.park();

        // Friend key pattern
        System.out.println("\n=== Friend Key Pattern ===");
        SecureVault vault = new SecureVault();
        TrustedAgent agent1 = new TrustedAgent("Bond");
        TrustedAgent agent2 = new TrustedAgent("Bourne");

        agent1.readVault(vault);
        agent2.readVault(vault);
        System.out.println("Total vault accesses: " + vault.getAccessCount());

        UntrustedAgent untrusted = new UntrustedAgent();
        untrusted.tryRead(vault);

        // Accessor pattern
        System.out.println("\n=== Accessor Pattern ===");
        Database db = new Database();
        try {
            Database.Accessor.getConnectionString(db);
        } catch (SecurityException e) {
            System.out.println("Before auth: " + e.getMessage());
        }
        Database.Accessor.authorize();
        System.out.println("After auth: " + Database.Accessor.getConnectionString(db));

        // Summary
        System.out.println("\n=== Java vs C++ Friend Access ===");
        System.out.println("C++ 'friend': Explicit, per-class/function trust declaration");
        System.out.println("Java alternatives:");
        System.out.println("  1. Package-private (default access) - same package can access");
        System.out.println("  2. Friend Key pattern - interface-based access control");
        System.out.println("  3. Accessor/Gateway pattern - controlled delegation");
        System.out.println("  4. Inner classes - can access outer's private members");
    }
}
