/*
Write A program for Dijkstra's single source shortest path algorithm.
Input N, NxN adjacency matrix and Source vertex number.
Display results as shown in examples.

Example 1:
input=5 
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2
output=
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Example 2:
input =9 
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6
*/


// A Java program for Dijkstra's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.util.*;
import java.lang.*;
import java.io.*;
class ShortestPath 
{
	static int V;
	int minDistance(int dist[], Boolean Visited[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
		{
			if (Visited[v] == false && dist[v] <= min) 
			{
				min = dist[v];
				min_index = v;
			}
		}
		return min_index;
	}

	void printSolution(int dist[],Boolean Visited[])
	{
		System.out.println("Vertex \t\t Distance from Source \t Visit State");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]+" \t\t\t "+Visited[i]);
	}

	void dijkstra(int graph[][], int src)
	{
		int dist[] = new int[V]; 

		Boolean Visited[] = new Boolean[V];
		for (int i = 0; i < V; i++) 
		{
			dist[i] = Integer.MAX_VALUE;
			Visited[i] = false;
		}

		dist[src] = 0;
	
		for (int i = 0; i <= V - 1; i++) 
		{
			System.out.println("\nCURRENT STATE");
			printSolution(dist,Visited);
			int u = minDistance(dist, Visited);
			System.out.println("Min Distance Node "+u);
			Visited[u] = true;

			for (int v = 0; v < V; v++)
			{
				if (
					!Visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]
					)
						dist[v] = dist[u] + graph[u][v];
			}
		}
		printSolution(dist,Visited);
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
		ShortestPath t = new ShortestPath();
		int srcVertex = sc.nextInt();
		t.dijkstra(graph, srcVertex);
	}
}
