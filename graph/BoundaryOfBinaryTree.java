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
	
	// Helper: check if node is null or invalid (-1)
	private boolean isInvalid(BinaryTreeNode node) {
		return node == null || node.data == -1;
	}
	
	// Helper: leaf = valid node with both children invalid/null
	private boolean isLeaf(BinaryTreeNode node) {
		if (isInvalid(node)) return false;
		return isInvalid(node.left) && isInvalid(node.right);
	}
	
	// Main method to find the boundary of binary tree in anti-clockwise order
	public List<Integer> boundaryOfBinaryTree(BinaryTreeNode root) 
	{
		nodes.clear();
		// If tree is empty or root is invalid, return empty list
		if (isInvalid(root)) return nodes;
		
		// Single node (leaf) is the whole boundary
		if (isLeaf(root)) {
			nodes.add(root.data);
			return nodes;
		}
		
		// Step 1: Add root node to boundary
		nodes.add(root.data);
		
		// Step 2: Add left boundary (excluding leaves)
		leftBoundary(root.left);
		
		// Step 3: Add all leaf nodes (left to right)
		leaves(root);
		
		// Step 4: Add right boundary (excluding leaves, in reverse order)
		rightBoundary(root.right);
		
		return nodes;
	}

	public void leftBoundary(BinaryTreeNode root) 
	{
		// Base case: if node is null, invalid, or is a leaf node
		if (isInvalid(root) || isLeaf(root)) return;
		
		// Add current node to boundary (pre-order)
		nodes.add(root.data);
		
		// Priority: always go left if possible
		if (!isInvalid(root.left))
			leftBoundary(root.left);
		else
			leftBoundary(root.right);
	}

	public void rightBoundary(BinaryTreeNode root) 
	{
		// Base case: if node is null, invalid, or is a leaf node
		if (isInvalid(root) || isLeaf(root)) return;
		
		// Priority: always go right if possible
		if (!isInvalid(root.right))
			rightBoundary(root.right);
		else
			rightBoundary(root.left);
		
		// Add current node AFTER processing children (post-order) -> reverse order
		nodes.add(root.data);
	}

	public void leaves(BinaryTreeNode root) 
	{
		// Base case: if node is null or invalid
		if (isInvalid(root)) return;
		
		// Check if current node is a leaf node
		if (isLeaf(root)) {
			nodes.add(root.data);
			return;
		}
		
		// Recursively process left and right subtrees
		leaves(root.left);
		leaves(root.right);
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
