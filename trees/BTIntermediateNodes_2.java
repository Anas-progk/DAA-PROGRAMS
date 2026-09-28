/*Problem: Display Intermediate Nodes at Each Level

You are given the elements of a Binary Tree in level-order form.
The value '-1' represents that there is no node at that position.

Your task is to:
1. Construct the Binary Tree from the given input.
2. Perform a level-order traversal using BFS.
3. For each level, display all the intermediate nodes,
   excluding the leftmost and rightmost nodes of that level.

If a level contains only one node or two nodes, there are
no intermediate nodes.

Only existing nodes should be considered. The '-1' values
must not be displayed or considered as nodes.

Input Format
The first line contains an integer N, representing the
number of elements in the input.

The second line contains N integers representing the Binary
Tree in level-order.

- A positive or negative integer other than -1 represents
  a valid node.
- -1 represents a missing node.
- The first element represents the root of the tree.

Output Format
For each level, display all intermediate nodes in that level.

Format:
Level X: <intermediate nodes>
If a level has no intermediate nodes, print:
Level X: No intermediate nodes
If the tree is empty, print:
Tree is empty

Constraints
1 <= N <= 10^5
Node values are integers.
-1 represents a missing node.

Sample Test Case 1
Input:
7
1 2 3 4 5 6 7

Output:
Level 1: No intermediate nodes
Level 2: No intermediate nodes
Level 3: 5 6

Sample Test Case 2
Input:
11
10 5 20 3 7 15 25 -1 4 6 8

Output:
Level 1: No intermediate nodes
Level 2: No intermediate nodes
Level 3: 7 15
Level 4: 6
 {
    
}
*/
import java.util.*;
public class BTIntermediateNodes_2 {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=null;right=null;
        }
    }
    static Node ConstructTree(int[] arr)
    {
        if(arr.length==0 || arr[0]==-1) return null;
        Node root=new Node(arr[0]);
        int N=arr.length,i=1;
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty() && i<N)
        {
            Node current=q.poll();
            if(i<N && arr[i] !=-1){
                current.left=new Node(arr[i]);
                q.offer(current.left);
            }i++;
            if(i<N && arr[i] !=-1){
                current.right=new Node(arr[i]);
                q.offer(current.right);
            }i++;
        }
        return root;
    }
    static void levelOrder(Node root)
    {
        if(root==null || root.data==-1) return ;
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty())
        {
            ArrayList<Integer>al=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node current=q.poll();
                al.add(current.data);
                if(current.left != null && current.left.data !=-1) q.offer(current.left);
                if(current.right != null && current.right.data !=-1) q.offer(current.right);
            }
            System.out.print("Level : "+level+" ");
            if(al.size()<=2) System.out.println(" No Intermediate nodes");
            else{
                for(int i=1;i<al.size()-1;i++) System.out.print(" "+al.get(i)+" ");
                System.out.println();
                al.clear();
            }
            level++;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        Node root=ConstructTree(arr);
        levelOrder(root);
        sc.close();
    }
}
