#include <iostream>
#include <map>
#include <algorithm>
#include <vector>
using namespace std;
// TF: 22-23
class st_record
{
    string name;
    double cgpa;

public:
    st_record(string name, double cgpa) : name(name), cgpa(cgpa) {}

    double getGpa() const
    {
        return cgpa;
    }

    void display() const
    {
        cout << "Name: " << name << "\nCGPA: " << cgpa << endl;
    }
};

int main()
{
    map<int, st_record> result;
    result.insert(pair<int, st_record>(87, st_record("Badhon", 5.00)));
    result.insert(pair<int, st_record>(43, st_record("Pain", 4.73)));
    result.insert(pair<int, st_record>(10, st_record("Maitri", 4.25)));
    result.insert(pair<int, st_record>(8, st_record("King", 6.24)));
    result.insert(pair<int, st_record>(1, st_record("Badol", 5.00)));

    map<int, st_record>::iterator it;
    map<int, st_record>::iterator maxIt = result.begin();

    for (auto it = result.begin(); it != result.end(); ++it)
    {
        if (it->second.getGpa() > maxIt->second.getGpa())
            maxIt = it;
    }

    cout << "Student No: " << maxIt->first << endl;
    maxIt->second.display();
}