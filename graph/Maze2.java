/*You are entering into a maze N*N grid consist of(0's and 1's)
Initially you will start from (x1,y1) position in the maze, 
Your target is to reach the end position (x2, y2).

Among the four directions available(top, down, left, right),
you can move in two directions only, right and down.

In the maze, '0' indicates dead end and '1' indicates open way. 
You can travel through only open way.

For Example:-
Given Maze of size N=4 , starting position is (0, 0),
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

You can reach the (3, 3) position in the following way.
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

Return true, if you can reach the end position(N-1, N-1).
otherwise return false.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers
input x1, y1
input x2, y2

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1
0 0
3 3
Sample Output-1:
----------------
true


Sample Input-2:
---------------
4
1 1 0 0
1 1 0 1
0 1 1 0
1 0 0 1
1 0
2 3

Sample Output-2:
----------------
false
*/

import java.util.Scanner;
public class Maze 
{ 
	private int size; 

	Maze(int N)
	{
		this.size = N;
	}
	
	
	// Main method to solve the maze - acts as the entry point
	boolean solveMaze(int maze[][],int x1, int y1, int x2, int y2) 
	{ 
		//WRITE YOUR CODE HERE
	} 

	public static void main(String args[]) 
	{ 
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Maze m = new Maze(n); 
		int maze[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				maze[i][j]=sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		System.out.println(m.solveMaze(maze,x1,y1,x2,y2)); 
	} 
} 

