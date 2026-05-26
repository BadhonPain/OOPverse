#include <iostream>
#include <cstring>
#include <utility>

class DynamicString {
private:
    char* m_data;
    size_t m_size;

public:
    // Default Constructor
    DynamicString(const char* str = "") {
        m_size = std::strlen(str);
        m_data = new char[m_size + 1];
        std::strcpy(m_data, str);
    }

    // 1. Destructor
    ~DynamicString() {
        delete[] m_data;
    }

    // 2. Copy Constructor (Deep Copy)
    DynamicString(const DynamicString& other) {
        m_size = other.m_size;
        m_data = new char[m_size + 1];
        std::strcpy(m_data, other.m_data);
    }

    // 3. Copy Assignment Operator
    DynamicString& operator=(const DynamicString& other) {
        if (this == &other) {
            return *this;
        }
        delete[] m_data;
        m_size = other.m_size;
        m_data = new char[m_size + 1];
        std::strcpy(m_data, other.m_data);
        return *this;
    }

    // 4. Move Constructor
    DynamicString(DynamicString&& other) noexcept {
        m_data = other.m_data;
        m_size = other.m_size;
        other.m_data = nullptr;
        other.m_size = 0;
    }

    // 5. Move Assignment Operator
    DynamicString& operator=(DynamicString&& other) noexcept {
        if (this == &other) {
            return *this;
        }
        delete[] m_data;
        m_data = other.m_data;
        m_size = other.m_size;
        other.m_data = nullptr;
        other.m_size = 0;
        return *this;
    }

    void print() const {
        if (m_data) {
            std::cout << "  \"" << m_data << "\"\n";
        } else {
            std::cout << "  nullptr / empty\n";
        }
    }
};

DynamicString createTempString() {
    return DynamicString("Temporary String");
}

int main() {
    std::cout << "--- 1. Copying str1 to str2 ---\n";
    DynamicString str1("Hello");
    DynamicString str2 = str1; 
    str1.print();
    str2.print();

    std::cout << "\n--- 2. Assignment (str3 = str1) ---\n";
    DynamicString str3("World");
    str3 = str1;
    str3.print();

    std::cout << "\n--- 3. Move Constructor (str4 = temp) ---\n";
    DynamicString str4 = createTempString();
    str4.print();

    std::cout << "\n--- 4. Explicit Move (str5 = move(str1)) ---\n";
    DynamicString str5 = std::move(str1); 
    str5.print();
    str1.print(); // Should print empty/nullptr

    return 0;
}
