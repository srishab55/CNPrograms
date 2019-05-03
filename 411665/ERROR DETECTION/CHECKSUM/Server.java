// This server is for checksum detection method
import java.net.*;
import java.io.*;
import java.util.*;
public class Server {
	Socket socket;
	ServerSocket ss;
	DataOutputStream out;
	Scanner input;
	Server(int port)
	{
		try
		{
		ss=new ServerSocket(port);
		System.out.println("Server started");
		System.out.println("Waiting for client");
		socket=ss.accept();
		System.out.println("Client Accepted");
		input=new Scanner(System.in);
		out=new DataOutputStream(socket.getOutputStream());
		while(true)
		{
			System.out.println("Enter the string to send");
			String s=input.nextLine();
			if(s.equals("exit")) break;
			s=CheckSum(s);
			out.writeUTF(s);
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public String CheckSum(String s)
	{
		String sum="00000000";
		String bin;
		String finalbin="";
		int n1,n2,res;
		for(char c:s.toCharArray())
		{
			// Converting the character into String and replacing with leading zeros
			bin=String.format("%8s",Integer.toBinaryString((int)c)).replace(' ','0');
			finalbin=finalbin+bin;
			n1=Integer.parseInt(sum,2);
			n2=Integer.parseInt(bin,2);
			res=n1+n2;
			sum=String.format("%8s",Integer.toBinaryString(res)).replace(' ','0');
			if(sum.length()>8)
			{
				n1=Integer.parseInt(sum.substring(0,1),2);
				n2=Integer.parseInt(sum.substring(1,sum.length()),2);
				res=n1+n2;
				sum=String.format("%8s",Integer.toBinaryString(res)).replace(' ','0');
			}
		}
		int complimented=~(Integer.parseInt(sum,2));
		sum=String.format("%8s",Integer.toBinaryString(complimented)).replace(' ','0');
		sum=sum.substring(sum.length()-8,sum.length());  // To break the string upto 8 bits only
		System.out.println(sum);
		return sum+finalbin;
	}
	public static void main(String args[])
	{	
		Server se=new Server(5000);
	}
}