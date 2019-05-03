import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class dns_arp {

	public static void main(String args[]) throws UnknownHostException, SocketException
	{
		String str;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter domain name");
		str=sc.nextLine();
		InetAddress address=InetAddress.getByName(str);
		System.out.println(address.getHostAddress());
		
		System.out.println("Enter ip address");
		String str1=sc.nextLine();
		str=InetAddress.getByName(str1).getHostName();
		System.out.println(str);
		
		InetAddress ip=InetAddress.getByName("192.168.43.156");
		NetworkInterface nic=NetworkInterface.getByInetAddress(ip);
		
		byte mac[]=nic.getHardwareAddress();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			//sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			
			sb.append(String.format("%02X%s", mac[i],(i<mac.length-1)? "-":""));
		}
		System.out.println(sb);
	}
}
