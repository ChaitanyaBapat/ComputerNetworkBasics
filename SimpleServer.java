import java.net.*;
import java.io.*;
class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(6000);
			Socket socket = server.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println((String)dis.readUTF());
			server.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}