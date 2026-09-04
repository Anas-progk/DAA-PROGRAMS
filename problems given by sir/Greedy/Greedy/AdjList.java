/*U2_DAA_Greedy_Method_AP24_Adjacency_List
----------------------------------------
You are given a graph with V vertices and E edges. 
Your task is to represent this graph using an adjacency list. 
In this representation, each vertex has a list of adjacent vertices, 
showing which vertices it is connected to.

The graph is undirected, meaning if there is an edge between vertex u and vertex v, 
then both u is connected to v and v is connected to u.

Input Format:
-------------
Line-1: An integer V representing the number of vertices.
Line-2: An integer E representing the number of edges.
Next E Lines: The next E lines each contain two integers u and v representing an edge between vertices u and v.

Output Format:
--------------
Print the adjacency list of the graph, where each vertex's adjacent vertices are space-separated.

Constraints:
------------
*2 <= V <= 1000 (The number of vertices)
*0 <= u, v < V (Valid vertices indices)
*0 <= E <= V*(V-1)/2 (Maximum number of edges for an undirected graph)

Sample Input-1:
---------------
5
4
0 1
0 2
1 3
3 4

Sample Output-1:
----------------
0: 1 2
1: 0 3
2: 0
3: 1 4
4: 3

Explanation:
------------
Vertex 0 is connected to vertices 1 and 2.
Vertex 1 is connected to vertices 0 and 3.
Vertex 2 is connected to vertex 0.
Vertex 3 is connected to vertices 1 and 4.
Vertex 4 is connected to vertex 3.

Sample Input-2:
---------------
3
2
0 1
2 1

Sample Output-2:
---------------
0: 1
1: 0 2
2: 1
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjList 
{    
    // Method to add an edge between two vertices
    public static void addEdge(List<List<Integer>> adj, int i, int j) 
	{
        //WRITE YOUR CODE HERE
        adj.get(i).add(j);
        if (i != j)  // Only add the reverse edge if it's not a self-loop.
        	adj.get(j).add(i); // Undirected graph  	
    }

    // Method to display the adjacency list
    public static void displayAdjList(List<List<Integer>> adj) 
	{
        //WRITE YOUR CODE HERE
        //System.out.println("Adjacency List Representation:");
        for (int i = 0; i < adj.size(); i++) 
		{
            System.out.print(i + ": "); // Print the vertex
            for (int j : adj.get(i)) 
                System.out.print(j + " "); // Print its adjacent vertices
            
            System.out.println(); 
        }
    }

    // Main method
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        int V = sc.nextInt();
        int E = sc.nextInt();

        // Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>(V); 
        for (int i = 0; i < V; i++) 
            adj.add(new ArrayList<>());

        // Input edges and update the adjacency list
        for (int i = 0; i < E; i++) 
		{
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adj, u, v);
        }

        // Display the adjacency list
        displayAdjList(adj);
    }
}
/*
case = 1
input =5
4
0 1
0 2
1 3
3 4
output =0: 1 2
1: 0 3
2: 0
3: 1 4
4: 3

case = 2
input =4
0
output=
0: 
1: 
2: 
3: 

case = 3
input =4
6
0 1
0 2
0 3
1 2
1 3
2 3
output=0: 1 2 3
1: 0 2 3
2: 0 1 3
3: 0 1 2


case = 4
input =3
1
0 0
output=0: 0
1: 
2: 


case = 5
input =5
3
0 1
2 3
4 4
output=0: 1
1: 0
2: 3
3: 2
4: 4


case = 6
input =10
2
0 9
1 8
output=0: 9
1: 8
2: 
3: 
4: 
5: 
6: 
7: 
8: 1
9: 0


case = 7
input =1
1
0 0
output=0: 0


case = 8
input =4
2
0 1
2 2
output=0: 1
1: 0
2: 2
3: 


case = 9
input =5
4
0 1
1 2
2 3
3 4
output=0: 1
1: 0 2
2: 1 3
3: 2 4
4: 3


case = 10
input =10
10
0 1
0 2
1 3
1 4
2 5
3 6
4 7
5 8
6 9
7 9
output=0: 1 2
1: 0 3 4
2: 0 5
3: 1 6
4: 1 7
5: 2 8
6: 3 9
7: 4 9
8: 5
9: 6 7
*/