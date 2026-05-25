#include <iostream>
#include <memory>
#include <string>

class Resource {
public:
    std::string name;
    
    Resource(const std::string& resName) : name(resName) {}
    ~Resource() {}
    
    void doWork() const {
        std::cout << "  Resource '" << name << "' is performing work...\n";
    }
};

void demonstrateUniquePtr() {
    std::cout << "\n--- 1. std::unique_ptr ---\n";
    
    // Unique ownership - cannot be copied, only moved
    std::unique_ptr<Resource> ptr1 = std::make_unique<Resource>("UniqueA");
    ptr1->doWork();
    
    std::unique_ptr<Resource> ptr2 = std::move(ptr1);
    if (ptr1 == nullptr) {
        std::cout << "  ptr1 is now null after move.\n";
    }
    if (ptr2 != nullptr) {
        ptr2->doWork();
    }
}

void demonstrateSharedPtr() {
    std::cout << "\n--- 2. std::shared_ptr ---\n";
    
    std::shared_ptr<Resource> mainPtr;
    {
        // Shared ownership - maintains a reference counter
        std::shared_ptr<Resource> ptr1 = std::make_shared<Resource>("SharedA");
        std::cout << "  Ref count (ptr1): " << ptr1.use_count() << "\n";
        
        std::shared_ptr<Resource> ptr2 = ptr1;
        std::cout << "  Ref count (after copy): " << ptr1.use_count() << "\n";
        
        mainPtr = ptr2;
    }
    std::cout << "  Ref count (outside scope): " << mainPtr.use_count() << "\n";
    mainPtr->doWork();
}

void demonstrateWeakPtr() {
    std::cout << "\n--- 3. std::weak_ptr ---\n";
    
    std::weak_ptr<Resource> weakObserver;
    {
        std::shared_ptr<Resource> sharedCreator = std::make_shared<Resource>("WeakA");
        weakObserver = sharedCreator; // Non-owning observer
        
        if (std::shared_ptr<Resource> lockedPtr = weakObserver.lock()) {
            lockedPtr->doWork();
        }
    }
    
    // Check if resource is still alive
    if (std::shared_ptr<Resource> lockedPtr = weakObserver.lock()) {
        lockedPtr->doWork();
    } else {
        std::cout << "  Observer lock failed: Resource was automatically destroyed.\n";
    }
}

int main() {
    demonstrateUniquePtr();
    demonstrateSharedPtr();
    demonstrateWeakPtr();
    return 0;
}
