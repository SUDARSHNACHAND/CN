import java.net.*;
import java.io.*;

public class udpdnsclient {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the hostname : ");
        String host = br.readLine();

        byte[] sendData = host.getBytes();
        byte[] receiveData = new byte[1024];

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        String ip = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("IP Address: " + ip);

        clientSocket.close();
    }
} 
