/*
Dijkstra’s algorithm os to find the Shortest Routes in a Graph or a Tree 
with the help of Examples:

Dijkstra’s Algorithm:
Given a weighted graph and a starting (source) vertex in the graph, 
Dijkstra’s algorithm is used to find the shortest distance from the 
source node to all the other nodes in the graph.
As a result of the running Dijkstra’s algorithm on a graph, we obtain the 
shortest path tree (SPT) with the source vertex as root.
In Dijkstra’s algorithm, we maintain two sets or lists. 
One contains the vertices that are a part of the shortest-path tree (SPT) 
and the other contains vertices that are being evaluated to be included in SPT. 
Hence for every iteration, we find a vertex from the second list that has 
the shortest path.


Using Adjacency Matrix:
sample Example:
{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
{ 0, 0, 2, 0, 0, 0, 6, 7, 0 }
Vertex          Distance from Source
0                  0
1                  4
2                  12
3                  19
4                  21
5                  11
6                  9
7                  8
8                  14


Time Complexity: O(V2)
Auxiliary Space: O(V)


*/
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Test
{
	void dijkstra(int graph[][], int src)
	{
		//WRITE YOUR CODE HERE. IF REQUIRED, DEFINE THRE REQUIRED METHODS
		printSolution(dist);
	}

	public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		//enter row  size of the matrix
		int x=sc.nextInt();
		//enter column  size of the matrix
		int y=sc.nextInt();
			
			int graph[][]= new int[x][y];
			
		//input adjacency matrix
		for (int i=0;i<x;i++)
		{
		    for(int j=0;j<y;j++)
		    {
	        	graph[i][j]=sc.nextInt();
		    }
		}
		
		Test t = new Test();

		// Function call
		t.dijkstra(graph, 0);
	}
}
// This code is contributed by Aakash Hasija
