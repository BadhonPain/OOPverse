public class PassingArrays {
    // Changes to ELEMENTS are visible to the caller
    static void modifyArray(double d[]) {
        d[0] = 1.1; // visible to the caller
    }

    // Changes to the REFERENCE itself are NOT visible to the caller
    static void modifyArrayRef(double d[]) {
        d = new double[10];
        d[0] = 1.1; // NOT visible to the caller
    }

    public static void main(String[] args) {

        double[] temperature = new double[24];

        // Calling modifyArray —> temperature[0] will become 1.1
        modifyArray(temperature);
        System.out.println("After modifyArray, temperature[0] = " + temperature[0]);

        // Calling modifyArrayRef —> temperature is unchanged
        modifyArrayRef(temperature);
        System.out.println("After modifyArrayRef, temperature[0] = " + temperature[0]);
    }
}
