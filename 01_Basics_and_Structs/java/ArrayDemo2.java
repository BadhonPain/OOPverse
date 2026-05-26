class A {
    private int a;
 
    public int getA() {
        return a;
    }
 
    public void setA(int a) {
        this.a = a;
    }
}
public class ArrayDemo2 {
    public static void main(String[] args) {
 
        A[] array = new A[10];
 
        // Create and assign each object
        for (int i = 0; i < array.length; i++) {
            array[i] = new A();  // Carefull here, Core difference with C++
            array[i].setA(i);
        }
 
        // Print each object's value
        for (int i = 0; i < array.length; i++) {
            System.out.println("Object of A: " + array[i].getA());
        }
    }
}
