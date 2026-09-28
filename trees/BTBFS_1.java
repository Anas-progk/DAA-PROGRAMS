/*You are given the elements of a Binary Tree in level-order form.
The value '-1' represents that there is no node at that position.
Your task is to:
1. Construct the Binary Tree from the given input.
2. Display the nodes of the tree level by level, considering only existing nodes.
3. For each level, find and display the minimum and maximum node value present at that level.

Input Format
The first line contains an integer 'N', representing the number of elements in the input.
The second line contains 'N' integers representing the Binary Tree in level-order.

* A positive/negative integer other than '-1' represents a valid node.
* '-1' represents a missing node.
* The first element represents the root of the tree.

Output Format
For each level of the Binary Tree, print:
Level X: <nodes at this level> | Min = <minimum> | Max = <maximum>
Only existing nodes should be displayed.

Constraints
* '1 <= N <= 10^5'
* Node values are integers.
* '-1' represents a missing node.
* If the root is '-1', the tree is empty.

Example 1
Input
7
1 2 3 4 5 -1 6
Output
Level 1: 1 | Min = 1 | Max = 1
Level 2: 2 3 | Min = 2 | Max = 3
Level 3: 4 5 6 | Min = 4 | Max = 6

Example 2
Input
11
10 5 20 3 7 15 25 -1 4 6 8
Output
Level 1: 10 | Min = 10 | Max = 10
Level 2: 5 20 | Min = 5 | Max = 20
Level 3: 3 7 15 25 | Min = 3 | Max = 25
Level 4: 4 6 8 | Min = 4 | Max = 8

Important Note
The input represents the tree in level-order, but the positions of '-1' values indicate missing children.

For example:
        10
       /  \
      5    20
     / \   / \
    3   7 15 25
    \   / \
     4 6   8

The '-1' values must not be displayed as nodes and must not participate in finding the minimum or maximum.

Expected Approach
Use:
* A Binary Tree Node class to represent each node.
* A Queue to construct the tree from level-order input.
* A Queue again to perform BFS traversal.
* Process one complete level at a time using the current queue size.
The time complexity should be O(N), since every existing node is visited once.
*/
import java.util.*;
public class BTBFS_1 {
    static class Node{
        Node left,right;
        int data;
        Node(int data){
            left=right=null;
            this.data=data;
        }
    }
    static Node constructTree(int []arr)
    {
        if(arr.length==0 || arr[0]==-1) return null;
        Node root=new Node(arr[0]);
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        int i=1,N=arr.length;
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
        if(root==null || root.data==-1) return;
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        int level=1;
        while(!q.isEmpty())
        {
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node current=q.poll();
                min=Math.min(min,current.data);
                max=Math.max(max,current.data);
                if(current.left !=null &&  current.left.data !=-1) q.offer(current.left);
                if(current.right !=null &&  current.right.data !=-1) q.offer(current.right);
            }
            System.out.print("Level "+level);
            System.out.println(" Min "+min+" | Max "+max);
            level++;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        Node root=constructTree(arr);
        levelOrder(root);
        sc.close();
    }
}
