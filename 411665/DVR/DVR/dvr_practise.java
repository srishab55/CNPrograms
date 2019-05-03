import java.util.Scanner;

public class dvr_practise {
	static int Graph[][];
	static int rt[][];
	static int via[][];
	static int e,v;
	static int INT_MAX=9999;
	public static void main (String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("no of edges");
		e=sc.nextInt();
		System.out.println("No of vertices");
		v=sc.nextInt();
		
		Graph=new int[v][v];
		rt=new int[v][v];
		via=new int[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(i==j) Graph[i][j]=0;
				else Graph[i][j]=INT_MAX;
			}
		}
		
		for(int i=0;i<e;i++)
		{
			System.out.println("Enter source");
			int s=sc.nextInt();
			System.out.println("ENter destination");
			int d=sc.nextInt();
			System.out.println("Enter distance");
			Graph[s-1][d-1]=sc.nextInt();
			Graph[d-1][s-1]=Graph[s-1][d-1];
		}
		
		for(int i = 0; i < v; i++)
		  {
		   for(int j = 0; j < v; j++)
		   {
		    if(i == j)
		    {
		     rt[i][j] = 0;
		     via[i][j] = i;
		    }
		    else
		    {
		     rt[i][j] = INT_MAX;
		     via[i][j] = 100;
		    }
		   }
		  }
		int k=0;
		for(int l=0;l<v;l++)
		{
			for(int i=0;i<v;i++)
			{
				if(Graph[l][i]!=INT_MAX)
				{
					int dis=Graph[l][i];
					for(int j=0;j<v;j++)
					{
						int mid_dis=rt[i][j];
						if(via[i][j]==k) mid_dis=INT_MAX;
						if(dis+mid_dis<rt[k][j])
						{
							rt[k][j]=dis+mid_dis;
							rt[j][k]=rt[k][j];
							via[k][j]=i;
							via[j][k]=i;
						}
					}
				}
			}
			k++;
		}
		
		for(int i=0;i<v;i++)
		{
			for (int j=0;j<v;j++)
			{
				System.out.print(rt[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
