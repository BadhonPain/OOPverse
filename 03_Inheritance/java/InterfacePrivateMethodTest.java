// Private Methods in Interface — (Java 9+)
// private methods can only be called by default or other private methods in the same interface

interface MyIFPrivate {

    default String f1() {
        login(); // calls the private method
        return "Hello";
    }

    default String f2() {
        login();
        return "World";
    }

    // private method — shared helper, not visible outside the interface
    private void login() {
        System.out.println("login");
    }
}

class MyIFPrivateImp implements MyIFPrivate {
    // no need to implement anything — both methods are default
}

public class InterfacePrivateMethodTest {
    public static void main(String[] args) {
        MyIFPrivate ifp = new MyIFPrivateImp();
        System.out.println(ifp.f1());
        System.out.println(ifp.f2());
    }
}