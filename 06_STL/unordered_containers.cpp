#include <iostream>
#include <map>
#include <unordered_map>
#include <set>
#include <unordered_set>
#include <string>

void demonstrateMapVsUnorderedMap() {
    std::cout << "--- 1. std::map vs std::unordered_map ---\n\n";

    // std::map (Sorted alphabetically by key)
    std::map<std::string, int> orderedInventory;
    orderedInventory["Orange"] = 50;
    orderedInventory["Apple"] = 100;
    orderedInventory["Banana"] = 75;

    std::cout << "[std::map] Alphabetically ordered:\n";
    for (const auto& pair : orderedInventory) {
        std::cout << "  " << pair.first << " : " << pair.second << "\n";
    }

    std::cout << "\n";

    // std::unordered_map (Hash Table - no predictable order)
    std::unordered_map<std::string, int> unorderedInventory;
    unorderedInventory["Orange"] = 50;
    unorderedInventory["Apple"] = 100;
    unorderedInventory["Banana"] = 75;

    std::cout << "[std::unordered_map] Unordered:\n";
    for (const auto& pair : unorderedInventory) {
        std::cout << "  " << pair.first << " : " << pair.second << "\n";
    }
}

void demonstrateSetVsUnorderedSet() {
    std::cout << "\n--- 2. std::set vs std::unordered_set ---\n\n";

    // std::set (Sorted numerically)
    std::set<int> orderedIds = {45, 12, 89, 3};
    std::cout << "[std::set] Sorted naturally:\n  ";
    for (int id : orderedIds) {
        std::cout << id << " ";
    }
    std::cout << "\n\n";

    // std::unordered_set (Hash Table - unordered)
    std::unordered_set<int> unorderedIds = {45, 12, 89, 3};
    std::cout << "[std::unordered_set] Unordered:\n  ";
    for (int id : unorderedIds) {
        std::cout << id << " ";
    }
    std::cout << "\n";
}

int main() {
    demonstrateMapVsUnorderedMap();
    demonstrateSetVsUnorderedSet();
    return 0;
}
