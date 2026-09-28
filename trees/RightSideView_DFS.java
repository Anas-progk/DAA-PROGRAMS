/*Balbir singh is working with Binary Trees.
The elements of the tree is given in the level order format.
Balbir is looking the tree from right side. 
So, he can view only rightmost nodes only (one node per level).

You will be given the root of the binary tree.
Your task is to find the nodes which can be viewed by Balbir from right side.
And print the nodes from top to bottom order.

Your task is to implement the class Solution:
	- public List<Integer> rightSideView(Node root):
	return the list of node values.
	
NOTE: 
Please do consider the node with data=-1 as null node in the given trees.

Input Format:
-------------
Space separated integers, elements of the tree.

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
1 2 3 5 -1 -1 5

Sample Output-1:
----------------
[1, 3, 5]

Sample Input-2:
---------------
3 2 4 3 2

Sample Output-2:
----------------
[3, 4, 2]
*/
import java.util.*;
public class RightSideView_DFS {
    static class Node {
        int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left=right=null;
    }
}
    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
    static List<Integer> result = new ArrayList<>();
    static List<Integer> rightSideView(Node root) {
        dfs(root,0);
        return result;
    }
    static void dfs(Node root,int depth)
    {
        if(root==null) return;
        if(depth==result.size()) result.add(root.data);
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] parts = line.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        Node root = buildTree(arr);
        System.out.println(rightSideView(root));
        sc.close();
    }
}