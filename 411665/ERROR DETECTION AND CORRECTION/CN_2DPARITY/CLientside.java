import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.google.common.base.Splitter; 

public class CLientside {
	
	Socket socket;
	DataInputStream dis;
	String received;
	public CLientside() throws UnknownHostException, IOException {
	
		socket=new Socket("", 5000);
		System.out.println("Connected");
		
		dis=new DataInputStream(socket.getInputStream());
		while(true) {
		received=dis.readUTF();
		if(received==null) continue;
		System.out.println(received);
		received=makeString(received);
		//received=makeString(received);
		if(received!=null) 
		
			{
			System.out.println("The data is correct ");
			System.out.println(received);
			}
		}
		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {

		CLientside cs=new CLientside();
	}

	String makeString(String input)
	{
		String toReturn="";
		boolean flag=false;
		Iterable<String> result = Splitter.fixedLength(9) 
                .trimResults() 
                .split(input);
		int counter=0,count=0,fno = 0,cno = 0;
		ArrayList<String> res=new ArrayList<>();
		for( String str : result) res.add(str);
		for( String str : res)
		{	
			
			if(str.length()==0) break;
			String st=str.substring(0, str.length()-1);
			int asciibit=Integer.bitCount(Integer.parseInt(str, 2))%2;
			//System.out.println("ascii :"+asciibit);
			if(counter>res.size()-2) break;
			
			if  (asciibit==1) {
				
				int indexframe=counter+1,col_num=-1;
				for(int i=0;i<str.length();i++)
				{	int bit_count=0;
					for (int j=0;j<res.size();j++)
					{
						bit_count+=Integer.parseInt(res.get(j).charAt(i)+"");
					}
					if(bit_count%2==1)col_num=i+1; 
				}
				
				System.out.println("Error found ! \n Error at the frame number : "+indexframe+"\n Col number "+col_num);
				char c=res.get(indexframe-1).charAt(col_num-1);
				if(c=='0') c='1';
				else c='0';
				char arr[]=st.toCharArray();
				arr[col_num-2]=c;
				String s=new String(arr);
				
				String str1=res.get(fno).substring(0, cno)+c+res.get(fno).substring(cno+1);
				//str1=s;
				res.set(indexframe, str1);
				
				cno=col_num;fno=indexframe;//toReturn=null;break;
				flag=true;
				System.out.println("Error was rectified");
				}
			 st=str.substring(0, str.length()-1);
			toReturn+= (char)Integer.parseInt(st, 2)+"";
			System.out.println("char :" + toReturn);
			counter++;
		}
		//if (flag) return null;
		//System.out.println(toReturn);
		return toReturn;
		
	}
}
