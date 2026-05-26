#include <iostream>
using namespace std;

class Animal
{
public:
    virtual void print()
    {
        cout << "Animal" << endl;
    }
};
class Dog : public Animal
{
public:
    void print()
    {
        cout << "Dog" << endl;
    }
};

class Cat : public Animal
{
public:
    void print()
    {
        cout << "Cat" << endl;
    }
};

class MyClass
{
    public:
    void print()
    {
        cout<<"Myclass"<<endl;
    }
};

int main()
{
    Animal* animal = new Animal;
    Dog* dog = new Dog;
    Cat * cat = new Cat;

    animal->print();
    animal = dynamic_cast<Animal*>(dog);
    animal->print();
    animal = dynamic_cast<Animal*>(cat);
    animal->print();

    MyClass* myClass = dynamic_cast<MyClass*>(animal);
    if(myClass==nullptr) cout<<"Invalid Conversion !"<<endl;
    myClass->print();
}
