
public class Library {
    private Member[] members;
    private Book[] books;

    public Library(Member[] members, Book[] books) {
        this.members = members;
        this.books = books;
    }

    public void show(String name) {
        if (name.equals("all")) {
            for (Member m : members) {
                if (m != null)
                    m.display(books);
            }
        } else {
            for (Member m : members) {
                if (m != null && m.getName().equals(name)) {
                    m.display(books);
                    return;
                }
            }
            System.out.println("Member not found");
        }
    }

    public void remove(String name) {
        int count = 0;

        for (Member m : members) {
            if (m != null && !m.getName().equals(name)) {
                count++;
            }
        }

        Member[] newArr = new Member[count];
        int idx = 0;

        for (Member m : members) {
            if (m != null && !m.getName().equals(name)) {
                newArr[idx++] = m;
            }
        }

        members = newArr;
    }

    public void maxFine() {
        if (members.length == 0)
            return;

        Member max = members[0];

        for (Member m : members) {
            if (m != null && m.getTotalFine() > max.getTotalFine()) {
                max = m;
            }
        }

        System.out.println("Max Fine Member:");
        max.display(books);
    }
}
