import java.util.*;
public class MaxArea_BFS_1
{
    static int solve(int[][] grid)
    {
        int max=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int sum=bfs(grid,i,j);
                    max=Math.max(sum,max);
                }
            }
        }
        return max;
    }
    static int bfs(int grid[][],int r,int c)
    {
        Queue<int[]>q=new LinkedList<>();
        int dr[]={-1,-1,-1,0,0,1,1,1};
        int dc[]={-1,0,1,-1,1,-1,0,1};
        q.add(new int[]{r,c});
        grid[r][c]=0;
        int count=1;
        while(!q.isEmpty())
        {
            int temp[]=q.peek();q.remove();
            int currRow=temp[0],currCol=temp[1];
            for(int x=0;x<8;x++)
            {
                int nRow=currRow+dr[x];
                int nCol=currCol+dc[x];
                if(nRow<0 || nRow>=grid.length || nCol<0 || nCol>=grid[0].length) continue;
                if(grid[nRow][nCol]==1)
                {
                    grid[nRow][nCol]=0;
                    q.add(new int[]{nRow,nCol});
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int board[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) board[i][j]=sc.nextInt();
        }
        System.out.println(solve(board));
        sc.close();
    }
}