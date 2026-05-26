public class MultiDimArrays {

    public static void main(String[] args) {

        // ── Example 1: Jagged array created manually ──────────────────────
        int b[][];
        b = new int[2][];
        b[0] = new int[2];
        b[1] = new int[3];

        // b[0][2] = 7; -> would throw ArrayIndexOutOfBoundsException
        b[0][0] = 1;
        b[0][1] = 2;
        b[1][0] = 3;
        b[1][1] = 4;
        b[1][2] = 5;

        System.out.println("Example 1 — Jagged array:");
        System.out.println("b.length     = " + b.length); // 2
        System.out.println("b[0].length  = " + b[0].length); // 2
        System.out.println("b[1].length  = " + b[1].length); // 3

        // ── Example 2: Jagged array using initializer ──────────────────────
        int b2[][] = { { 1, 2 }, { 3, 4, 5 } };
        // b2[0][2] = 8; // would throw ArrayIndexOutOfBoundsException

        System.out.println("\nExample 2 — Jagged array initializer:");
        System.out.println("b2.length    = " + b2.length); // 2
        System.out.println("b2[0].length = " + b2[0].length); // 2
        System.out.println("b2[1].length = " + b2[1].length); // 3

        // ── Rectangular 2D array ───────────────────────────────────────────
        int rect[][] = new int[3][4];
        System.out.println("\nRectangular 3x4 array:");
        System.out.println("rect.length      = " + rect.length); // 3
        System.out.println("rect[0].length   = " + rect[0].length); // 4

        // ── 2D array with initializer ──────────────────────────────────────
        int c[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("\n2D initializer array:");
        System.out.println("c.length     = " + c.length); // 2
        System.out.println("c[0].length  = " + c[0].length); // 3
        System.out.println("c[1].length  = " + c[1].length); // 3
    }
}