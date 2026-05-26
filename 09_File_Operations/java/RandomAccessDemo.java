// RandomAccessFile for random access file operations

import java.io.*;

public class RandomAccessDemo {

    static final int RECORD_SIZE = 44; // 4(id) + 20(name chars)*2 + fixed
    static final int NAME_LENGTH = 20;

    static void writeRecord(RandomAccessFile raf, int id, String name, double score) throws IOException {
        raf.writeInt(id);
        StringBuilder padded = new StringBuilder(name);
        padded.setLength(NAME_LENGTH);
        raf.writeChars(padded.toString());
        raf.writeDouble(score);
    }

    static void readRecord(RandomAccessFile raf) throws IOException {
        int id = raf.readInt();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < NAME_LENGTH; i++) {
            char c = raf.readChar();
            if (c != '\0') name.append(c);
        }
        double score = raf.readDouble();
        System.out.printf("  ID: %d | Name: %-15s | Score: %.2f%n", id, name.toString().trim(), score);
    }

    public static void main(String[] args) {
        String filename = "rad_records.dat";

        System.out.println("===== Writing fixed-size records =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            writeRecord(raf, 1, "Alice", 95.5);
            writeRecord(raf, 2, "Bob", 87.3);
            writeRecord(raf, 3, "Charlie", 92.1);
            writeRecord(raf, 4, "Diana", 88.7);
            writeRecord(raf, 5, "Eve", 91.0);
            System.out.println("  Wrote 5 records");
            System.out.println("  File size: " + raf.length() + " bytes");
            System.out.println("  Record size: " + (raf.length() / 5) + " bytes each");
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
            return;
        }

        int recordSize = 4 + NAME_LENGTH * 2 + 8; // int + chars + double

        System.out.println("\n===== Reading all records sequentially =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                readRecord(raf);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }

        System.out.println("\n===== Random access: read record #3 directly =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            long offset = (long) 2 * recordSize;
            raf.seek(offset);
            System.out.println("  Seeked to offset: " + offset);
            readRecord(raf);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== Random access: read in reverse order =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            int totalRecords = (int) (raf.length() / recordSize);
            for (int i = totalRecords - 1; i >= 0; i--) {
                raf.seek((long) i * recordSize);
                readRecord(raf);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== Update record #2 in place =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            raf.seek((long) 1 * recordSize);
            writeRecord(raf, 2, "Bobby", 99.9);
            System.out.println("  Updated record #2");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== Verify update =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                readRecord(raf);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n===== Byte-level operations =====");
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            System.out.println("  File pointer at start: " + raf.getFilePointer());
            raf.seek(0);
            byte[] header = new byte[4];
            raf.read(header);
            System.out.printf("  First 4 bytes (int): %02X %02X %02X %02X%n",
                    header[0], header[1], header[2], header[3]);
            raf.seek(0);
            System.out.println("  As int: " + raf.readInt());
            System.out.println("  File length: " + raf.length() + " bytes");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        new File(filename).delete();
        System.out.println("\nCleanup complete.");
    }
}
