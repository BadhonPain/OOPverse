interface Callback {
    void call(int param);
}

class Client implements Callback {
    @Override
    public void call(int p) {
        System.out.println("call method called with " + p);
    }

    public void f() {
        System.out.println("simple method, not related with Callback");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {

        // Callback c = new Callback(); // Error: interface can't be instantiated

        Client client = new Client();
        client.call(42);
        client.f();

        // accessing implementation through interface reference
        Callback cb = new Client();
        cb.call(84);
        // cb.f(); // Error: f() is not in Callback interface

        // anonymous class implementing the interface (Java 8+)
        Callback callback = new Callback() {
            @Override
            public void call(int param) {
                System.out.println("call method called with " + param);
            }
        };
        callback.call(10);
    }
}