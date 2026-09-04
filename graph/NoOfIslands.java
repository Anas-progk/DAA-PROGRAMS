/*Input M*N Grid where 0s represent water and 1s represent land. 
Island is land surrounded by water. We can traverse in 8 directions.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid.
Next M lines: contains N space-separated integers(0/1).

Output Format:
--------------
Print an integer, the number of islands in the grid.

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
1


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
3

*/
import java.util.*;

public class NoOfIslands 
{
    public static void displayGrid(int[][] grid)
	{
		//W Y C H
	}
	public static int solve(int[][] grid) 
	{
        //W Y C H
    }
    
    private static void bfs(int[][] grid, int i, int j)
	{
        //W Y C H
    }

    public static void main(String[] args) 
	{
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }
       System.out.println(new NoOfIslands().solve(board));
    }
}