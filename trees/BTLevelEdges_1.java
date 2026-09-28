/*You are given the elements of a Binary Tree in level-order form.
The value '-1' represents that there is no node at that position.

Your task is to:
1. Construct the Binary Tree from the given input.
2. Perform a level-order traversal using BFS.
3. For each level, display the leftmost and rightmost existing node.
Only existing nodes should be considered. The '-1' values must not
be displayed or considered as nodes.

Input Format
The first line contains an integer N, representing the number of
elements in the input.
The second line contains N integers representing the Binary Tree
in level-order.

- A positive or negative integer other than -1 represents a valid node.
- -1 represents a missing node.
- The first element represents the root of the tree.

Output Format
For each level, print:
Level X: Leftmost = A, Rightmost = B
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
Level 1: Leftmost = 1, Rightmost = 1
Level 2: Leftmost = 2, Rightmost = 3
Level 3: Leftmost = 4, Rightmost = 7

Sample Test Case 2
Input:
11
10 5 20 3 7 15 25 -1 4 6 8
Output:
Level 1: Leftmost = 10, Rightmost = 10
Level 2: Leftmost = 5, Rightmost = 20
Level 3: Leftmost = 3, Rightmost = 25
Level 4: Leftmost = 4, Rightmost = 8
*/
import java.util.*;
public class BTLevelEdges_1 {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static Node ConstructTree(int arr[])
    {
        if(arr.length==0 || arr[0]==-1) return null;
        Node root=new Node(arr[0]);
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<arr.length)
        {
            Node current=q.poll();
            if(i<arr.length && arr[i] !=-1){
                current.left=new Node(arr[i]);
                q.offer(current.left);
            }i++;
            if(i<arr.length && arr[i] !=-1){
                current.right=new Node(arr[i]);
                q.offer(current.right);
            }i++;
        }
        return root;
    }
    static void levelOrder(Node root)
    {
        if(root==null || root.data==-1) return;
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            System.out.println("level "+level);
            int leftmost=0,rightmost=0;
            for(int i=0;i<size;i++)
            {
                Node current=q.poll();
                if(i==0) leftmost=current.data;
                if(i==size-1) rightmost=current.data;
                if(current.left !=null) q.offer(current.left);
                if(current.right !=null) q.offer(current.right);
            }
            System.out.println(" left : "+leftmost+" right : "+rightmost);
            level++;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        Node root=ConstructTree(arr);
        levelOrder(root);
        sc.close();
    }
}
