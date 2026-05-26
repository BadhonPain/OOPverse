import java.io.*;
import java.net.*;

public class SimpleClient {

    static final String HOST = "localhost";
    static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Connecting to " + HOST + ":" + PORT + "...");

        try (
            Socket socket = new Socket(HOST, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected!\n");

            String welcome = in.readLine();
            System.out.println("Server: " + welcome);
            String instructions = in.readLine();
            System.out.println("Server: " + instructions);

            String userInput;
            while (true) {
                System.out.print("\nYou: ");
                userInput = console.readLine();

                if (userInput == null || userInput.isEmpty()) continue;

                out.println(userInput);
                String response = in.readLine();

                if (response != null) {
                    System.out.println("Server: " + response);
                }

                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("\nDisconnected from server.");
                    break;
                }
            }
        } catch (ConnectException e) {
            System.err.println("Could not connect. Is SimpleServer running?");
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
