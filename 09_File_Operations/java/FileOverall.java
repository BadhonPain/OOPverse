// File I/O demonstration: BufferedReader, BufferedWriter, and NIO (Files class)

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileOverall {

    static void printSection(String title) {
        System.out.println("\n===== " + title + " =====");
    }

    static void writeWithBufferedWriter(String filename) {
        printSection("Writing with BufferedWriter");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Line 1: Hello from BufferedWriter");
            writer.newLine();
            writer.write("Line 2: Java file I/O is straightforward");
            writer.newLine();
            writer.write("Line 3: Buffered streams improve performance");
            writer.newLine();
            for (int i = 4; i <= 8; i++) {
                writer.write("Line " + i + ": Auto-generated content #" + (i - 3));
                writer.newLine();
            }
            System.out.println("  Wrote 8 lines to " + filename);
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }

    static void readWithBufferedReader(String filename) {
        printSection("Reading with BufferedReader");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineNum++;
                System.out.printf("  [%d] %s%n", lineNum, line);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }

    static void appendToFile(String filename) {
        printSection("Appending to file");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Line 9: Appended content");
            writer.newLine();
            writer.write("Line 10: Final line");
            writer.newLine();
            System.out.println("  Appended 2 lines");
        } catch (IOException e) {
            System.out.println("Append error: " + e.getMessage());
        }
    }

    static void readWithNIOAllLines(String filename) {
        printSection("Reading with Files.readAllLines (NIO)");
        try {
            List<String> allLines = Files.readAllLines(Path.of(filename));
            System.out.println("  Total lines: " + allLines.size());
            allLines.forEach(l -> System.out.println("  " + l));
        } catch (IOException e) {
            System.out.println("NIO read error: " + e.getMessage());
        }
    }

    static void readAsString(String filename) {
        printSection("Reading as single String");
        try {
            String content = Files.readString(Path.of(filename));
            System.out.println("  File size: " + content.length() + " characters");
            System.out.println("  First 50 chars: " + content.substring(0, Math.min(50, content.length())));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void writeWithNIO(String filename) {
        printSection("Writing with Files.writeString (NIO)");
        try {
            Files.writeString(Path.of(filename), "Written with NIO\nSecond line\nThird line\n");
            System.out.println("  Wrote " + filename + " with NIO");
            System.out.println("  Content: " + Files.readString(Path.of(filename)).replace("\n", " | "));
        } catch (IOException e) {
            System.out.println("NIO write error: " + e.getMessage());
        }
    }

    static void readCharByChar(String filename) {
        printSection("Character-by-character reading");
        try (FileReader fr = new FileReader(filename)) {
            System.out.print("  Chars: ");
            int ch;
            int count = 0;
            while ((ch = fr.read()) != -1 && count < 20) {
                if (ch == '\n')
                    System.out.print("\\n");
                else
                    System.out.print((char) ch);
                count++;
            }
            System.out.println("...");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayFileMetadata(String filename) {
        printSection("File metadata");
        File file = new File(filename);
        System.out.println("  Name: " + file.getName());
        System.out.println("  Absolute: " + file.getAbsolutePath());
        System.out.println("  Size: " + file.length() + " bytes");
        System.out.println("  Readable: " + file.canRead());
        System.out.println("  Writable: " + file.canWrite());
        System.out.println("  Exists: " + file.exists());
    }

    static void cleanupFiles(String... filenames) {
        System.out.println();
        for (String filename : filenames) {
            if (new File(filename).delete()) {
                System.out.println("  Deleted: " + filename);
            }
        }
        System.out.println("Cleanup complete.");
    }

    public static void main(String[] args) {
        String filename = "frw_demo.txt";
        String nioFile = "frw_nio.txt";

        System.out.println("===== FILE I/O OPERATIONS DEMO =====");

        // --- Traditional I/O Stream operations ---
        writeWithBufferedWriter(filename);
        readWithBufferedReader(filename);
        appendToFile(filename);

        // --- NIO File operations ---
        readWithNIOAllLines(filename);
        readAsString(filename);
        writeWithNIO(nioFile);

        // --- Character-level and metadata operations ---
        readCharByChar(nioFile);
        displayFileMetadata(filename);

        // --- Cleanup ---
        cleanupFiles(filename, nioFile);
    }
}
