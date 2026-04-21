
public class Book {
    public String title;
    public double finePerLateDay;

    public Book(String title, double fine)
    {
       this.title = title;
       finePerLateDay = fine;
    }

    public String getTitle()
    {
        return title;
    }

    public double getFine()
    {
        return finePerLateDay;
    }
}
