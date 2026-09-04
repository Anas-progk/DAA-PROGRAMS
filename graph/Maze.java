There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, 
but it won't stop rolling until hitting a wall. When the ball stops, 
it could choose the next direction.

Given the ball's start position, the destination and the maze, 
determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means 
the empty space. You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.

Example 1
Input 1: a maze represented by a 2D array 0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
*/


import java.util.*;
public class Maze
 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination)
    {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited)
     {
        //WRITE YOUR CODE HERE
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter number of rows");
		int m=sc.nextInt();
		//System.out.println("Enter number of columns");
		int n=sc.nextInt();
		int maze[][]=new int[m][n];
		int start[]=new int[2];
		int destination[]=new int[2];
		//System.out.println("Enter matrix elements");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				maze[i][j]=sc.nextInt();

		//System.out.println("Enter start coordinates");
		for(int i=0;i<2;i++)
			start[i]=sc.nextInt();

		//System.out.println("Enter end coordinates");
		for(int i=0;i<2;i++)
			destination[i]=sc.nextInt();
		
		System.out.println(new Maze().hasPath(maze,start,destination));
	}
}
