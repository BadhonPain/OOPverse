#include <iostream>
#include <cmath>
#include <cstring>
using namespace std;
// TF: 23-24
class Coord {
public:
    int x, y;

    Coord(int x = 0, int y = 0) {
        this->x = (x > 0 && x <= 200) ? x : 0;
        this->y = (y > 0 && y <= 200) ? y : 0;
    }
};

class Rectangle {
private:
    Coord p1, p2, p3, p4;
    char* name;

    double dist(Coord a, Coord b) const {
        return sqrt(pow(a.x - b.x, 2) + pow(a.y - b.y, 2));
    }

public:
    Rectangle(Coord c1, Coord c2, Coord c3, Coord c4, const char* n)
        : p1(c1), p2(c2), p3(c3), p4(c4) {
        name = new char[strlen(n) + 1];
        strcpy(name, n);
    }

    static bool isRightAngle(Coord a, Coord b, Coord c) {
        int v1x = a.x - b.x;
        int v1y = a.y - b.y;
        int v2x = c.x - b.x;
        int v2y = c.y - b.y;
        return (v1x * v2x + v1y * v2y) == 0;
    }

    double getWidth() const {
        return dist(p1, p2);
    }

    double getLength() const {
        double d1 = dist(p1, p2);
        double d2 = dist(p2, p3);
        return (d1 > d2) ? d1 : d2;
    }

    double getArea() const {
        return getWidth() * dist(p2, p3);
    }

    double getPerimeter() const {
        return 2 * (getWidth() + dist(p2, p3));
    }

    bool isSquare() const {
        return abs(getWidth() - dist(p2, p3)) < 0.001;
    }

    Rectangle(const Rectangle& other)
        : p1(other.p1), p2(other.p2), p3(other.p3), p4(other.p4) {
        name = new char[strlen(other.name) + 1];
        strcpy(name, other.name);
    }

    operator int() const {
        return (int)getArea();
    }

    operator string() const {
        return string(name);
    }

    ~Rectangle() {
        delete[] name;
    }
};

int main() {
    Coord c1(10, 10), c2(10, 20), c3(20, 20), c4(20, 10);
    Rectangle r1(c1, c2, c3, c4, "Rect1");

    cout << r1.getArea() << endl;
    cout << r1.getPerimeter() << endl;
    cout << r1.isSquare() << endl;

    Rectangle r2 = r1;

    int area = r1;
    string name = r1;

    cout << area << endl;
    cout << name << endl;

    return 0;
}