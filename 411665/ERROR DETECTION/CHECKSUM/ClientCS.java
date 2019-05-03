import java.io.*;
import java.util.*;
import java.net.*;
public class ClientCS {
	Socket socket;
	DataInputStream in;
	String resstr="";
	String recieved;
	ClientCS(String s,int port)
	{
		try
		{
		socket = new Socket(s,port);
		in=new DataInputStream(socket.getInputStream());
		while(true)
		{
		recieved=in.readUTF();
		if(Checksum(recieved))
		System.out.println("Accepted and the data is "+resstr);
		else
			System.out.println("Data is Rejected");
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public boolean Checksum(String s)
	{
		int n1,n2,res;
		resstr="";
		String check="00000000";
		String sum=s.substring(0,8);
		int len=s.length();
		for(int i=8;i<len;i=i+8)
		{
			n1=Integer.parseInt(s.substring(i,i+8),2);
			n2=Integer.parseInt(check,2);
			res=n1+n2;
			resstr=resstr+(char)n1;
			check=String.format("%8s",Integer.toBinaryString(res)).replace(' ','0');
			if(check.length()>8)
			{
				n1=Integer.parseInt(check.substring(0,1),2);
				n2=Integer.parseInt(check.substring(1,check.length()),2);
				res=n1+n2;
				check=String.format("%8s",Integer.toBinaryString(res)).replace(' ','0');
			}
		}
		n1=Integer.parseInt(sum,2);
		n2=Integer.parseInt(check,2);
		res=(n1+n2);
		if(res!=255)  //Instead of complimenting and checking it will directly check
			return false;
		return true;
	}
	public static void main(String args[])
	{
		ClientCS checksum=new ClientCS("127.0.0.1",5000);
	}
}