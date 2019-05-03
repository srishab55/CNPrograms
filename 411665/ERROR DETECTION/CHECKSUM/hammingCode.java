
public class hammingCode {
	
	String Server_hamming(String str, int parity)
	{
		int r=0;
		while(Math.pow(2, r)<str.length()+r+1)
			r++;
		System.out.println(r);
		char arr[]=new char[(int) Math.pow(2, r)+1];
		for(int i=1,k=0;i<arr.length;i++)
		{	int x=(int) Math.floor( (Math.log10(i)/Math.log10(2)));
		System.out.println(x);
			if((i)!=(int)Math.pow(2, x)&&(k<str.length())) {System.out.println("index :"+k+" "+i); arr[i]=str.charAt(k++);}
			else arr[i]='0';
		}
		for(int i=1;i<arr.length;i++)
			System.out.print(arr[i]);
		System.out.println();
		for(int i=0;i<r;i++)
		{	
			int par=0;
			for(int j=0;j<arr.length;j++)
			if(((j)>>i)%2==1) {//&&(Math.pow(2, i)!=(j))) {
				System.out.print(" index: "+j+" "+arr[j]);
				if(arr[j]=='1') {par++;}   
			}
			
			if((par+parity)%(2)==0){ System.out.println("parity: "+par+" index: "+i);arr[(int) Math.pow(2, i)]='0';}
			else {System.out.println("parity: "+par+"index: "+i); arr[(int) Math.pow(2, i)]='1';}
		}
		for(int i=1;i<arr.length;i++)
		System.out.print(arr[i]);
		return null;
	}
	public static void main (String args[])
	{
		hammingCode hc=new hammingCode();
		hc.Server_hamming("11001", 0);
	}

}
