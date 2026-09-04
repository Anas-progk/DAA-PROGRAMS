/*
Viraj Aanand is a wedding planner, He order his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes, 
1 1  	   1 1
1     and    1 
are different.
*/

import java.util.*;

class DistinctIslands 
{
    public int numDistinctIslands(int[][] grid) 
	{
		HashSet<String>set=new HashSet<>();
		for(int i=0;i<grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				if(grid[i][j]==1)
				{
					String shape=bfs(grid,i,j);
					set.add(shape);
				}
			}
		}
		return set.size();
	}

	private String bfs(int[][] grid, int row, int col) 
	{
		StringBuilder shape=new StringBuilder();
		Queue<int[]>q=new LinkedList<int[]>();
		q.add(new int[]{row,col});
		grid[row][col]=0;
		int dr[]={-1,1,0,0};
		int dc[]={0,0,-1,1};
		while(!q.isEmpty())
		{
			int curr[]=q.poll();
			int currRow=curr[0],currCol=curr[1];
			int relativeRow=currRow-row;
			int relativeCol=currCol-col;
			shape.append(relativeRow).append(",").append(relativeCol).append(";");
			for(int k=0;k<4;k++)
			{
				int newRow=currRow+dr[k];
				int newCol=currCol+dc[k];
				if(newRow>=grid.length || newRow<0 || newCol>=grid[0].length || newCol<0 || grid[newRow][newCol] !=1) continue;
				q.add(new int[]{newRow,newCol});
				grid[newRow][newCol]=0;
			}
		}
       return shape.toString();
    }
    
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				grid[i][j]=sc.nextInt();

		System.out.println(new DistinctIslands().numDistinctIslands(grid));
		sc.close();
	}
}

