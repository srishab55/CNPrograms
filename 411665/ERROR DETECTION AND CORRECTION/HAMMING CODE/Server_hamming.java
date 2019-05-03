import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import com.google.common.base.Splitter;

public class Server_hamming {
	DataOutputStream dos=null;
	ServerSocket serverSocket=null;
	Socket socket=null;
	HammingMain hm;
	public Server_hamming(int port) throws IOException {
		hm=new HammingMain();
		
		Scanner sc=new Scanner(System.in);
		
		try {
			serverSocket=new ServerSocket(port);
			System.out.println("Server started... waiting for client");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			socket=serverSocket.accept();
			System.out.println("Client registered");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dos=new DataOutputStream(socket.getOutputStream());
		String str;
		while(!((str=sc.nextLine()).equals("exit")))
				{
					str=hm.inputToFrame(str);
					System.out.println(str);
					str=hm.luck(str);
					dos.writeUTF(str);
				}
		System.out.println("Closing connection");
		dos.close();
		serverSocket.close();
		
	}
	public static void main(String[] args) throws IOException {
		
		Server_hamming srm=new Server_hamming(5000);
		
	}
	
}
