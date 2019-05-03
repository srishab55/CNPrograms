

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IPtoDomain
{
  public static void main(String[] args)throws UnknownHostException
  {
	  Scanner sc=new Scanner(System.in);
      System.out.println("Enter IP Address:");
      String str=sc.nextLine();
    String hostname = InetAddress.getByName(str).getHostName();
    System.out.println("hostname = " + hostname);
  }

}