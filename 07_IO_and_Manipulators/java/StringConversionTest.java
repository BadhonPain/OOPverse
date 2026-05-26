public class StringConversionTest {

    public static void main(String[] args) {

        // ── toUpperCase / toLowerCase ──────────────────────────────────────
        String s = "Hello World";
        System.out.println(s.toUpperCase()); // HELLO WORLD
        System.out.println(s.toLowerCase()); // hello world

        // ── trim() — removes whitespace from both ends
        String spaced = "   Hello   ";
        System.out.println(spaced.trim());   // Hello

        // ── replace() — replaces all occurrences of a character 
        String replaced = s.replace('l', 'L');
        System.out.println(replaced);        // HeLLo WorLd

        System.out.println();

        // ── int to String (3 ways) -> Super Important for TF
        int n = 123;
        String s1 = Integer.toString(n);     // way 1
        String s2 = String.valueOf(n);       // way 2
        String s3 = n + "";                  // way 3
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // ── String to int 
        String str = "1234";
        int num = Integer.parseInt(str);
        System.out.println(num + 1);         // 1235
    }
}