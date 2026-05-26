
public class GenericsWithMultiType<S,T> {
    
    private S a;
    private T b;

    public GenericsWithMultiType(S a, T b) {
        this.a = a;
        this.b = b;
    }

    public S getObj1() {
        return this.a;
    }

    public T getObj2() {
        return this.b;
    }

    public static void main(String[] args) {

        GenericsWithMultiType<Integer, String> myGenerics =
                new GenericsWithMultiType<>(10, "Hello");

        System.out.println(myGenerics.getObj1());
        System.out.println(myGenerics.getObj2());
    }
}
