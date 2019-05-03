import java.io.*;
import java.net.*;  

public class Client 
{ 
	public static void main(String[] args) throws Exception 
	{ 
		InetAddress ip = InetAddress.getLocalHost(); 
		int port = 4444; 
		Socket s = new Socket(ip, port);
		int RECEIVE_INTERVAL=4000;
		DataInputStream dis = new DataInputStream(s.getInputStream());
		while (true) 
		{
			final long startTime = System.currentTimeMillis(); //from first data to next data packet we must calculate the time
			String str=dis.readUTF();
			final long endTime = System.currentTimeMillis();
		
			System.out.println("received data: " + str); 
			System.out.println();
			Thread.sleep(RECEIVE_INTERVAL-(endTime-startTime));
		} 
	} 
} 