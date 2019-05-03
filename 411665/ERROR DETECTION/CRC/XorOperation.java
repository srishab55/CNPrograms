

public class XorOperation {

	public static void main(String[] args) {
		XorOperation ob=new XorOperation();
		ob.xor("011010110110101101101001100", "1010");
	}
	public String xor(String dividend,String divisor)
	{
		int cur_index=0,end_index=divisor.length()-1;
		String zero="0000";
		String temp=divisor,temp1="",rem = null;
		{	temp1="0"+dividend.substring(0, divisor.length()-1);
				
			for(int i=0;i<dividend.length()-divisor.length();i++)
			{	
				  //System.out.println(rem);
				temp=divisor;
				rem=temp1.substring(1,temp1.length());
				rem+=dividend.charAt(i+divisor.length());
				temp1="";
				 
				  if(rem.charAt(0)=='0') temp=zero; 
				 
				  for(int j=0;j<divisor.length();j++)
				{	
					if(rem.charAt(j)==temp.charAt(j)) temp1+="0";
					else temp1+="1";
				}
				 // System.out.println(rem);
				  
				
			}
			String toReturn=rem.substring(1, rem.length());
			System.out.println(toReturn);
			return toReturn;
		}
	}

}
