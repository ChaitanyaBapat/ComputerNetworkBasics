import java.net.*;
import java.io.*;
class SimpleClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",6000);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("HELLO WORLD\n");
			dos.flush();
			dos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}