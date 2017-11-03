import java.net.*;
import java.util.*;
import java.io.*;
class RWClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",6000);
			Scanner scanner = new Scanner(System.in);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String clientString = "";
			String serverString = "";
			while (true) {
				System.out.print("Client : ");
				clientString = scanner.nextLine();
				out.writeUTF(serverString);
				out.flush();
				if(clientString.equals("over")) {
					break;
				}
				serverString = (String)in.readUTF();
				System.out.println("Server : "+clientString);
			}
			in.close();
			socket.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}