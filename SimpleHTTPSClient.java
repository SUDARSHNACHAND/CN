import java.io.*;
import java.net.*;
import javax.net.ssl.*;
public class SimpleHTTPSClient {
public static void main(String[] args) {
String host = "www.mzcet.in";
String path = "/";
try {
SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
SSLSocket socket = (SSLSocket) factory.createSocket(host, 443);
PrintWriter out = new PrintWriter(new BufferedWriter(
new OutputStreamWriter(socket.getOutputStream())), true);
out.println("GET " + path + " HTTP/1.1");
out.println("Host: " + host);
out.println("Connection: close");
out.println();
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
BufferedWriter fileOut = new BufferedWriter(new FileWriter("exp2.html"));
String inputLine;
while ((inputLine = in.readLine()) != null) {
fileOut.write(inputLine);
fileOut.newLine();
}
fileOut.close();
in.close();
out.close();
socket.close();
System.out.println("✅Web page saved to exp2.html");
} catch (IOException e) {
e.printStackTrace();
}
}
}
