import java.net.*;
import java.io.*;

public class udpdnsserver {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("DNS Server is running...");
        System.out.println("Press Ctrl + C to Quit");

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String host = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Request for host " + host);

            String ipAddress;
            if (host.equalsIgnoreCase("yahoo.com"))
                ipAddress = "68.180.206.184";
            else if (host.equalsIgnoreCase("cricinfo.com"))
                ipAddress = "80.168.92.140";
            else if (host.equalsIgnoreCase("google.com"))
                ipAddress = "142.250.182.14";
            else
                ipAddress = "Host Not Found";

            sendData = ipAddress.getBytes();

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
    }
}
