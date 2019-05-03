import java.io.*;
public class DVR 
{
 static int graph[][];
 static int via[][];
 static int rt[][];
 static int v;
 static int e;
 static int POSITIVE_INFINITY=9999;

 public static void main(String args[]) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  System.out.println("Please enter the number of Vertices: ");
  v = Integer.parseInt(br.readLine());
  
  System.out.println("Please enter the number of Edges: ");
  e = Integer.parseInt(br.readLine());
  
  graph = new int[v][v];
  via = new int[v][v];
  rt = new int[v][v];
  for(int i = 0; i < v; i++)
   for(int j = 0; j < v; j++)
   {
    if(i == j)
     graph[i][j] = 0;
    else
     graph[i][j] = POSITIVE_INFINITY;
   }
  
  for(int i = 0; i < e; i++)
  {
   System.out.println("Please enter data for Edge " + (i + 1) + ":");
   System.out.print("Source: ");
   int s = Integer.parseInt(br.readLine());
   s--;
   System.out.print("Destination: ");
   int d = Integer.parseInt(br.readLine());
   d--;
   System.out.print("Cost: ");
   int c = Integer.parseInt(br.readLine());
   graph[s][d] = c;
   graph[d][s] = c;
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
     rt[i][j] = POSITIVE_INFINITY;
     via[i][j] = 100;
    }
   }
  }
  int k = 0;
  for(int l = 0; l <v; l++)
  {
	  for(int i = 0; i < v; i++)
	  {
	   if(graph[k][i] != POSITIVE_INFINITY)
	   {
	    int dis = graph[k][i];
	    for(int j = 0; j < v; j++)
	    { 
	     int mid_dis = rt[i][j];
	     if(via[i][j] == k)
	      mid_dis = POSITIVE_INFINITY;
	     if(dis + mid_dis < rt[k][j])
	     {
	      rt[k][j] = dis + mid_dis;
	      rt[j][k] = dis + mid_dis;
	      via[k][j] = i;
	      via[j][k] = i;

	     }
	    }
	   }
	  }
   k++;
  }
 
 
  for(int i = 0; i < v; i++)
  {
   for(int j = 0; j < v; j++)
   {
    System.out.print(rt[i][j] + "    ");
   }
   System.out.println();
  }
 
  }
}