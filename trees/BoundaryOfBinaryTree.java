/*Indian Army setup some military-camps, sitauted at random places at LAC in Galwan.
There exist a main base camp connected with other base camps as follows:
Each military-camp is connected with atmost two other military-camps.
Each military-camp will be identified with an unique ID,(an integer).

To safeguard all the military-camps, Govt of India planned to setup protective 
S.H.I.E.L.D. Govt of India ask your help to build the S.H.I.E.L.D that should 
enclose all the military-camps.

You are given the IDs of the military-camps as binary tree. 
Your task is to find and return the military camp IDs, those are on the edge of 
the S.H.I.E.L.D in anti-clockwise order.

Implement the class Solution:
   1. public List<Integer> compoundWall(BondaryOfBTNode root): returns a boolean value.
  

NOTE:
'-1' in the IDs indicates no military-camp (NULL).


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]
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
	List<Integer> nodes = new ArrayList<>();
	
	// Main method to find the boundary of binary tree in anti-clockwise order
	public List<Integer> boundaryOfBinaryTree(BinaryTreeNode root) 
	{
        // If tree is empty or root is invalid, return empty list
        
        // Step 1: Add root node to boundary
        
        // Step 2: Add left boundary (excluding leaves)
        
        /* Step 3: Add all leaf nodes
         Process left subtree leaves first, then right subtree */
        
        // Step 4: Add right boundary (excluding leaves, in reverse order)
        
        return nodes;
    }

    /* Method to traverse and collect left boundary nodes
     Left boundary: nodes on the path from root to leftmost leaf */
    public void leftBoundary(BinaryTreeNode root) 
    {
        // Base case: if node is null, invalid, or is a leaf node
        
        // Add current node to boundary (pre-order traversal)
        
        /* Priority: always go left if possible
         If left child exists, follow left path
         If no left child but right exists, follow right path */
        
    }

    /* Method to traverse and collect right boundary nodes
     Right boundary: nodes on the path from root to rightmost leaf (in reverse)*/
    public void rightBoundary(BinaryTreeNode root) 
    {
        // Base case: if node is null, invalid, or is a leaf node
        
        /* Priority: always go right if possible
         If right child exists, follow right path
         If no right child but left exists, follow left path*/
        
        /* Add current node AFTER processing children (post-order)
         This ensures right boundary is added in reverse order (bottom-up) */
    }

    /* Method to collect all leaf nodes using DFS
     Leaf nodes: nodes with no children */
    public void leaves(BinaryTreeNode root) 
    {
        // Base case: if node is null or invalid
        
        // Check if current node is a leaf node
            // Add leaf node to boundary
        
        // Recursively process left and right subtrees (in-order traversal)
        
    }
}

public class BoundaryOfBinaryTree
{
	static BinaryTreeNode root;
	
	// Utility method to insert nodes in level order (binary tree construction)
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) 
        {
            temp = new BinaryTreeNode(key);
            return;
        }
        
        // Use BFS (level order) to find first available position
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Traverse level by level to find empty position
        while (!q.isEmpty()) 
        {
            temp = q.remove();
 
            // Insert in left child if available
            if (temp.left == null) 
            {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            // Insert in right child if available
            if (temp.right == null) 
            {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		BoundaryOfBinaryTree bbt = new BoundaryOfBinaryTree();
		Solution sol = new Solution();
		
		// Read input space separated integers
		String str[] = sc.nextLine().split(" ");

		// Create root node
		root = new BinaryTreeNode(Integer.parseInt(str[0]));

		// Insert remaining nodes in level order
		for(int i = 1; i < str.length; i++)
			bbt.insert(root, Integer.parseInt(str[i]));

		// Compute and print boundary traversal
		System.out.println(sol.boundaryOfBinaryTree(root));
	}
}