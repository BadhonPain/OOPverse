#include <iostream>
using namespace std;

class Date
{
    int day, month, year;

public:
    Date(char *str);
    Date(int d, int m, int y)
    {
        day = d;
        month = m;
        year = y;
    }
    void showDate()
    {
        cout << "Date is: ";
        cout << day << "/" << month << "/" << year << endl;
    }
};

Date::Date(char *str)
{
    sscanf(str, "%d%*c%d%*c%d%c", &day, &month, &year);
}
int main()
{
    Date sdate("08/12/2006");
    Date idate(8, 12, 2006);
    sdate.showDate();
    idate.showDate();
}