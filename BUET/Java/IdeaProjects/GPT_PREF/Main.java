
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numMembers = Integer.parseInt(args[0]);
        int numBooks = Integer.parseInt(args[1]);

        Book[] books = new Book[numBooks];
        Member[] members = new Member[numMembers];

     
        for (int i = 0; i < numBooks; i++) {
            String title = sc.next();
            double fine = sc.nextDouble();
            books[i] = new Book(title, fine);
        }

        for (int i = 0; i < numMembers; i++) {
            String name = sc.next();
            members[i] = new Member(name, numBooks);

            for (int j = 0; j < numBooks; j++) {
                int days;
                while (true) {
                    days = sc.nextInt();
                    if (days >= 0) break;
                    System.out.println("Invalid input, enter again:");
                }
                members[i].setLateDay(j, days);
            }

            members[i].calculateFine(books);
        }

        Library lib = new Library(members, books);

        while (true) {
            String cmd = sc.next();

            if (cmd.equals("exit")) break;

            else if (cmd.equals("show")) {
                String name = sc.next();
                lib.show(name);
            }

            else if (cmd.equals("remove")) {
                String name = sc.next();
                lib.remove(name);
            }

            else if (cmd.equals("maxfine")) {
                lib.maxFine();
            }
        }

        sc.close();
    }
}
