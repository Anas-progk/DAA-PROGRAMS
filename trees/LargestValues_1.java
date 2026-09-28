/*For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we can attach atmost two bulbs to left side,
	  and right side of every bulb in previous level.
	- The empty attachements in each level are indicated with -1. 
	(for example: look in hint)

You will be given the root of the X-Mas Tree,
Your task is to findout the bulb with highest voltage in each level.

Implement the class Solution:
1.public List<Integer> maxInEachRow(BinaryTreeNode root): returns the list of integers.


Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print the list of voltages.


Sample Input-1:
---------------
2 4 3 6 4 -1 9

Sample Output-1:
----------------
[2, 4, 9]


Sample Input-2:
---------------
3 4 7 7 3 8 4 

Sample Output-2:
----------------
[3, 4, 8]

*/
import java.util.*;
public class LargestValues_1 {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    static Node ConstructTree(int[] arr)
    {
        if(arr.length==0 || arr[0]==-1) return null;
        Node root=new Node(arr[0]);
        Queue<Node>q=new LinkedList<>();
        q.offer(root);int i=1;
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
    static ArrayList<Integer> levelOrder(Node root)
    {
        if(root==null || root.data==-1) return new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        q.offer(root);int level=1;
        ArrayList<Integer>maxList=new ArrayList<>();
        while(!q.isEmpty())
            {
                int size=q.size();
                int max=Integer.MIN_VALUE;
                System.out.println("level "+level);
                for(int i=0;i<size;i++)
                {
                    Node current=q.poll();
                    if(max<current.data) max=current.data;
                    if(current.left !=null && current.left.data !=-1) q.offer(current.left);
                    if(current.right !=null && current.right.data !=-1) q.offer(current.right);
                }
                maxList.add(max);
                level++;
            }
            return maxList;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int arr[]=new int[str.length];
        for(int i=0;i<str.length;i++) arr[i]=Integer.parseInt(str[i]);
        Node root=ConstructTree(arr);
        System.out.println(levelOrder(root));
        sc.close();
    }
}
