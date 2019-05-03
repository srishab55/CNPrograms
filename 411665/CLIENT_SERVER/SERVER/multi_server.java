package SERVER;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class multi_server  {

	DataInputStream dis=null;
	DataOutputStream dout=null;
	ServerSocket ss;
	public multi_server(int port) throws IOException {
	
		ss=new ServerSocket(port);
		System.out.println("Server Started");
		while(true)
		{
			Socket s=ss.accept();
			
			dis=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
			
			Thread t=new ClientHandler(s,dout,dis);
			
			t.start();
			
		}
	}
	public static void main(String str[]) throws IOException
	{
		multi_server ms=new multi_server(5000);
	}
	
	
}
class ClientHandler extends Thread
{

	Scanner sc;
	DataOutputStream dout;
	DataInputStream dis;
	public ClientHandler(Socket s,DataOutputStream dout,DataInputStream dis) throws IOException {
		sc=new Scanner(dis);
		this.dout=dout;
		this.dis=dis;
	}
	public void run() {
		System.out.println("New CLient Registered");
		while(true)
		{
		String string = null;
		try {
			string = dis.readUTF();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(string.equals("Exit")) break;
		System.out.println(string);
		try {
			dout.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
			dout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	
}
