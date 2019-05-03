import java.util.ArrayList;

import com.google.common.base.Splitter;

public class HammingMain {

	float logBase2(int num)
	{
		return (float) (Math.log(num)/Math.log(2));
	}
	
	String  inputToFrame(String s)
	{
		String toReturn="";
		char ch[]=s.toCharArray();
		for (char c : ch)
		{
			String t = String.format("%8s", Integer.toBinaryString((int)c & 0xFF)).replace(' ', '0');
			toReturn+=find_add(t);
			
			t=String.format("%8s",Integer.toBinaryString(((int)c & 0xFF)).replace(' ', '0'));
		}
		return toReturn;
	}
	public String recieved(String input)
	{
		Iterable<String> result = Splitter.fixedLength(12) 
                .trimResults() 
                .split(input);
		String output="";
		for(String str : result)
		{
			output+=convertToOriginal(receiver_side(str));
		}
		System.out.println("final converted :"+output);
		return output;
	}
	String find_add(String s)
	{
		int m=s.length();
		int r=(int) Math.ceil(logBase2(m+1));
		System.out.println(r+":"+m+" "+(int)Math.pow(2, r));
		while((int)Math.pow(2, r)<(m+r+1))r++;
		System.out.println(r+"\n");
		int c[];
		c=new int[(int) Math.pow(2, r)];
		
		for(int i=0;i<r;i++)
		{
			c[(int) Math.pow(2, i)]=2;
		}
		int index=s.length()-1;
		int i=1;
		for(index=0;index<s.length();i++)
		{
			
			if(c[i]!=2) c[i]=Integer.parseInt(s.charAt(index++)+"");
			System.out.println(c[i]);			
		}
		String toReturn="";
		for(int j=1;j<i;j++)
			{toReturn+=c[j]+"";}//System.out.print(c[i]);}
		System.out.println(toReturn+" :"+toReturn.length());
		toReturn=stuffBits(toReturn);
		return toReturn;
			
	}
	
	public String stuffBits(String s)
	{
		char c[]=s.toCharArray();
		for (int k=0;k<c.length;k++)
			if(c[k]=='2') c[k]='0';
		int i=0,j;
		for (;Math.pow(2,i)<c.length;i++)
		{
			int index=((int) Math.pow(2, i))-1;
			int parity=0;
			System.out.println(index);
			for(j=0;j<c.length;j++)
			{
				int test=((j+1)>>i);
				if(test%2==1) 
				{
					if(c[j]=='1') parity=(parity+1)%2;
				}
			}
			if(parity==1) c[index]='1';
			else c[index]='0';
			//System.out.println(c);
		}
		String toReturn = new String(c);
		System.out.println(toReturn);
		return toReturn;
	}
	public String receiver_side(String s)
	{
		int r=(int) Math.ceil(logBase2(s.length()));
		int i;
		char ch[]=s.toCharArray();
		StringBuffer par=new StringBuffer("");
		for(i=0;i<r;i++)
		{
			int index=(int) Math.pow(2, i);
			int parity=0;
			for(int j=0;j<ch.length;j++)
			{
				int test=((j+1)>>i);
				if(test%2==1)
				{
					if(ch[j]=='1') parity=(parity+1)%2;
				}
			}
			if(parity%2==1) par.append("1");
			else par.append("0");
		}
		String pr=par.reverse().toString();
		int pos=Integer.parseInt(pr, 2);
		if(pos==0) {System.out.println("No error :" + pos); return s;}
		else {System.out.println("Error at position :" + pos);String str=removeError(s, pos); 
		return str;}
	
	}
	public String removeError(String str,int pos)
	{
		char c[]=str.toCharArray();
		if(c[pos-1]=='0') c[pos-1]='1';
		else c[pos-1]='0';
		String toReturn=new String(c);
		return toReturn;
	}
	public String convertToOriginal(String s)
	{
		String bitvalue="";
		int r=(int)Math.ceil(logBase2(s.length()));
		for (int i=0,j=0;i<s.length();i++)
		{
			if((i+1)!=(int)Math.pow(2, j)) bitvalue+=s.charAt(i)+"";
			else j++;
		}
		int ascii=Integer.parseInt(bitvalue, 2);
		String ch=((char)ascii)+"";
		return ch;
	}
	public String injectError(String str)
	{
		int len=str.length();
		int index=(int)Math.random()%len;
		
		char c[]=str.toCharArray();
		
		if(c[index]=='0') c[index]='1';
		else c[index]='0';
		String toReturn =new String(c);
		
		return toReturn;
	}
	public String chooseFrame(String str)
	{
		Iterable<String> result = Splitter.fixedLength(12) 
                .trimResults() 
                .split(str);
		
		int i=0,frameNo=(int)Math.random()%((int)(str.length()/12));
		String toReturn="";
		for(String test : result)
		{	
			if(i==frameNo)
			{
				toReturn+=injectError(test);	
			}
			else toReturn+=test;
			i++;
		}
		return toReturn;
	}
	public String luck(String str)
	{
		int i=(int)Math.random()%5;
//		if(i>0) {System.out.println("error induced");
		str=chooseFrame(str);
		return str;
	}

}
