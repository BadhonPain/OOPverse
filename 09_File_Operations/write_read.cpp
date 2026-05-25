#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    // WRITING TO FILE 
    try {
        ofstream out("Inventory.txt", ios::app);
        if (!out) throw "Cannot open output file";

        out << "Radios " << 39 << endl;
        out << "Toasters " << 21 << endl;
        out << "Mixers " << 17 << endl;

        out.close(); // Always close the pipe when done
    } catch (const char* message) {
        cout << "Error: " << message << endl;
        return 1;
    }

    // READING FORMATTED DATA 
    try {
        ifstream in("Inventory.txt");
        ofstream out2("Temp.txt");
        if (!in || !out2) throw "Cannot open input file";

        string item;
        int quantity;

        cout << "--- Writing this in Temp ---" << endl;
        in >> item >> quantity; // Read first pair
        while (!in.eof()) {
            cout<< item << " " << quantity << endl;
            out2 << item << " " << quantity << endl; // writing in Temp.txt
            in >> item >> quantity; // Read next pair
        }
        in.close();
    } catch (const char* message) {
        cout << "Error: " << message << endl;
        return 1;
    }

    // READING CHARACTER BY CHARACTER 
    cout << "\n--- Reading character by character ---" << endl;
    ifstream inChar("Inventory.txt");
    char ch;
    
    // Using >> will skip whitespace, simply 'operator >> eats WS(whitespaces)' 
    inChar >> ch; 
    while (!inChar.eof()) {
        cout << ch;
        inChar>>ch;
    }
    inChar.close();

    return 0;
}