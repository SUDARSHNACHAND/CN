import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            System.out.println("Connected to server. Type messages (type 'exit' to quit).");

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                System.out.print("You: ");
                message = userInput.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(message);
                String response = in.readLine();
                System.out.println("Echo from server: " + response);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
