import java.util.*;
public class DistinctIslands_1 
{
    static int numDistinctIslands(int grid[][])
    {
        HashSet<String> set=new HashSet<>();
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
    static String bfs(int grid[][],int r,int c)
    {
        StringBuilder sb=new StringBuilder();
        Queue<int[]>q=new LinkedList<>();
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        q.add(new int[]{r,c});
        grid[r][c]=0;
        while(!q.isEmpty())
        {
            int temp[]=q.peek();q.remove();
            int currRow=temp[0],currCol=temp[1];
            int relativeRow=r-currRow;
            int relativeCol=c-currCol;
            sb.append(relativeRow).append(",").append(relativeCol).append(";");
            for(int x=0;x<4;x++)
            {
                int nr=currRow+dr[x];
                int nc=currCol+dc[x];
                if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length) continue;
                if(grid[nr][nc]==1)
                {
                    grid[nr][nc]=0;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int grid[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++) grid[i][j]=sc.nextInt();
        }
        System.out.println(numDistinctIslands((grid)));
        sc.close();
    }
}
