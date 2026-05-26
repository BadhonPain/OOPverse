#include <iostream>
using namespace std;

class Person
{
    string name;
    int age;

public:
    Person() {}
    Person(string name, int age)
    {
        this->name = name;
        this->age = age;
    }

    void display()
    {
        cout << "Name: " << name << "\nAge: " << age << endl;
    }
};

class Student : public Person
{
    int id;
    double gpa;

public:
    Student(string name, int age, int id, double gpa) : Person(name, age)
    {
        this->id = id;
        this->gpa = gpa;
    }

    void display()
    {
        Person::display();
        cout << "ID: " << id << "\nGPA: " << gpa << endl;
    }
};

int main()
{
    Student s("Badhon", 20, 123, 3.75);
    s.display();
    return 0;
}