import java.io.*;
import java.util.*;
public class Netting {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no.of hosts:");
		double host=sc.nextInt();
		double A=(double)Math.pow(2,24)-2;
		double B=(double)Math.pow(2,16)-2;
		double C=(double)Math.pow(2,8)-2;
		double temp1=0;
		//System.out.println("A:"+A+"B:"+B+"C:"+C);
		double n1=0,tp1;
		n1=host/A;
		if(n1==0)
			tp1=(host/A);
		else
			tp1=((host%A)/A);
		n1=n1+1;
		tp1=tp1*100;
		//System.out.println("tp:"+tp1+"n1:"+n1);
		double n2=0,tp2;
		n2=host/B;
		if(n2==0)
			tp2=(host/B);
		else
			tp2=((host%B)/B);
		n2=n2+1;
		tp2=tp2*100;
		//System.out.println("tp:"+tp2+"n1:"+n2);
		double n3=0,tp3;
		n3=host/C;
		if(n3==0)
			tp3=(host/C);
		else
			tp3=((host%C)/C);
		n3=n3+1;
		tp3=tp3*100;
		//System.out.println("tp:"+tp3+"n1:"+n3);
		double tp[]= {tp1,tp2,tp3};
		temp1=tp1;
		int in=0;
		for(int i=1;i<3;i++)
		{
			if(tp[i]>temp1)
				
				{temp1=tp[i];
		in=i;
				}
	}
		int n11=(int)n1;
		int n21=(int)n2;
		int n31=(int)n3;
		
		if(in==0)
		{
			System.out.println("Class is:A\nNo.of Classes:"+n11+"\nThroughput:"+tp1);
		}
		if(in==1)
		{
			System.out.println("Class is:B\nNo.of Classes:"+n21+"\nThroughput:"+tp2);
		}if(in==2)
		{
			System.out.println("Class is:C\nNo.of Classes:"+n31+"\nThroughput:"+tp3);
		}
		
	}	
	}