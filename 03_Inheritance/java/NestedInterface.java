class A {
    // non-nested: default or public
    // nested: can be private, protected, public, or default
    interface NestedIF {
        boolean isNonNegative(int x);
    }
}

class B implements A.NestedIF {
    @Override
    public boolean isNonNegative(int x) {
        return x >= 0;
    }
}

public class NestedInterface {
    public static void main(String[] args) {
        A.NestedIF nif = new B();
        System.out.println(nif.isNonNegative(100)); // true
        System.out.println(nif.isNonNegative(-10)); // false
    }
}
