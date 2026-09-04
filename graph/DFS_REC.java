/*Depth–first search in trees
A tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any acyclic connected graph is a tree. For a tree, 
we have the following traversal methods:

Preorder: visit each node before its children.
Postorder: visit each node after its children.
Inorder (for binary trees only): visit left subtree, node, right subtree.
Implementing DFS in Java | Depth First Search Algorithm

->A Depth–first search (DFS) is a way of traversing graphs closely related 
to the preorder traversal of a tree. 
Following is the recursive implementation of preorder traversal:

procedure preorder(treeNode v)
{
    visit(v);
    for each child u of v
        preorder(u);
}


To turn this into a graph traversal algorithm, replace “child” with “neighbor”. 
But to prevent infinite loops, keep track of the vertices that are already discovered 
and not revisit them.

procedure dfs(vertex v)
{
    visit(v);
    for each neighbor u of v
        if u is undiscovered
            call dfs(u);
}

The time complexity of DFS traversal is O(V + E), where V and E are the total 
number of vertices and edges in the graph, respectively. 
Please note that O(E) may vary between O(1) and O(V2), depending on how dense the graph is.



input:
enter number of vertices and edges
6
6
enter edges
0 1
0 2
1 3
2 3
3 4
3 5
output:
enter source for DFS traversal
0
Following is Depth First Traversal:
0 1 3 2 4 5
*/
import java.io.*;
import java.util.*;
class Test 
{
    private int V;                              //number of nodes
    private LinkedList<Integer> adj[];              //adjacency list
    public Test(int v)
    {
        //WRITE YOUR CODE HERE
    }
    void addEdge(int v, int w)
    {
        //Write your code here for adding an edge to the adjacency list 
        //(edges are bidirectional)
    }
    void DFSUtil(int vertex, boolean nodes[])
    {
        //WRITE YOUR CODE HERE  
    }
    void DFS(int v)
    {
		//initialize a new boolean array to store the details of explored nodes
        boolean visited[] = new boolean[V];             
        DFSUtil(v, visited);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
       // System.out.println("enter number of vertices and edges");  
        int v=sc.nextInt();
        int e=sc.nextInt();        
        Test  t  = new Test(v);
      //  System.out.println("enter edges");
        for(int i=0;i<e;i++)
        {
            int end1=sc.nextInt();
            int end2=sc.nextInt();
            t.addEdge(end1,end2);
        }
       // System.out.println("enter source for DFS traversal");
        int source=sc.nextInt();
       // System.out.println("Following is Depth First Traversal: ");
        t.DFS(source);
    }      
}