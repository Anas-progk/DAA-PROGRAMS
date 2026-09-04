import java.util.*;
@SuppressWarnings("unchecked")
public class DFS_REC_1 
{
    private int V;
    private LinkedList<Integer> adj[];
    DFS_REC_1(int v)
    {
        V=v;
        adj=new LinkedList[V];
        for(int i=0;i<V;i++) adj[i]=new LinkedList<Integer>();
    }
     void addEdge(int end1,int end2)
    {
        adj[end1].add(end2);
        adj[end1].add(end1);
    }
    void DFS(int v)
    {
        boolean visited[]=new boolean[v];
        helper(v,visited);
    }
    void helper(int vertex,boolean visited[])
    {
        visited[vertex]=true;
        System.out.println(vertex+" ");
        for(int neighbor:adj[vertex])
        {
            if(!visited[neighbor]) helper(neighbor, visited);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        DFS_REC t=new DFS_REC(v);
        for(int i=0;i<e;i++)
        {
            int end1=sc.nextInt();
            int end2=sc.nextInt();
            t.addEdge(end1,end2);
        }
        System.out.println("Enter source of DFS");
        int src=sc.nextInt();
        t.DFS(src);
        sc.close();
    }
}
