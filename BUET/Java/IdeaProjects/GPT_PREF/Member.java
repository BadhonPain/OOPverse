

public class Member {
    private String name;
    private int[] lateDays;
    private double[] fines;
    private double totalFine;

    public Member(String name, int n) {
        this.name = name;
        lateDays = new int[n];
        fines = new double[n];
        totalFine = 0;
    }

    public String getName() {
        return name;
    }

    public double getTotalFine() {
        return totalFine;
    }

    public void setLateDay(int idx, int d) {
        lateDays[idx] = d;
    }

    public void calculateFine(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            fines[i] = lateDays[i] * books[i].getFine();
            totalFine += fines[i];
        }
    }

    public void display(Book[] books) {
        System.out.println("Member: " + name);

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle() + " Fine: " + fines[i]);
        }

        System.out.println("Total Fine: " + totalFine);
    }
}
