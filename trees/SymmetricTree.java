/*Maya is designing a security system for her smart home.
She represents her home’s sensor layout as a binary tree (BT), 
where each node denotes a sensor’s ID number.

To ensure the system’s fault tolerance, 
she wants the layout to be symmetrical, so that sensors on one side have 
identical counterparts on the other.

Maya asks her friend Rohan to help her verify whether 
the given layout tree is self-mirroring.

Return "true" if the tree is symmetrical (self-mirror), 
otherwise return "false".

Implement the class Solution:
   1. public boolean isSelfMirrorTree(BinaryTreeNode root): 
   returns a boolean value.
  
NOTE:
	- In the tree '-1', indicates empty(null).
   
Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false


*/


import java.util.*;

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data)
	{
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution
{
    public boolean isSymmetric(BinaryTreeNode root) 
	{
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(BinaryTreeNode left, BinaryTreeNode right)
	{
        if (left == null || right == null) {
            return left == right;
        }
        return left.data == right.data
                && isSymmetricHelp(left.left, right.right)
                && isSymmetricHelp(left.right, right.left);
    }
}

public class SymmetricTree
{
	static BinaryTreeNode buildTree(int[] arr)
    {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(arr[0]);
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            BinaryTreeNode current = queue.poll();
            if (arr[i] != -1) {
                current.left = new BinaryTreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new BinaryTreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String line = sc.nextLine().trim();
		String str[]=line.split("\\s+");
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		BinaryTreeNode root = buildTree(arr);
		Solution sol= new Solution();
		System.out.println(sol.isSymmetric(root));
		sc.close();
	}
}