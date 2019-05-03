package test_client;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server_test {
	ServerSocket ss=null;
	Socket sc=null;
	DataInputStream in=null;
	public server_test() throws IOException {
	
		
		try {
			ss=new ServerSocket(5000);
			System.out.println("Server started");
			sc=ss.accept();
			System.out.println("Client Connected");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		in=new DataInputStream(new BufferedInputStream(sc.getInputStream()));
		String str="";
		try
		{
		while(!str.equals("Over")||!str.equals("")) {
			str=in.readUTF();
			System.out.println(str);
		}
		}
		catch (Exception e)
		{
			System.out.println("Client no more active");
		}
		finally
		{
		in.close();
		ss.close();sc.close();
		server_test st=new server_test();
		}
	}
	public static void main (String args[]) throws IOException	
	{
		server_test st=new server_test();
	}

}

