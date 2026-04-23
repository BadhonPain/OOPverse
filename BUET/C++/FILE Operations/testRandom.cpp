#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Badhon {
private:
    string goal = "Top Tech Company";
    int persistence = 100;
    int consistency = 90;
    int curiosity = 95;

public:
    void study() {
        consistency += 5;
        cout << "Studying... consistency now: " << consistency << endl;
    }

    void struggle() {
        persistence += 10;
        cout << "Struggling but not quitting... persistence now: " << persistence << endl;
    }

    void solveProblem(string problem) {
        cout << "Solving: " << problem << endl;
        curiosity += 2;
        consistency += 3;
    }

    void reflect() {
        cout << "Thinking deeply about concepts..." << endl;
        curiosity += 5;
    }

    void status() {
        cout << "\n--- Current Status ---" << endl;
        cout << "Goal: " << goal << endl;
        cout << "Persistence: " << persistence << endl;
        cout << "Consistency: " << consistency << endl;
        cout << "Curiosity: " << curiosity << endl;
    }

    void future() {
        if (persistence > 120 && consistency > 80) {
            cout << "\nOutcome: Dream achieved 🚀" << endl;
        } else {
            cout << "\nOutcome: Still grinding... (and that's okay)" << endl;
        }
    }
};

int main() {
    Badhon man;

    vector<string> problems = {
        "Templates",
        "STL Bugs",
        "File Handling",
        "Java Enums",
        "Manipulators"
    };

    for (auto p : problems) {
        man.solveProblem(p);
    }

    man.study();
    man.struggle();
    man.reflect();

    man.status();
    man.future();

    return 0;
}