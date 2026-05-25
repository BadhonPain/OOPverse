#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

class Student {
public:
    std::string name;
    double grade;

    Student(const std::string& n, double g) : name(n), grade(g) {}
};

int main() {
    std::vector<Student> students = {
        Student("Alice", 85.5),
        Student("Bob", 62.0),
        Student("Charlie", 95.0),
        Student("David", 74.5),
        Student("Eva", 90.0)
    };

    // 1. std::for_each with a basic lambda
    std::cout << "--- Initial Student List ---\n";
    std::for_each(students.begin(), students.end(), [](const Student& s) {
        std::cout << "  " << s.name << " : " << s.grade << "\n";
    });

    // 2. std::sort with custom lambda comparator
    std::sort(students.begin(), students.end(), [](const Student& a, const Student& b) {
        return a.grade > b.grade;
    });

    std::cout << "\n--- Sorted by Grade (Descending) ---\n";
    for (const auto& s : students) {
        std::cout << "  " << s.name << " : " << s.grade << "\n";
    }

    // 3. std::find_if with lambda capturing by value
    double passingLimit = 75.0;
    auto it = std::find_if(students.begin(), students.end(), [passingLimit](const Student& s) {
        return s.grade >= passingLimit;
    });
    if (it != students.end()) {
        std::cout << "\nFirst passing student (>= 75): " << it->name << " (" << it->grade << ")\n";
    }

    // 4. std::transform with lambda capturing by reference
    double extraCredit = 5.0;
    std::transform(students.begin(), students.end(), students.begin(), [&extraCredit](Student s) {
        s.grade = std::min(100.0, s.grade + extraCredit);
        return s;
    });

    std::cout << "\n--- Grades After Extra Credit ---\n";
    for (const auto& s : students) {
        std::cout << "  " << s.name << " : " << s.grade << "\n";
    }

    return 0;
}
