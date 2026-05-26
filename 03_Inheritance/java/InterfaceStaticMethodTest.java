// Static Methods in Interface — (Java 8+)
// static interface methods are not inherited by implementing classes or subinterfaces
// called directly on the interface name: MyIFStatic.getDefaultNumber()

interface MyIFStatic {
    int getNumber();

    default String getString() {
        return "Default String";
    }

    // static method — called on the interface itself, not on an object
    static int getDefaultNumber() {
        return 0;
    }
}

public class InterfaceStaticMethodTest {
    public static void main(String[] args) {
        System.out.println(MyIFStatic.getDefaultNumber()); // 0
    }
}