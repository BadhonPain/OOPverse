// AutoCloseable and try-with-resources pattern

import java.io.*;

public class TryWithResources {

    static class DatabaseConnection implements AutoCloseable {
        private final String name;
        private boolean open;

        DatabaseConnection(String name) throws Exception {
            this.name = name;
            this.open = true;
            System.out.println("  [" + name + "] Connection opened");
            if (name.equals("BAD_DB")) {
                throw new Exception("Failed to connect to " + name);
            }
        }

        String query(String sql) {
            if (!open) throw new IllegalStateException("Connection closed");
            return "Result of: " + sql;
        }

        @Override
        public void close() {
            if (open) {
                open = false;
                System.out.println("  [" + name + "] Connection closed");
            }
        }
    }

    static class LogWriter implements AutoCloseable {
        private final String filename;

        LogWriter(String filename) {
            this.filename = filename;
            System.out.println("  [LogWriter] Opened " + filename);
        }

        void log(String message) {
            System.out.println("  [LogWriter] LOG: " + message);
        }

        @Override
        public void close() {
            System.out.println("  [LogWriter] Closed " + filename);
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Basic try-with-resources =====");
        try (DatabaseConnection db = new DatabaseConnection("MainDB")) {
            System.out.println("  " + db.query("SELECT * FROM users"));
            System.out.println("  " + db.query("SELECT count(*) FROM orders"));
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println("  (connection auto-closed above)");

        System.out.println("\n===== Multiple resources =====");
        try (DatabaseConnection db = new DatabaseConnection("AppDB");
             LogWriter log = new LogWriter("app.log")) {
            String result = db.query("SELECT * FROM products");
            log.log(result);
            log.log("Query executed successfully");
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println("\n===== Resource closed even on exception =====");
        try (DatabaseConnection db = new DatabaseConnection("TestDB")) {
            System.out.println("  " + db.query("SELECT 1"));
            throw new RuntimeException("Simulated error during processing");
        } catch (Exception e) {
            System.out.println("  Caught: " + e.getMessage());
        }

        System.out.println("\n===== Constructor failure =====");
        try (DatabaseConnection db = new DatabaseConnection("BAD_DB")) {
            System.out.println("  This won't execute");
        } catch (Exception e) {
            System.out.println("  Caught constructor failure: " + e.getMessage());
        }

        System.out.println("\n===== Suppressed exceptions =====");
        try (AutoCloseable res = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                System.out.println("  close() throwing exception");
                throw new Exception("Error during close");
            }
        }) {
            System.out.println("  Body throwing exception");
            throw new RuntimeException("Error in body");
        } catch (Exception e) {
            System.out.println("  Primary: " + e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable t : suppressed) {
                System.out.println("  Suppressed: " + t.getMessage());
            }
        }

        System.out.println("\n===== File I/O with try-with-resources =====");
        String filename = "twt_test_output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Line 1: try-with-resources demo\n");
            writer.write("Line 2: auto-closed writer\n");
            writer.write("Line 3: clean resource management\n");
            System.out.println("  Wrote to " + filename);
        } catch (IOException e) {
            System.out.println("  Write error: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("  Reading back:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("    " + line);
            }
        } catch (IOException e) {
            System.out.println("  Read error: " + e.getMessage());
        }

        new File(filename).delete();

        System.out.println("\n===== Comparison: manual vs try-with-resources =====");
        System.out.println("  Manual approach requires finally block to close resources.");
        System.out.println("  try-with-resources guarantees close() even if exceptions occur.");
        System.out.println("  Suppressed exceptions are preserved, not lost.");
    }
}
