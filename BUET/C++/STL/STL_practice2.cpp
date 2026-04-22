#include <iostream>
#include <map>
#include <algorithm>
#include <vector>
using namespace std;
// STL_practice3.cpp is also this question but it is a little bit smarter
class st_record
{
    string name;
    double cgpa;

public:
    st_record() {}
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

    vector<pair<int, st_record>> v(result.begin(), result.end());
    sort(v.begin(), v.end(), [](const pair<int, st_record> &p1, const pair<int, st_record> &p2)
         { return p1.second.getGpa() > p2.second.getGpa(); });

    vector<pair<int, st_record>>::iterator it;
    it = v.begin();
    cout << "Student No: " << it->first << endl;
    it->second.display();
}