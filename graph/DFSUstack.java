import java.io.*;
import java.util.*;
// This class represents a directed graph using adjacency list representation
class Graph 
{
	private int V;
	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}
	// Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		// Add w to v's list
		adj[v].add(w);
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[])
	{
		visited[v]=true;
		System.out.println(v+" ");
		for(int n:adj[v])
		{
		    if(!visited[n]) DFSUtil(n,visited);
		}
	}

	// The function to do DFS traversal. It uses interactive DFSUtil()
	void DFS(int v)
	{
		// Mark all the vertices as not visited(set as false by default in java)
		boolean visited[] = new boolean[V];

		// Call the interactive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        Graph graph = new Graph(numVertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
		
		System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();

		System.out.println("Depth First Traversal");

		graph.DFS(startVertex);	
	}
}
