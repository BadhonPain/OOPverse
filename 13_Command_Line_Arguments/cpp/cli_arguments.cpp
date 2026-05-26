#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

struct Config {
    string name = "";
    int count = 1;
    bool verbose = false;
    bool help = false;
    vector<string> files;
};

void printUsage(const string& program) {
    cout << "Usage: " << program << " [options] [files...]" << endl;
    cout << "Options:" << endl;
    cout << "  -n, --name <name>   Set the name" << endl;
    cout << "  -c, --count <num>   Set repeat count (default: 1)" << endl;
    cout << "  -v, --verbose       Enable verbose output" << endl;
    cout << "  -h, --help          Show this help message" << endl;
}

Config parseArgs(int argc, char* argv[]) {
    Config config;

    for (int i = 1; i < argc; i++) {
        string arg = argv[i];

        if (arg == "-h" || arg == "--help") {
            config.help = true;
        } else if (arg == "-v" || arg == "--verbose") {
            config.verbose = true;
        } else if (arg == "-n" || arg == "--name") {
            if (i + 1 < argc) {
                config.name = argv[++i];
            } else {
                cerr << "Error: " << arg << " requires a value" << endl;
            }
        } else if (arg == "-c" || arg == "--count") {
            if (i + 1 < argc) {
                try {
                    config.count = stoi(argv[++i]);
                } catch (...) {
                    cerr << "Error: Invalid number for --count" << endl;
                }
            } else {
                cerr << "Error: " << arg << " requires a value" << endl;
            }
        } else if (arg[0] == '-') {
            cerr << "Warning: Unknown option '" << arg << "'" << endl;
        } else {
            config.files.push_back(arg);
        }
    }
    return config;
}

int main(int argc, char* argv[]) {
    cout << "=== Command Line Arguments Demo ===" << endl;

    cout << "\n--- Raw Arguments ---" << endl;
    cout << "argc = " << argc << endl;
    for (int i = 0; i < argc; i++) {
        cout << "  argv[" << i << "] = \"" << argv[i] << "\"" << endl;
    }

    Config config = parseArgs(argc, argv);

    if (config.help) {
        cout << "\n--- Help ---" << endl;
        printUsage(argv[0]);
        return 0;
    }

    cout << "\n--- Parsed Configuration ---" << endl;
    cout << "  Name:    " << (config.name.empty() ? "(not set)" : config.name) << endl;
    cout << "  Count:   " << config.count << endl;
    cout << "  Verbose: " << (config.verbose ? "yes" : "no") << endl;
    cout << "  Files:   ";
    if (config.files.empty()) {
        cout << "(none)";
    } else {
        for (size_t i = 0; i < config.files.size(); i++) {
            if (i > 0) cout << ", ";
            cout << config.files[i];
        }
    }
    cout << endl;

    if (!config.name.empty()) {
        cout << "\n--- Output ---" << endl;
        for (int i = 0; i < config.count; i++) {
            cout << "  Hello, " << config.name << "!" << endl;
        }
    }

    if (config.verbose && !config.files.empty()) {
        cout << "\n--- File Details (verbose) ---" << endl;
        for (const auto& f : config.files) {
            cout << "  File: " << f << " (" << f.length() << " chars in name)" << endl;
        }
    }

    cout << "\nTry: " << argv[0] << " --name Alice -c 3 -v file1.txt file2.txt" << endl;
    return 0;
}
