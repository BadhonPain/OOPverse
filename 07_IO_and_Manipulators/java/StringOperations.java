public class StringOperations {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";

        // Concatenation and length
        String str3 = str1 + ", " + str2 + "!";
        System.out.println("Combined String: " + str3);
        System.out.println("String Length: " + str3.length());

        // Comparison
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println("\ns1 == s2 (reference comparison): " + (s1 == s2));
        System.out.println("s1.equals(s2) (content comparison): " + s1.equals(s2));

        // Substring and search
        System.out.println("\nSubstring(0, 4): " + str3.substring(0, 4));
        System.out.println("Contains 'World': " + str3.contains("World"));
        System.out.println("Index of 'o': " + str3.indexOf('o'));

        // StringBuilder for efficient concatenation in loops
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(i).append(" ");
        }
        System.out.println("\nStringBuilder Output: " + sb.toString());
    }
}
