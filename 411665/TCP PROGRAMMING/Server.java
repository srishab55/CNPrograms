import java.io.*; 
import java.net.*;

public class Server 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		String str="A list of resources in a network, which include users, groups, permissions, devices and management policies. Also called a \"directory service,\" when given a username, the network directory returns the profile of the individual, which can include permissions for data access, as well as employee information. When given a machine name, the directory returns the configuration of the hardware, including IP address. See X.500, LDAP, naming service, Active Directory and ULS server.";
		int index=1;
		ServerSocket server = new ServerSocket(4444); 
		Socket s = server.accept(); 
		System.out.println("client connected \n addr-"+s.getInetAddress()+", port no -"+s.getPort());
		int SEND_INTERVAL=1000;
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
		
		while (true) 
		{
			try {
				final long startTime = System.currentTimeMillis();
				dos.writeUTF((index++)+"."+str);
				final long endTime = System.currentTimeMillis();
				Thread.sleep(SEND_INTERVAL-(endTime-startTime)); //Sleeping to send data packet at certain interval of time
			}
			catch(Exception e) {}
		} 
	} 
}