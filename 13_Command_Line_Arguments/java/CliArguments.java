import java.util.ArrayList;
import java.util.List;

public class CliArguments {

    static class Config {
        String name = "";
        int count = 1;
        boolean verbose = false;
        boolean help = false;
        List<String> files = new ArrayList<>();
    }

    static void printUsage() {
        System.out.println("Usage: java CliArguments [options] [files...]");
        System.out.println("Options:");
        System.out.println("  -n, --name <name>   Set the name");
        System.out.println("  -c, --count <num>   Set repeat count (default: 1)");
        System.out.println("  -v, --verbose       Enable verbose output");
        System.out.println("  -h, --help          Show this help message");
    }

    static Config parseArgs(String[] args) {
        Config config = new Config();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-h": case "--help":
                    config.help = true;
                    break;
                case "-v": case "--verbose":
                    config.verbose = true;
                    break;
                case "-n": case "--name":
                    if (i + 1 < args.length) {
                        config.name = args[++i];
                    } else {
                        System.err.println("Error: " + args[i] + " requires a value");
                    }
                    break;
                case "-c": case "--count":
                    if (i + 1 < args.length) {
                        try {
                            config.count = Integer.parseInt(args[++i]);
                            if (config.count < 1) {
                                System.err.println("Error: count must be positive");
                                config.count = 1;
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid number for --count");
                        }
                    } else {
                        System.err.println("Error: " + args[i] + " requires a value");
                    }
                    break;
                default:
                    if (args[i].startsWith("-")) {
                        System.err.println("Warning: Unknown option '" + args[i] + "'");
                    } else {
                        config.files.add(args[i]);
                    }
                    break;
            }
        }
        return config;
    }

    public static void main(String[] args) {
        System.out.println("=== Command Line Arguments Demo ===");

        System.out.println("\n--- Raw Arguments ---");
        System.out.println("args.length = " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("  args[" + i + "] = \"" + args[i] + "\"");
        }

        if (args.length == 0) {
            System.out.println("\nNo arguments provided. Running with defaults.");
            System.out.println("Try: java CliArguments --name Alice -c 3 -v file1.txt file2.txt");
        }

        Config config = parseArgs(args);

        if (config.help) {
            System.out.println("\n--- Help ---");
            printUsage();
            return;
        }

        System.out.println("\n--- Parsed Configuration ---");
        System.out.println("  Name:    " + (config.name.isEmpty() ? "(not set)" : config.name));
        System.out.println("  Count:   " + config.count);
        System.out.println("  Verbose: " + (config.verbose ? "yes" : "no"));
        System.out.print("  Files:   ");
        if (config.files.isEmpty()) {
            System.out.println("(none)");
        } else {
            System.out.println(String.join(", ", config.files));
        }

        if (!config.name.isEmpty()) {
            System.out.println("\n--- Output ---");
            for (int i = 0; i < config.count; i++) {
                System.out.println("  Hello, " + config.name + "!");
            }
        }

        if (config.verbose && !config.files.isEmpty()) {
            System.out.println("\n--- File Details (verbose) ---");
            for (String f : config.files) {
                System.out.println("  File: " + f + " (" + f.length() + " chars in name)");
            }
        }
    }
}
