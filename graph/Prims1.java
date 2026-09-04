import java.util.*;
public class Prims1 {
    public static void addEdge(int[][] adj,int i,int j,int w)
    {
        adj[j][i]=w;
        adj[i][j]=w;
    }
    public static void displayMatrix(int[][] mat) {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat.length;j++) System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }
    public static void MST(int[][]adj,int V)
    {
        boolean[] visited=new boolean[V];
        int[] key=new int[V];
        int[] parent=new int[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        parent[0]=-1;
        PriorityQueue<int[]>pq=new PriorityQueue<>((x,y)->x[0]-y[0]);
        pq.add(new int[]{0,0});//weight and vertex
        while(!pq.isEmpty())
        {
            int[] top=pq.poll();
            int vertex=top[1];
            int weight=top[0];
            if(visited[vertex]) continue;
            visited[vertex]=true;
            //check all neighbours of vertex
            for(int i=0;i<V;i++)
            {
                if(adj[vertex][i] !=0 && !visited[i] && adj[vertex][i]<key[i])
                {
                    key[i]=adj[vertex][i];
                    parent[i]=vertex;
                    pq.add(new int[]{key[i],i});
                }
            }
        }
        //building mst as adjacency matrix to display
        int [][] mst=new int[V][V];
            for(int i=1;i<V;i++)
            {
                int p=parent[i];
                int weight=adj[p][i];
                mst[p][i]=weight;
                mst[i][p]=weight;
            }
        displayMatrix(mst);
    }
    public static void main(String[] args)
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter no of Vertices");
    int V=sc.nextInt();    
    System.out.println("Enter no of edges");
    int E=sc.nextInt();
    int[][] adj=new int[V][V];
    System.out.println("Enter the edges with weight(three space-separated integers for each edge):");
    for(int i=0;i<E;i++)
    {
        int u=sc.nextInt();
        int v=sc.nextInt();
        int weight=sc.nextInt();
        addEdge(adj,u,v,weight);
    }
    MST(adj,V);
    sc.close();
    }
}
