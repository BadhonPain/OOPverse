public class MethodOverriding {

    static class Notification {
        protected String title;
        protected String message;

        Notification(String title, String message) {
            this.title = title;
            this.message = message;
        }

        void send() {
            System.out.println("[GENERIC] " + title + ": " + message);
        }

        String format() {
            return title + " - " + message;
        }

        // final method - cannot be overridden
        final String getType() {
            return getClass().getSimpleName();
        }
    }

    static class EmailNotification extends Notification {
        private String recipient;

        EmailNotification(String title, String message, String recipient) {
            super(title, message);
            this.recipient = recipient;
        }

        @Override
        void send() {
            System.out.printf("[EMAIL] To: %s | Subject: %s | Body: %s%n",
                    recipient, title, message);
        }

        @Override
        String format() {
            return "EMAIL >> " + super.format() + " >> " + recipient;
        }
    }

    static class SMSNotification extends Notification {
        private String phoneNumber;

        SMSNotification(String title, String message, String phoneNumber) {
            super(title, message);
            this.phoneNumber = phoneNumber;
        }

        @Override
        void send() {
            String truncated = message.length() > 20
                    ? message.substring(0, 20) + "..."
                    : message;
            System.out.printf("[SMS] To: %s | %s: %s%n", phoneNumber, title, truncated);
        }

        @Override
        String format() {
            return "SMS >> " + super.format() + " >> " + phoneNumber;
        }
    }

    static class PushNotification extends Notification {
        private String deviceToken;
        private boolean silent;

        PushNotification(String title, String message, String deviceToken, boolean silent) {
            super(title, message);
            this.deviceToken = deviceToken;
            this.silent = silent;
        }

        @Override
        void send() {
            if (silent) {
                System.out.printf("[PUSH-SILENT] Device: %s | Data: %s%n",
                        deviceToken, message);
            } else {
                System.out.printf("[PUSH] Device: %s | %s: %s%n",
                        deviceToken, title, message);
            }
        }
    }

    // Covariant return type
    static class Builder {
        Builder setOption(String key) {
            System.out.println("Builder.setOption: " + key);
            return this;
        }
    }

    static class AdvancedBuilder extends Builder {
        @Override
        AdvancedBuilder setOption(String key) {  // Covariant return: Builder -> AdvancedBuilder
            System.out.println("AdvancedBuilder.setOption: " + key);
            return this;
        }

        AdvancedBuilder setAdvanced(String key) {
            System.out.println("AdvancedBuilder.setAdvanced: " + key);
            return this;
        }
    }

    // Override vs Overload
    static class Base {
        void process(int x) {
            System.out.println("Base.process(int): " + x);
        }

        void process(String s) {
            System.out.println("Base.process(String): " + s);
        }
    }

    static class Derived extends Base {
        @Override
        void process(int x) {  // OVERRIDE - same signature
            System.out.println("Derived.process(int): " + (x * 2));
        }

        void process(double d) {  // OVERLOAD - different parameter type
            System.out.println("Derived.process(double): " + d);
        }
    }

    public static void main(String[] args) {
        // Runtime polymorphism - method resolved at runtime
        System.out.println("=== Runtime Polymorphism ===");
        Notification[] notifications = {
            new Notification("Alert", "System update available"),
            new EmailNotification("Welcome", "Thanks for joining!", "user@email.com"),
            new SMSNotification("OTP", "Your verification code is 483921", "+1234567890"),
            new PushNotification("Sale", "50% off today!", "device-abc-123", false),
            new PushNotification("Sync", "{data: updated}", "device-xyz-789", true)
        };

        for (Notification n : notifications) {
            n.send();  // Correct override called at runtime
        }

        // super.format() chaining
        System.out.println("\n=== super Keyword in Overrides ===");
        for (Notification n : notifications) {
            System.out.println(n.format());
        }

        // final method cannot be overridden
        System.out.println("\n=== Final Method (getType) ===");
        for (Notification n : notifications) {
            System.out.println("Type: " + n.getType());
        }

        // Covariant return types
        System.out.println("\n=== Covariant Return Type ===");
        AdvancedBuilder ab = new AdvancedBuilder();
        ab.setOption("theme")          // Returns AdvancedBuilder, not Builder
          .setAdvanced("gpu-accel")    // Can chain AdvancedBuilder-specific methods
          .setOption("lang");

        // Override vs Overload
        System.out.println("\n=== Override vs Overload ===");
        Derived d = new Derived();
        d.process(5);         // Override: Derived.process(int)
        d.process("hello");   // Inherited: Base.process(String)
        d.process(3.14);      // Overload: Derived.process(double)

        System.out.println("\nThrough Base reference:");
        Base b = d;
        b.process(5);         // Override still applies (runtime polymorphism)
        b.process("hello");   // Base.process(String)
        // b.process(3.14);   // Calls Base.process(int) via widening, NOT Derived.process(double)

        // @Override annotation importance
        System.out.println("\n=== @Override Annotation ===");
        System.out.println("@Override ensures compile-time check:");
        System.out.println("  - Catches typos in method names");
        System.out.println("  - Catches wrong parameter types");
        System.out.println("  - Documents intent to override");
        System.out.println("  - Required for interface implementation (best practice)");
    }
}
