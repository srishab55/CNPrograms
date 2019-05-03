import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Hamming_client {
	HammingMain hm;
	private Socket socket		 = null; 
	private DataInputStream input = null; 
	private DataInputStream out	 = null; 
	public Hamming_client(String host,int port) throws UnknownHostException, IOException {
		hm=new HammingMain();
		socket=new Socket(host, port);
		input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		String line="";
		while (!line.equals("Over")) 
		{ 
			try
			{ 
				line = input.readUTF(); 
				line=hm.recieved(line);
				System.out.println(line); 

			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Hamming_client hmc=new Hamming_client("", 5000);
	}

}
