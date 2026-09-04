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


Note : if spanning treee is not possible i.r E<V-1 then print -1
  */
import java.util.*;
class MCSTKruskal 
{
	// A class to represent a graph edge
	class Edge implements Comparable<Edge>
	{
		int src, dest, weight;

		public int compareTo(Edge compareEdge)
		{
			return this.weight - compareEdge.weight;
		}
		
		public String toString()
		{
			return src + " " + dest + " " + weight;
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
	MCSTKruskal(int v, int r)
	{
		V = v;
		E = r;
		edge = new Edge[E];
		for (int i = 0; i < r; ++i)
			edge[i] = new Edge();
	}
	// A utility function to find set of an element i (uses path compression technique)
	int find(subset subsets[], int i)
	{
		// find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	// A function that does union of two sets of x and y (uses union by rank)
	void Union(subset subsets[], int x, int y)
	{
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		
		// Attach smaller rank tree under root of high rank tree (Union by Rank)
		if (subsets[xroot].rank	< subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		// If ranks are same, then make one as root and increment its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	/*
	1) Sort edges by ascending edge weight
	2) Walk through the sorted edges and look at the two nodes the edge belong to. If the nodes are already unified we dont include this edge, otherwise we include it and unify the nodes
	3) The algorithm terminates when every edge has been processed or all the vertices have been unified
	*/
	void KruskalMST()
	{
		Edge result[] = new Edge[V];

		int r = 0;				// An index variable, used for result[]
		int i = 0;
		for (i = 0; i < V; ++i)
			result[i] = new Edge();

		// Step 1: Sort all the edges in non-decreasing order of their weight. 
		Arrays.sort(edge);

		// Allocate memory for creating V subsets
		subset subsets[] = new subset[V];
		for (i = 0; i < V; ++i)
			subsets[i] = new subset();

		// Create V subsets with single elements
		for (int v = 0; v < V; ++v)
		{
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0; // Index used to pick next edge
		// Number of edges to be taken is equal to V-1
		while (r < V - 1)
		{
// Step 2: Pick the smallest edge. And increment the index for next iteration
			Edge next_edge = edge[i++];
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
		
			// If including this edge doesn't cause cycle, include it in result and increment the index of result for next edge
			if (x != y) 
			{
				result[r++] = next_edge;
				Union(subsets, x, y);
			}
		}
		
		int minimumCost = 0;
		for (i = 0; i < r; ++i)
		{
			minimumCost += result[i].weight;
		}

		System.out.println(minimumCost);
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		if (E < V-1)
			System.out.println("-1");
		else
		{
			MCSTKruskal graph = new MCSTKruskal(V, E);
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
  
  
  
  /*
test cases
case =1
input =4 5
0 1 3
0 2 5
1 2 4
2 3 1
1 3 5
output =8

case =2
input =6 12
0 1 4
1 2 5
0 2 4
1 3 3
2 3 7
0 3 6
1 4 7
2 4 8
3 4 3
5 4 8
5 3 7
1 5 9
output =21

case =3
input =5 3
0 1 2
0 2 4
1 2 3
output =-1

case =4
input =6 15
0 1 8
0 2 9
0 3 10
0 4 13
0 5 9
1 2 7
1 4 8
1 3 8
5 1 8
2 3 7
2 4 7
5 2 3
3 4 5
3 5 3
4 5 3
output =24

case =5
input =6 15
0 1 16
0 2 15
0 3 14
0 4 18
0 5 19
1 2 7
1 4 6
1 3 11
5 1 8
2 3 3
2 4 15
5 2 9
3 4 8
3 5 7
4 5 5
output =35

case =6
input =8 26
0 1 19
0 2 18
0 3 17
0 4 19
0 5 14
0 7 11
1 2 16
1 3 12
1 4 9
1 5 11
1 6 8
2 3 15
2 4 12
2 5 8
2 6 3
2 7 9
3 4 10
3 5 5
3 6 11
3 7 13
4 5 11
4 6 6
4 7 15
5 6 15
5 7 5
6 7 5
output =43

case =7
input =8 28
0 1 9
0 2 18
0 3 17
0 4 19
0 5 14
0 6 8
0 7 11
1 2 16
1 3 22
1 4 9
1 5 11
1 6 18
1 7 4
2 3 15
2 4 12
2 5 8
2 6 13
2 7 9
3 4 10
3 5 15
3 6 11
3 7 13
4 5 7
4 6 16
4 7 15
5 6 15
5 7 5
6 7 5
output =47

case =8
input =10 44
0 1 9
0 2 18
0 3 17
0 4 19
0 5 14
0 6 8
0 7 11
0 8 14
1 2 16
1 3 22
1 4 9
1 5 11
1 6 18
1 7 4
1 8 16
1 9 9
2 3 15
2 4 12
2 5 8
2 6 13
2 7 9
2 8 14
2 9 7
3 4 10
3 5 15
3 6 11
3 7 13
3 8 8
3 9 18
4 5 7
4 6 16
4 7 15
4 8 9
4 9 10
5 6 15
5 7 5
5 8 12
5 9 9
6 7 5
6 8 14
6 9 8
7 8 11
7 9 14
8 9 12
output =61
*/