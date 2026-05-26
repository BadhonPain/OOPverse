// when two interfaces have same default method, the implementing class must resolve the conflict

interface Alpha {
    default void reset() {
        System.out.println("Alpha's reset");
    }
}

// Case 1: two interfaces with same default — class must override to resolve
interface Beta {
    default void reset() {
        System.out.println("Beta's reset");
    }
}

class TestClass implements Alpha, Beta {
    // must override reset() to resolve conflict
    @Override
    public void reset() {
        System.out.println("TestClass's reset");
    }
}

// Case 2: Beta extends Alpha and overrides reset — no conflict for implementors
interface BetaExtended extends Alpha {
    @Override
    default void reset() {
        System.out.println("Beta's reset");
        // Alpha.super.reset(); // can call Alpha's version if needed
    }
}

class TestClass2 implements BetaExtended {
    // no conflict — BetaExtended's reset() is used
}

public class MultipleInheritanceIssues {
    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.reset();

        TestClass2 t2 = new TestClass2();
        t2.reset();
    }
}