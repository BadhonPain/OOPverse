#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    ifstream in;
    ofstream out;
    // Open test3.cpp for output, append if it exists
    fstream out2("test3.cpp", ios::out | ios::app);
    char ch;

    try
    {
        // Open the source file
        in.open("test.cpp");
        if (!in)
            throw "Cannot open input file";

        // Open the first output file
        out.open("test2.cpp", ios::out);
        if (!out)
            throw "Cannot open output file";

        // --- THE SEQUENTIAL COPY PROCESS ---
        in.get(ch); // Priming read
        while (!in.eof())
        {
            out.put(ch);  // Write to file 1
            out2.put(ch); // Write to file 2
            in.get(ch);   // Read next character
        }

        // Checking state
        if (in.is_open())
        {
            cout << "Finished reading file." << endl;
        }

        // Cleanup
        in.close();
        out.close();
        out2.close();

        if (in.is_open())
            cout << "File is still exists after closing" << endl;
        else
            cout << "File Closed." << endl;
    }
    catch (const char *message)
    {
        cout << "Error: " << message << endl;
        return 1;
    }

    return 0;
}