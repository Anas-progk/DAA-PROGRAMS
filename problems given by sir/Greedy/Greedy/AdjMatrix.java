/*U2_DAA_Greedy_Method_AP25_Adjacency_Matrix
------------------------------------------
You are given V vertices representing a graph with V nodes. 
The graph is undirected, and your task is to represent this graph using an adjacency matrix.

Adjacency Matrix: An adjacency matrix is a 2D array of size V x V where:
	matrix[i][j] = 1 indicates that there is an edge between vertex i and vertex j.
	matrix[i][j] = 0 indicates that there is no direct edge between vertex i and vertex j.

Add Edge: Implement a function to add edges between two vertices i and j. 
Since the graph is undirected, an edge from i to j implies an edge from j to i.

Display Matrix: Implement a function to display the adjacency matrix.

Input Format:
-------------
Line-1: An integer V, the number of vertices.
Line-2: An integer E, the number of edges.
Next E lines: Two integers i and j for each line, representing an edge between vertices i and j.

Output Format:
---------------
Print the adjacency matrix of the graph after adding all edges.

Constraints:
------------
*1 <= V <= 20 (Maximum of 20 vertices)
*0 <= i, j < V (Valid vertex indices)
*0 <= E <= V*(V-1)/2 (Maximum number of edges for an undirected graph)

Sample Input-1:
---------------
4
4
0 1 10
0 2 5
1 2 7
2 3 9

Sample Output-1:
----------------
0 1 1 0 
1 0 1 0 
1 1 0 1 
0 0 1 0 

Sample Input-2:
---------------
5
5
0 1
0 4
1 3
1 2
3 4

Sample Output-2:
----------------
0 1 0 0 1 
1 0 1 1 0 
0 1 0 0 0 
0 1 0 0 1 
1 0 0 1 0 
*/

import java.util.Scanner;

public class AdjMatrix
{
    // Function to add an edge to the adjacency matrix
    public static void addEdge(int[][] mat, int i, int j, int w) 
	{
        mat[i][j] = w;
        mat[j][i] = w; // Since the graph is undirected
    }

    // Function to display the adjacency matrix
    public static void displayMatrix(int[][] mat) 
	{
        for (int[] row : mat) 
		{
            for (int val : row)
                System.out.print(val + " ");
            
            System.out.println();
        }
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.println("Enter the number of vertices:");
        int V = sc.nextInt();

        //Create a matrix to represent the graph with V vertices
        int[][] mat = new int[V][V];

        // Input the number of edges
        System.out.println("Enter the number of edges:");
        int E = sc.nextInt();

        // Input edges and update the adjacency matrix
        System.out.println("Enter the edges (two space-separated integers for each edge):");
        for (int i = 0; i < E; i++) 
		{
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(mat, u, v, w);
        }

        // Display the adjacency matrix
        System.out.println("Adjacency Matrix Representation:");
        displayMatrix(mat);
    }
}


/*
case = 1
input =4
3
0 1
1 2
2 3
output =0 1 0 0 
1 0 1 0 
0 1 0 1 
0 0 1 0

case = 2
input =5
0
output =0 0 0 0 0 
0 0 0 0 0 
0 0 0 0 0 
0 0 0 0 0 
0 0 0 0 0
 
case = 3
input =3
3
0 1
0 2
1 2
output =0 1 1 
1 0 1 
1 1 0 

case = 4
input =3
1
0 0
output =1 0 0
0 0 0 
0 0 0 

case = 5
input =6
7
0 1
1 2
2 3
3 4
4 5
0 3
2 4
output =0 1 0 1 0 0 
1 0 1 0 0 0 
0 1 0 1 1 0 
1 0 1 0 1 0 
0 0 1 1 0 1 
0 0 0 0 1 0 

case = 6
input =5
2
0 1
3 4
output =0 1 0 0 0 
1 0 0 0 0 
0 0 0 0 0 
0 0 0 0 1 
0 0 0 1 0 

case = 7
input =1
0
output =0 

case = 8
input =3
3
0 1
0 1
0 1
output =0 1 0 
1 0 0 
0 0 0 

case = 9
input =10
0
output =0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 0 0 

case = 10
input =5
4
0 1
1 2
2 3
3 4
output =0 1 0 0 0 
1 0 1 0 0 
0 1 0 1 0 
0 0 1 0 1 
0 0 0 1 0 

*/