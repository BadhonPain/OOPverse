// Abstract class polymorphism: a payment processing system
import java.util.ArrayList;
import java.util.List;

public class AbstractPayment {

    static abstract class Payment {
        String holder;
        double amount;

        Payment(String holder, double amount) {
            this.holder = holder;
            this.amount = amount;
        }

        abstract boolean authorize();
        abstract String paymentType();

        void process() {
            System.out.printf("  Processing %s for %s: $%.2f -> %s%n",
                paymentType(), holder, amount, authorize() ? "APPROVED" : "DECLINED");
        }
    }

    static class CreditCard extends Payment {
        String cardNumber;

        CreditCard(String holder, double amount, String cardNumber) {
            super(holder, amount);
            this.cardNumber = cardNumber;
        }

        boolean authorize() { return amount <= 5000; }
        String paymentType() { return "CreditCard"; }

        void process() {
            String masked = "****-" + cardNumber.substring(cardNumber.length() - 4);
            System.out.printf("  [%s] ", masked);
            super.process();
        }
    }

    static class PayPal extends Payment {
        String email;

        PayPal(String holder, double amount, String email) {
            super(holder, amount);
            this.email = email;
        }

        boolean authorize() { return amount <= 10000 && email.contains("@"); }
        String paymentType() { return "PayPal"; }
    }

    static class BankTransfer extends Payment {
        String routingNumber;

        BankTransfer(String holder, double amount, String routing) {
            super(holder, amount);
            this.routingNumber = routing;
        }

        boolean authorize() { return amount > 0; }
        String paymentType() { return "BankTransfer"; }
    }

    static class Crypto extends Payment {
        String walletAddress;

        Crypto(String holder, double amount, String wallet) {
            super(holder, amount);
            this.walletAddress = wallet;
        }

        boolean authorize() { return walletAddress.startsWith("0x") && amount > 0; }
        String paymentType() { return "Crypto"; }
    }

    static double processAll(List<Payment> payments) {
        double total = 0;
        for (Payment p : payments) {
            p.process();
            if (p.authorize()) total += p.amount;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== Abstract Payment System ===\n");

        List<Payment> payments = new ArrayList<>();
        payments.add(new CreditCard("Alice", 250.00, "4532015112830366"));
        payments.add(new CreditCard("Bob", 7500.00, "6011514433546201"));
        payments.add(new PayPal("Charlie", 89.99, "charlie@email.com"));
        payments.add(new PayPal("Dave", 500.00, "invalid-email"));
        payments.add(new BankTransfer("Eve", 15000.00, "021000021"));
        payments.add(new Crypto("Frank", 1200.00, "0xABC123DEF456"));
        payments.add(new Crypto("Grace", 300.00, "INVALID_WALLET"));

        double approved = processAll(payments);
        System.out.printf("%n  Total approved: $%.2f%n", approved);

        System.out.println("\n--- Polymorphic type identification ---");
        for (Payment p : payments) {
            System.out.printf("  %-10s is-a Payment: %b, actual: %s%n",
                p.holder, p instanceof Payment, p.getClass().getSimpleName());
        }
    }
}
