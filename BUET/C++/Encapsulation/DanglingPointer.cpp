#include <iostream>

class Resource {
    int* data;
public:
    Resource() { data = new int(10); } // Allocate memory
    ~Resource() { 
        std::cout << "Destructor running\n";
        delete data; // Free memory
    }
};

void process(Resource r) { 
    // 'r' is a copy. Its destructor will trigger at the end of this function.
    std::cout << "Processing...\n";
}

int main() {
    Resource obj;
    process(obj); // Crash occurs here or shortly after
    return 0;
}