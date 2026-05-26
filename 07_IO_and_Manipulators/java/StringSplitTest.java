public class StringSplitTest {

    public static void main(String[] args) { 
        // Important for everything -> TF, CP

        String test = "abc,,def,123";

        // split() splits the string by the given delimiter (regex -> regular expression)
        String[] out = test.split(",");

        System.out.println(out.length); // 4 — empty string counted between ",,"

        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }
}