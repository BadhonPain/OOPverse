import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleServer {

    static final int PORT = 12345;
    static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm:ss");

    static void log(String msg) {
        System.out.println("[" + LocalDateTime.now().format(TIME_FMT) + "] " + msg);
    }

    public static void main(String[] args) {
        log("Starting server on port " + PORT + "...");
        log("Run SimpleClient in another terminal to connect.\n");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log("Server is listening on port " + PORT);

            int clientCount = 0;
            while (clientCount < 3) {
                Socket clientSocket = serverSocket.accept();
                clientCount++;
                String clientAddr = clientSocket.getInetAddress().getHostAddress();
                log("Client #" + clientCount + " connected from " + clientAddr);

                handleClient(clientSocket, clientCount);

                log("Client #" + clientCount + " disconnected\n");
                if (clientCount >= 3) {
                    log("Max clients served. Shutting down.");
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    static void handleClient(Socket socket, int clientId) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Welcome! You are client #" + clientId);
            out.println("Send messages (type 'bye' to disconnect):");

            String line;
            while ((line = in.readLine()) != null) {
                log("Client #" + clientId + " says: " + line);

                if (line.equalsIgnoreCase("bye")) {
                    out.println("Goodbye, client #" + clientId + "!");
                    break;
                }

                String response = processMessage(line);
                out.println("Server: " + response);
            }
        } catch (IOException e) {
            log("Error with client #" + clientId + ": " + e.getMessage());
        }
    }

    static String processMessage(String msg) {
        if (msg.equalsIgnoreCase("time")) {
            return "Current time: " + LocalDateTime.now().format(TIME_FMT);
        } else if (msg.equalsIgnoreCase("hello")) {
            return "Hello there!";
        } else {
            return "Echo: " + msg.toUpperCase();
        }
    }
}
