import java.io.*;
import java.util.*;
import java.net.*;

class StopAndWaitServer {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		try {
			ServerSocket server = new ServerSocket(6000);
			Socket socket = server.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String client = in.readUTF();
				if(client.equals("over")) {
					break;
				}
				System.out.println("Client : " + client);
				System.out.println("Response : ");
				out.writeUTF(scanner.nextLine());
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}