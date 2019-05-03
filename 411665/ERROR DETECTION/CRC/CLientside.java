import java.io.DataInputStream;

import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import com.google.common.base.Splitter; 

public class CLientside {
	
	Socket socket;
	DataInputStream dis;
	String received;
	public CLientside() throws UnknownHostException, IOException {
	
		socket=new Socket("", 5000);
		System.out.println("Connected");
		received="";
		dis=new DataInputStream(socket.getInputStream());
		while(true) {
		received=dis.readUTF();
		//System.out.println(received);
		//received=makeString("010011100010010011010101011001000000010000010010100000");
		if(received==null) continue;
		received=makeString(received);
		if(received==null) System.out.println("There is some error in data");
		else 
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
		XorOperation xor=new XorOperation();
		String res=xor.xor(input, "1010");
		System.out.println(res);
		if(!res.equals("000")) return null;
		
		Iterable<String> result = Splitter.fixedLength(8) 
                .trimResults() 
                .split(input.substring(0, input.length()-3));
		
		for( String str : result)
		{
			if(str.length()==0) break;
			String st=str.substring(0, str.length());
			
			toReturn+= (char)Integer.parseInt(st, 2)+"";
		}
		//System.out.println(toReturn);
		return toReturn;
		
	}
}
