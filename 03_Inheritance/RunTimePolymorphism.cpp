#include <iostream>
using namespace std;

class Animal
{
public:
    Animal() {}

    virtual void makeSound()
    {
        cout << "From Animal" << endl;
    }

    virtual ~Animal()
    {
        cout << "Animal Destructing..." << endl;
    }
};

class Dog : public Animal
{
public:
    void makeSound()
    {
        cout << "Dog: Bark" << endl;
    }

    ~Dog()
    {
        cout << "Dog Destructing..." << endl;
    }
};

class Cat : public Animal
{
public:
    void makeSound()
    {
        cout << "Cat: Meow" << endl;
    }
    ~Cat()
    {
        cout << "Cat Destructing..." << endl;
    }
};

int main()
{
    Animal *a1 = new Dog();
    a1->makeSound();
    Animal *a2 = new Cat();
    a2->makeSound();

    delete a1;
    delete a2;
}