package netting;
import java.io.*;
import java.util.*;
public class Subnets {

	static int c=0,cb=0,sb=0,sbb=0,sbb1=1;
	static String gs="";
	static String[] sn=new String[1024];
	static String[] sndup=new String[1024];
	static int[] snnum=new int[1024];
	
	public static void main(String args[])
	{
		try
		
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the IP Address:");
		String ip=sc.next();
		System.out.println("Enter the / Number:");
		int s=sc.nextInt();
		String p1 =ip.split("\\.")[0];
		String p2 =ip.split("\\.")[1];
		String p3 =ip.split("\\.")[2];
		String p4 =ip.split("\\.")[3];
		int ipp=Integer.parseInt(p1);
		if(ipp<127)
			{
				c=1;
				cb=8;
			}
			else if(ipp<192)
			{
				c=2;
				cb=16;
			}
		else if(ipp<224)
		{
			c=3;
			cb=24;
		}
			sb=s-cb;
			int subnets=(int)Math.pow(2, sb);
			int h=32-s;
			int hosts=(int)Math.pow(2, h)-2;
			String submask="";
			int count=-1,i=0;
			int q=0,r=0;
			q=s/8;
			r=s%8;
			String ss="";
			for(i=0;i<q;i++)
			{
				ss+="255.";
			}
			String sam="";
			for(i=0;i<r;i++)
			{
				sam+="1";
			}
			for(i=0;i<8-r;i++)
			{
				sam+="0";
			}
			int sam1=Integer.parseInt(sam,2);
			String samm=Integer.toString(sam1);
			if(q!=4)
			ss+=samm;
			
			if(q==2)
				ss+=".0";
			if(q==1)
				ss+=".0.0";
		//	generate(0,0,gs,sb);
			System.out.println("Number of Hosts:"+hosts);
			System.out.println("Number of Subnets:"+subnets);
			System.out.println("Subnet Mask:"+ss);
			
			for(i=0;i<(int)Math.pow(2, sb);i++)
			{
				 
				sndup[sbb++]=Integer.toBinaryString(i);
				sn[sbb-1]=sndup[sbb-1];
				System.out.println("Subnet Mask:"+sn[sbb-1]);
				int p=sndup[sbb-1].length();
				System.out.println("P"+p);
				if(sndup[sbb-1].length()<sb)
				{
					for(int k=0;k<sb-p;k++)
					{
						sn[sbb-1]="0"+sn[sbb-1];
						sndup[sbb-1]="0"+sndup[sbb-1];
					}
				}
				
			
			}
			
			for(i=0;i<sbb;i++)
			{
				for(int j=0;j<8-sb;j++)
					sndup[i]+="0";
				snnum[i]=Integer.parseInt(sndup[i],2);
				
			}
			
			int[] lastip=new int[1024];
	
			for(i=0;i<sbb;i++)
			{
				for(int j=0;j<8-sb;j++)
					sn[i]+="1";
				lastip[i]=Integer.parseInt(sn[i],2);
			}
			System.out.println("Number of Hosts:"+hosts);
			System.out.println("Number of Subnets:"+subnets);
			System.out.println("Subnet Mask:"+ss);
			
			
			if(c==1)
			{
				for(i=0;i<sbb;i++)
				{
					String subn=p1+"."+Integer.toString(snnum[i])+".0.0";
					System.out.println("Subnet Address:"+subn);
					String firstip=p1+"."+Integer.toString(snnum[i])+".0.1";
					System.out.println("First IP Address:"+firstip);
					String last=p1+"."+Integer.toString(lastip[i])+".255.254";
					System.out.println("Last IP Address:"+last);
					String badd=p1+"."+Integer.toString(lastip[i])+".255.255";
					System.out.println("Target Broadcast Address:"+badd);
				}
				
			}
			if(c==2)
			{
				for(i=0;i<sbb;i++)
				{
					String subn=p1+"."+p2+"."+Integer.toString(snnum[i])+".0";
					System.out.println("Subnet Address:"+subn);
					String firstip=p1+"."+p2+"."+Integer.toString(snnum[i])+".1";
					System.out.println("First IP Address:"+firstip);
					String last=p1+"."+p2+"."+Integer.toString(lastip[i])+".254";
					System.out.println("Last IP Address:"+last);
					String badd=p1+"."+p2+"."+Integer.toString(lastip[i])+".255";
					System.out.println("Target Broadcast Address:"+badd);
					
				}
				
			}
			if(c==3)
			{
				for(i=0;i<sbb;i++)
				{
					String subn=p1+"."+p2+"."+p3+"."+Integer.toString(snnum[i]);
					System.out.println("Subnet Address:"+subn);
					String firstip=p1+"."+p2+"."+p3+"."+Integer.toString(snnum[i]+1);
					System.out.println("First IP Address:"+firstip);
					String last=p1+"."+p2+"."+p3+"."+Integer.toString(lastip[i]-1);
					System.out.println("Last IP Address:"+last);
					String badd=p1+"."+p2+"."+p3+"."+Integer.toString(lastip[i]);
					System.out.println("Target Broadcast Address:"+badd);
					
				}
				
			}
			
		}
		catch(Exception e)
		{
			
		}
			}
}