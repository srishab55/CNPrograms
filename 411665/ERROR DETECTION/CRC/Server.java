import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Server {
	ServerSocket ss;
	Socket socket;
	DataOutputStream dos;
	Scanner sc;
	public Server(int port) throws IOException {
	
		ss=new ServerSocket(port);
		System.out.println("Server started");
		sc=new Scanner(System.in);
		socket=ss.accept();
		System.out.println("Client connected");
		dos=new DataOutputStream(socket.getOutputStream());
		
		injectError ij=new injectError();
		Random rand=new Random();
		while (true) {
			
			System.out.println("Enter data to be deliver to client");
			String str=sc.nextLine();
			if(str.equals("exit")) break;
			
			String converted=converttobinary(str);
			System.out.println(converted);
			int num=rand.nextInt(2);
			if(num==0)
			converted=ij.injection(converted);
			System.out.println(converted);
			dos.writeUTF(converted);
			
		}
		socket.close();
		ss.close();
		
	}
	private String converttobinary(String str) {
		
		StringBuilder sb=new StringBuilder();
		String s = null;
		ArrayList<String> bindigit=new ArrayList<>();
		String toReturn="",t="";
		for (char c : str.toCharArray())
		{
			s = String.format("%8s", Integer.toBinaryString((int)c & 0xFF)).replace(' ', '0');
			t+=s;
		}
		s=t;
		s+="000";
		String divisor="1010";
		XorOperation xp=new XorOperation();
		String toAdd=xp.xor(s,divisor);
		System.out.println("CRC :"+toAdd);
		toReturn=t+toAdd;
		
		
		return toReturn;
	}
	public static void main(String[] args) {
		
		try {
			Server sr=new Server(5000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
