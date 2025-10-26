import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");

            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String clientMsg, serverMsg;

            
            while (true) {
               
                System.out.print("Client: ");
                clientMsg = keyboard.readLine();
                out.println(clientMsg);

                if (clientMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Chat ended.");
                    break;
                }

               
                serverMsg = in.readLine();
                System.out.println("Server: " + serverMsg);

                if (serverMsg.equalsIgnoreCase("bye")) {
                    System.out.println("Server ended the chat.");
                    break;
                }
            }

          
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
