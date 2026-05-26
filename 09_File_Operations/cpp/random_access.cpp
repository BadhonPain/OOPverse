#include <iostream>
#include <fstream>

using namespace std;

// This function checks the 'health' of the stream.
// It uses bitwise logic to see if specific error flags are raised.
void showState(ios::iostate state) {  // TF: 20-21
    if (state & ios::goodbit) cout << "goodbit is set" << endl;
    if (state & ios::eofbit)  cout << "eofbit is set" << endl;
    if (state & ios::failbit) cout << "failbit is set" << endl;
    if (state & ios::badbit)  cout << "badbit is set" << endl;
}

int main() {
    // We allocate a buffer to hold data while we jump around the file
    char *str = new char[80];

    ifstream in;
    ofstream out;

    try {
        in.open("testRandom.cpp");      // Open source
        out.open("test2.cpp");    // Open destination

        // 1. TELL: Check where our pointers are currently at (should be 0)
        cout << "getPointer: " << in.tellg() << " putPointer: " << out.tellp() << endl;

        // 2. READ: Read 80 bytes from the source and write to destination
        in.read(str, 80);
        out.write(str, 80);

        // TELL: Check the pointers again. They should have advanced by 80 bytes.
        cout << "getPointer: " << in.tellg() << " putPointer: " << out.tellp() << endl;

        // 3. SEEK: Jump the pointer to the end of the file.
        // ios::end means start from the end, offset 0 means stay there.
        in.seekg(0, ios::end);
        out.seekp(0, ios::end);

        // TELL: Show the new positions
        cout << "getPointer: " << in.tellg() << " putPointer: " << out.tellp() << endl;

        // 4. READ (Triggering EOF): Try to read again from the end.
        in.read(str, 80);
        cout << in.gcount() << " characters read" << endl; // gcount shows how many bytes actually were read

        // TELL: This will return -1 because we hit the end of the file (EOF)
        cout << "getPointer: " << in.tellg() << " putPointer: " << out.tellp() << endl;

        // 5. STATE: Check the flags. Since we hit EOF, eofbit and failbit will be set.
        ios::iostate state = in.rdstate();
        showState(state);

        // 6. CLEAR: Critical step! If we want to keep using the file after hitting EOF, 
        // we must clear the error flags to "revive" the stream.
        in.clear();

        // 7. STATE AGAIN: Now that we cleared, the flags should be back to 'good'
        state = in.rdstate();
        showState(state);

    } catch (const char* message) {
        cout << "Error: " << message << endl;
        return 1;
    }

    // Always clean up dynamic memory
    delete[] str;
    in.close();
    out.close();

    return 0;
}