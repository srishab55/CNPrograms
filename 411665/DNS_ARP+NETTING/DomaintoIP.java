import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.*;
import java.util.*;

import javax.net.ssl.HostnameVerifier;
public class DomaintoIP {
     
    public static void main(String[] args) {
         
        try {
        	Scanner sc=new Scanner(System.in);
             System.out.println("Enter domian name:");
             String str=sc.nextLine();
            InetAddress ad = InetAddress.getByName(str);
            InetAddress add[]= ad.getAllByName(str);
            for(InetAddress ad1 : add)
            { System.out.println("IP Address: "+ ad1.getHostAddress());}
             
        }
        catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        }
         
    }
 
}