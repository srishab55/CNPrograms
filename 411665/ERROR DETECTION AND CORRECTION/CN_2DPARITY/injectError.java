import java.util.Random;

public class injectError {

	
	String injection(String binaryString)
	{
		String toReturn;
		System.out.println(binaryString);
		Random rand=new Random();
		int pos=rand.nextInt(binaryString.length());
		System.out.println(pos+" len:"+binaryString.length());
		char arr[]=binaryString.toCharArray();
		
		arr[pos]=(arr[pos]=='1'?'0':'1');
		String a=new String(arr);
		toReturn=a;
		return toReturn;
	}

}
