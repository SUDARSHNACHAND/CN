import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            
            while (true) {
                
                clientMsg = in.readLine();
                if (clientMsg == null || clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Client ended the chat.");
                    break;
                }
                System.out.println("Client: " + clientMsg);

              
                System.out.print("Server: ");
                serverMsg = keyboard.readLine();
                out.println(serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Chat ended.");
                    break;
                }
            }

           
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
