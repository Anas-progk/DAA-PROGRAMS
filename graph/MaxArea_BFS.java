/*
Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or 
diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

*/
import java.util.*;

public class MaxArea_BFS 
{
    public static int solve(int[][] grid) 
	{
        //WRITE YOUR CODE HERE
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int sum=bfs(grid,i,j);
                    max=Math.max(max,sum);
                }
            }
        }
        return max;
    }
    
    private static int bfs(int[][] grid, int k, int l)
	{
        //WRITE YOUR CODE HERE
        Queue<int[]>q=new LinkedList<>();
        int dr[]={-1,-1,-1,0,0,1,1,1};
        int dc[]={-1,0,1,-1,1,-1,0,1};
        q.add(new int[]{k,l});
        grid[k][l]=0;
        int count=1;
        while(!q.isEmpty())
        {
            int[] temp=q.peek();q.remove();
            int row=temp[0],col=temp[1];
            for(int x=0;x<8;x++)
            {
                int nr=row+dr[x];
                int nc=col+dc[x];
                if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length) continue;
                if(grid[nr][nc]==1)
                {
                    grid[nr][nc]=0;
                    q.add(new int[]{nr,nc});
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) 
	{
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                board[i][j] = in.nextInt();

       System.out.println(solve(board));
       in.close();
    }
}