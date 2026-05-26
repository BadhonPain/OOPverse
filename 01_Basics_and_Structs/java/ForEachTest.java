public class ForEachTest {

    public static void main(String[] args) {

        // ── 1D array with for-each ─────────────────────────────────────────
        int numbers[] = { 1, 2, 3, 4, 5 };

        for (int x : numbers) {
            System.out.print(x + " ");
            x = x * 10; // no effect on the original array
        }
        System.out.println();

        // ── 2D array with nested for-each ─────────────────────────────────
        int numbers2[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int[] x : numbers2) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println("");
        }
    }
}