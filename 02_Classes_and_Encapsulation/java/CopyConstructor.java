import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyConstructor {
    private String name;
    private int[] scores;
    private List<String> tags;

    CopyConstructor(String name, int[] scores, List<String> tags) {
        this.name = name;
        this.scores = scores;
        this.tags = tags;
    }

    // Copy constructor - performs deep copy
    CopyConstructor(CopyConstructor other) {
        this.name = other.name;
        this.scores = Arrays.copyOf(other.scores, other.scores.length);
        this.tags = new ArrayList<>(other.tags);
    }

    // Factory-style copy method (alternative pattern)
    CopyConstructor deepCopy() {
        return new CopyConstructor(this);
    }

    // Clone via Cloneable (traditional but discouraged pattern)
    static class CloneableVersion implements Cloneable {
        String label;
        int[] data;

        CloneableVersion(String label, int[] data) {
            this.label = label;
            this.data = data;
        }

        @Override
        protected CloneableVersion clone() {
            try {
                CloneableVersion copy = (CloneableVersion) super.clone();
                copy.data = Arrays.copyOf(data, data.length);
                return copy;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            return String.format("CloneableVersion{label='%s', data=%s}", label, Arrays.toString(data));
        }
    }

    void setScore(int index, int value) { scores[index] = value; }
    void addTag(String tag) { tags.add(tag); }
    void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return String.format("CopyConstructor{name='%s', scores=%s, tags=%s}",
                name, Arrays.toString(scores), tags);
    }

    public static void main(String[] args) {
        // Shallow copy problem
        System.out.println("=== Shallow Copy Problem ===");
        int[] origScores = {90, 85, 92};
        List<String> origTags = new ArrayList<>(Arrays.asList("math", "science"));
        CopyConstructor original = new CopyConstructor("Alice", origScores, origTags);

        CopyConstructor shallowCopy = new CopyConstructor(original.name, original.scores, original.tags);
        shallowCopy.setName("ShallowAlice");
        shallowCopy.setScore(0, 0);
        shallowCopy.addTag("SHALLOW");

        System.out.println("Original:  " + original);
        System.out.println("Shallow:   " + shallowCopy);
        System.out.println(">>> scores and tags are shared - original is corrupted!");

        // Deep copy via copy constructor
        System.out.println("\n=== Copy Constructor (Deep Copy) ===");
        int[] scores2 = {95, 88, 91};
        List<String> tags2 = new ArrayList<>(Arrays.asList("art", "music"));
        CopyConstructor orig2 = new CopyConstructor("Bob", scores2, tags2);
        CopyConstructor deepCopy = new CopyConstructor(orig2);

        deepCopy.setName("DeepBob");
        deepCopy.setScore(0, 0);
        deepCopy.addTag("DEEP");

        System.out.println("Original:  " + orig2);
        System.out.println("Deep copy: " + deepCopy);
        System.out.println(">>> Original is unaffected!");

        // Factory copy method
        System.out.println("\n=== Factory Copy Method ===");
        CopyConstructor factoryCopy = orig2.deepCopy();
        factoryCopy.setName("FactoryBob");
        factoryCopy.setScore(1, 0);
        System.out.println("Original:     " + orig2);
        System.out.println("Factory copy: " + factoryCopy);

        // Cloneable pattern
        System.out.println("\n=== Cloneable Pattern ===");
        CloneableVersion cv1 = new CloneableVersion("data-v1", new int[]{1, 2, 3});
        CloneableVersion cv2 = cv1.clone();
        cv2.label = "data-v2";
        cv2.data[0] = 999;

        System.out.println("cv1: " + cv1);
        System.out.println("cv2: " + cv2);
        System.out.println(">>> Deep clone - cv1.data is unaffected");
    }
}
