/*A forest research team has deployed a network of observation towers across a 
large wildlife reserve.
Each tower is represented as a node in a binary tree, and the connections 
between towers are structured hierarchically.

For efficient communication and data collection, the team wants to ensure 
that the network is well-balanced.
A balanced network is defined as a binary tree in which, for every tower, 
the height difference between its left and right sub-networks does not exceed 1. 
This guarantees that no single branch of the network becomes overloaded.

The task is to determine whether the given tower network satisfies the balanced property.
Return "true" if the network is balanced, otherwise return "false".
   
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
1 2 3 4 5 -1 -1 6 7

Sample Output-2:
----------------
false
*/
import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class BalancedBinaryTree {
    static TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        String[] parts = line.split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        TreeNode root = buildTree(arr);
        System.out.println(isBalanced(root));
        sc.close();
    }
}