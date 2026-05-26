// Default Interface Methods(Java 8+)
// default methods provide a body inside the interface itself

interface MyIF {
    int getNumber(); // normal abstract method — must be implemented

    // default method — has a body, implementing class can optionally override
    default String getString() {
        return "Default String";
    }
}

class MyIFImp implements MyIF {
    // only getNumber() needs to be implemented; getString() defaults
    @Override
    public int getNumber() { return 100; }
}

public class InterfaceDefaultMethodTest {
    public static void main(String[] args) {
        MyIFImp m = new MyIFImp();
        System.out.println(m.getNumber()); // 100
        System.out.println(m.getString()); // Default String
    }
}