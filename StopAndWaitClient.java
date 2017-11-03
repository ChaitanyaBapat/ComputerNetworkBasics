import java.io.*;
import java.util.*;
import java.net.*;

class StopAndWaitClient {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter no. of packets to be sent : ");
		int n = scanner.nextInt();

		int[] data = new int[n];

		int i,j;

		System.out.println("Enter integer packets to be sent : ");
		for(i=0;i<n;i++) {
			System.out.println("Packet : " + i);
			data[i] = scanner.nextInt();
		}

		try {

			Socket socket = new Socket("127.0.0.1",6000);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			i = 0;
			while (i < n) {
				System.out.println("Sending packet : " + data[i]);
				out.writeUTF(Integer.toString(data[i]));
				out.flush();
				String status = in.readUTF();
				if(status.equals("ack")) {
					i++;
					System.out.println("Acknowledged !");
				} else {
					System.out.println("Not Acknowledged !");
				}
			}
			out.writeUTF("over");
			out.flush();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}