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
        //WRITE YOUR CODE HERE
    }

    private boolean isSymmetricHelp(BinaryTreeNode left, BinaryTreeNode right)
	{
        //WRITE YOUR CODE HERE
    }
}

public class SymmetricTree
{
	static BinaryTreeNode root;
	static BinaryTreeNode temp = root;
	void insert(BinaryTreeNode temp, int key)
    { 
        //WRITE YOUR CODE HERE
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str[]=sc.nextLine().split(" ");
		SymmetricTree st=new SymmetricTree();
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			st.insert(root,Integer.parseInt(str[i]));
		Solution sol= new Solution();
		System.out.println(sol.isSymmetric(root));
	}
}