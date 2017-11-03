import java.net.*;
import java.util.*;
import java.io.*;
class RWServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(6000);
			Socket socket = server.accept();
			Scanner scanner = new Scanner(System.in);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String clientString = "";
			String serverString = "";
			while (true) {
				clientString = (String)in.readUTF();
				System.out.println("Client : " + clientString);
				if(clientString.equals("over")) {
					break;
				}
				System.out.print("Server : ");
				serverString = scanner.nextLine();
				out.writeUTF(serverString);
				out.flush();
			}
			in.close();
			server.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}