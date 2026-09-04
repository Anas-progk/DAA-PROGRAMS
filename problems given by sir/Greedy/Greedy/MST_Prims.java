/*Minimum Spanning Tree using Prim's Algorithm

You are given a connected, weighted, undirected graph represented as an adjacency matrix of size V x V, where V is the number of vertices. A value of 0 indicates that there is no edge between the corresponding pair of vertices (except the diagonal entries).

Your task is to construct the Minimum Spanning Tree (MST) of the given graph using Prim's Algorithm.

A Minimum Spanning Tree is a subset of the graph's edges that:

* Connects all the vertices.
* Contains exactly V - 1 edges.
* Has the minimum possible total edge weight.
* Does not contain any cycles.

Assume that the algorithm always starts from vertex 0.

For each vertex (except the starting vertex), print the edge through which it is included in the MST along with its corresponding weight.

Input Format
* The first line contains an integer V, representing the number of vertices.
* The next V lines each contain V space-separated integers representing the adjacency matrix of the graph.
* graph[i][j] = 0 indicates that there is no edge between vertices i and j (except when i == j).

Output Format
Print the edges of the Minimum Spanning Tree in the following format:


Edge    Weight
u - v   w
where:
* u is the parent vertex,
* v is the current vertex,
* w is the weight of the edge connecting them.

Print the edges in the order of vertex numbers from 1 to V - 1.

Constraints

* 2 <= V <= 100
* 0 <= graph[i][j] <= 10^6
* The graph is connected.
* The graph is undirected.
* graph[i][j] = graph[j][i]
* graph[i][i] = 0

Sample Input 1
5
0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0


Sample Output 1
Edge    Weight
0 - 1   2
1 - 2   3
0 - 3   6
1 - 4   5


Sample Input 2


5
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0


Sample Output 2
Edge    Weight
0 - 1   6
0 - 2   5
4 - 3   7
1 - 4   5
*/

import java.io.*;
import java.lang.*;
import java.util.*;
class MST_Prims 
{
	// Number of vertices in the graph
	static int V;
	/*A utility function to find the vertex with minimum key value, from the set of vertices not yet included in MST*/
	int minKey(int key[], Boolean mstSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
		{
			if (mstSet[v] == false && key[v] < min) 
			{
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
	// A utility function to print the constructed MST stored in parent[]
	void printMST(int parent[], int graph[][])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t"	+ graph[i][parent[i]]);
	}
	/*Function to construct and print MST for a graph represented using adjacency matrix representation*/
	void primMST(int graph[][])
	{
		// Array to store constructed MST
		int parent[] = new int[V];
		
		// Key values used to pick minimum weight edge
		int key[] = new int[V];
		
		// To represent set of vertices included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) 
		{
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		/*Always include first  vertex in MST. Make key 0 so that this vertex is picked as first vertex*/
		key[0]= 0;

		// First node is always root of MST
		parent[0] = -1;

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) 
		{
			// Pick the minimum key vertex from the set of vertices not yet included in MST
			int u = minKey(key, mstSet);
			System.out.println("min vertex " + u);
			
			// Add the picked vertex to the MST Set
			mstSet[u] = true;
			
			// Update key value and parent index of the adjacent vertices of the picked vertex. Consider only those vertices which are not yet included in MST
			for (int v = 0; v < V; v++)
				// graph[u][v] is non zero only for adjacent vertices of m mstSet[v] is false for vertices not yet included in MST Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) 
				{
					parent[v] = u;
					key[v] = graph[u][v];
				}
			System.out.println("KEY     - "+Arrays.toString(key));
			System.out.println("PARENT - "+Arrays.toString(parent));

			printMST(parent, graph);
		}
		// Print the constructed MST
		printMST(parent, graph);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		V = r;
		int[][] graph = new int[r][r];
		for(int i=0;i<r;i++){
			for(int j=0;j<r;j++)
				graph[i][j]=sc.nextInt();
		}
		MST_Prims t = new MST_Prims();
		t.primMST(graph);
	}
}


/*
Test Cases
case =1
input = 
5
0 2 0 6 0
2 0 3 8 5
0 3 0 0 7
6 8 0 0 9
0 5 7 9 0

output = 
Edge    Weight
0 - 1   2
1 - 2   3
0 - 3   6
1 - 4   5

case =2
input = 5 
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
output = 
Edge    Weight
0 - 1   6
0 - 2   5
4 - 3   7
1 - 4   5

case = 3
input = 9 
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
output =
Edge    Weight
0 - 1   4
1 - 2   8
2 - 3   7
3 - 4   9
2 - 5   4
5 - 6   2
6 - 7   1
2 - 8   2
*/