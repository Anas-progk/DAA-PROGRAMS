/* write a java program to implement Minimum Cost Spanning Tree using Krushkal's algorithm
 
 input format :
        two integers m and n
        m number of rows each contains 3 integers
output format:
        an integer
Example :
input =4 5
0 1 3
0 2 5
1 2 4
2 3 1
1 3 5
output =8


Note : if spanning treee is not possible i.e E<V-1 then print -1
  */
import java.util.*;
class kruskal 
{
	// A class to represent a graph edge
	class Edge implements Comparable<Edge>
	{
		int src, dest, weight;
		// Comparator function used for sorting edges based on their weight
		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
		
	};
	// A class to represent a subset for union-find
	class subset
	{
		int parent, rank;
	};
	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // collection of all edges
	// Creates a graph with V vertices and E edges
	kruskal(int v, int e)
	{
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}
	// A utility function to find set of an element i (uses path compression technique)
	int find(subset subsets[], int i)
	{
	    //WRITE YOUR CODE HERE
	}
	// A function that does union of two sets of x and y (uses union by rank)
	void Union(subset subsets[], int x, int y)
	{
		//WRITE YOUR CODE HERE
	}
	/*
	1) Sort edges by ascending edge weight
	2) Walk through the sorted edges and look at the two nodes the edge belong to. If the nodes are
	already unified we dont include this edge, otherwise we include it and unify the nodes
	3) The algorithm terminates when every edge has been processed or all the vertices have been unified
	*/
	void KruskalMST()
	{
		//WRITE YOUR CODE HERE
        Arrays.sort(edge);
        subset subsets[]=new subset[V];
		System.out.println(minimumCost);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
        if (E < V-1)
        {
			System.out.println("-1");
        }
		else{
		kruskal graph = new kruskal(V, E);
		for(int i = 0; i < E; i++)
		{
			graph.edge[i].src = sc.nextInt();
			graph.edge[i].dest = sc.nextInt();
			graph.edge[i].weight = sc.nextInt();
		}
		graph.KruskalMST();
		}
	}
}
