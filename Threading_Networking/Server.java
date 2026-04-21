package Threading_Networking;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server Object is created. Waiting for Client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected !");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            while (true) {
                try{
                    double radius = input.readDouble();
                    double area = Math.PI * radius * radius;
    
                    output.writeDouble(area);
                    output.flush();

                }
                catch(Exception ex)
                {
                    System.out.println("Client Disconnected.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
