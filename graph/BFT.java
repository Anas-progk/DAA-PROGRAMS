import java.util.*;
class Graph 
{
    private int numVertices;
    private LinkedList<Integer>[] adjList;
    public BFT(int numVertices) 
	{
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) 
		{
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination) 
	{
        adjList[source].add(destination);
        //adjList[destination].add(source);
    }
    public void BFS(int startVertex) 
	{
        Queue<Integer>q=new LinkedList<>();
        boolean visited[]=new boolean[numVertices];
        q.add(startVertex);
        visited[startVertex]=true;
        while(!q.isEmpty())
        {
            int curr=q.poll();
            System.out.println(curr+" ");
            for(int neighbour:adjList[curr])
            {
                if(visited[neighbour]) continue;
                visited[neighbour]=true;
                q.add(neighbour);
            }
        }
    }

    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
        //System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        Graph graph = new Graph(numVertices);
       // System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
       // System.out.println("Enter edges (source destination):");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
       // System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();
     //   System.out.println("Breadth-First Traversal (starting from vertex " + startVertex + "):");
        graph.BFS(startVertex);
    }

}