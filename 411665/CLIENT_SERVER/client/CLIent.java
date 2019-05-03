// A Java program for a Client 
package client;
import java.net.*; 
import java.io.*; 

public class CLIent 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 

	// constructor to put ip address and port 
	public CLIent(String address, int port) 
	{ 
		// establish a connection 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			// takes input from terminal 
			input = new DataInputStream(socket.getInputStream()); 

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 

		// keep reading until "Over" is input 
		while (true) 
		{ 
			try
			{ 
				line = input.readUTF();
				System.out.println(line);
				 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 
	} 

	public static void main(String args[]) 
	{ 
		CLIent client = new CLIent("127.0.0.1", 5000); 
	} 
} 
