import java.io.*;
import java.lang.*;
import java.util.*;
class MST 
{
	// Number of vertices in the graph
	static int V;
	/*A utility function to find the vertex with minimum key value, 
	from the set of vertices not yet included in MST*/
	int minKey(int key[], Boolean mstSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;
		
		//WRITE YOUR CODE HERE
		
		return min_index;
	}
	// A utility function to print the constructed MST stored in parent[]
	void printMST(int parent[], int graph[][])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t"	+ graph[i][parent[i]]);
	}
	/*Function to construct and print MST for a graph represented 
	using adjacency matrix representation*/
	void primMST(int graph[][])
	{
		// Array to store constructed MST
		int parent[] = new int[V];
		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];
		// To represent set of vertices included in MST
		Boolean mstSet[] = new Boolean[V];
		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) 
		{
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		/*Always include first  vertex in MST. 
		Make key 0 so that this vertex is picked as first vertex*/
		key[0] = 0;

		// First node is always root of MST
		parent[0] = -1;

	    //Write Your Code Here
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		V = r;
		int[][] graph = new int[r][r];
		for(int i=0;i<r;i++)
			for(int j=0;j<r;j++)
				graph[i][j]=sc.nextInt();

		MST t = new MST();
		t.primMST(graph);
	}
}