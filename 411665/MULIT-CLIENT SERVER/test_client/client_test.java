package test_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class client_test {

	public DataInputStream input;
	public DataOutputStream out;
	public Socket socket=null;
	public client_test(String address,int id) throws UnknownHostException, IOException {
		
		
		
		
		socket=new Socket(address, id);
		System.out.println("Connected");
		
		input=new DataInputStream(System.in);
		out=new DataOutputStream(socket.getOutputStream());
		
		
		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		client_test ob=new client_test("", 5000);

	}

}
