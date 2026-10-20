/*N cities are connected through roads, the cities are numbered from 0 to N-1. 
The roadmaps are given as a grid of size N*N, roadmap[][], 
the grid contains 0 and 1 as values grid[i][j]=0, indicates no road 
between i to j cities, grid[i][j]=1, indicates a road between i and j cities.

You are given an integer N, and the roadmap[][]of size N*N.
Your task is to find that there exists a loop in the roadmap, such that 
there exists a route consists of all the cities eaxctly once and the 
last city in the route should be connected to first city of the same route directly.

If you found such route print the route, otherwise print "No Solution"

Input Format:
-------------
Line-1: An integer N, size of the chess board.
Next N lines: N space separated integers, 0 or 1.

Output Format:
--------------
Print any possible route or "No Solution".

Sample Input-1:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0

Sample Output-1:
----------------
0  1  2  4  3  0

Sample Input-2:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 0
0 1 1 0 0

Sample Output-2:
----------------
No Solution

*/

/* Solution of Hamiltonian Cycle problem using backtracking */
import java.util.*;
class HamiltonianCycle
{
	static int V;
	int path[];

	boolean isSafe(int v, int graph[][], int path[], int pos)
	{	 
		//WRITE YOUR CODE HERE
		
		//initiall check is there a path exist between pos-1 and v
		//if not, return false
		//otherwise, check is v already used or not
		//if so return false, otherwise return true
	}
	boolean hamCycleUtil(int graph[][], int path[], int pos)
	{
		//WRITE YOUR CODE HERE
		
		//BASE CONDITION
		//if 'pos' is V then check is there an edge exist between first and last(ie., pos-1). 
		//Return true if edge exist, false otherwise.
		
		
		//If pos is not V//
		/*Search for next vertex, update current pos in path.
		Call hamCycleUtil() for next pos.
		backtrack if a dead end encountered*/
	}
	int hamCycle(int graph[][])
	{
		path = new int[V];
		for (int i = 0; i < V; i++)
			path[i] = -1;
		path[0] = 0;
		if (hamCycleUtil(graph, path, 1) == false)
		{
			System.out.println("No Solution");
			return 0;
		}
		printSolution(path);
		return 1;
	}

	void printSolution(int path[])
	{
//		System.out.println("Solution Exists: Following is one Hamiltonian Cycle");
		for (int i = 0; i < V; i++)
			System.out.print(path[i] + " ");
		System.out.println(path[0]);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		V = sc.nextInt();
		int graph[][]=new int[V][V];
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				graph[i][j]=sc.nextInt();
		HamiltonianCycle obj = new HamiltonianCycle();
		obj.hamCycle(graph);
	}
}

public class HamiltonianCycle {
    
}
/*
import java.util.*;
class HamiltonianCycle
{
	static int V;
	int path[];

	boolean isSafe(int v, int graph[][], int path[], int pos)
	{
		// no road between the previous city and v -> not safe
		if (graph[path[pos - 1]][v] == 0)
			return false;

		// v is already in the route -> not safe
		for (int i = 0; i < pos; i++)
			if (path[i] == v)
				return false;

		return true;
	}

	boolean hamCycleUtil(int graph[][], int path[], int pos)
	{
		// all cities placed -> check road from last city back to first
		if (pos == V)
			return graph[path[pos - 1]][path[0]] == 1;

		// try every city (1 to V-1) at this position
		for (int v = 1; v < V; v++)
		{
			if (isSafe(v, graph, path, pos))
			{
				path[pos] = v;                          // place city v

				if (hamCycleUtil(graph, path, pos + 1)) // try to fill the next position
					return true;

				path[pos] = -1;                         // dead end -> undo (backtrack)
			}
		}
		return false;
	}

	int hamCycle(int graph[][])
	{
		path = new int[V];
		for (int i = 0; i < V; i++)
			path[i] = -1;
		path[0] = 0;
		if (hamCycleUtil(graph, path, 1) == false)
		{
			System.out.println("No Solution");
			return 0;
		}
		printSolution(path);
		return 1;
	}

	void printSolution(int path[])
	{
		for (int i = 0; i < V; i++)
			System.out.print(path[i] + " ");
		System.out.println(path[0]);
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		V = sc.nextInt();
		int graph[][]=new int[V][V];
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				graph[i][j]=sc.nextInt();
		HamiltonianCycle obj = new HamiltonianCycle();
		obj.hamCycle(graph);
	}
}
 */