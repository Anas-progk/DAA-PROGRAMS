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
public class BalancedBinaryTreeBFS {
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
    static void levelOrder(Node root)
    {
        
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
        System.out.println(levelOrder(root));
        sc.close();
    }
}
