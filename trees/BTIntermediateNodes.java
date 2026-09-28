/*Problem: Display Intermediate Nodes at Each Level

You are given the elements of a Binary Tree in level-order form.
The value '-1' represents that there is no node at that position.

Your task is to:
1. Construct the Binary Tree from the given input.
2. Perform a level-order traversal using BFS.
3. For each level, display all the intermediate nodes,
   excluding the leftmost and rightmost nodes of that level.

If a level contains only one node or two nodes, there are
no intermediate nodes.

Only existing nodes should be considered. The '-1' values
must not be displayed or considered as nodes.

Input Format
The first line contains an integer N, representing the
number of elements in the input.

The second line contains N integers representing the Binary
Tree in level-order.

- A positive or negative integer other than -1 represents
  a valid node.
- -1 represents a missing node.
- The first element represents the root of the tree.

Output Format
For each level, display all intermediate nodes in that level.

Format:
Level X: <intermediate nodes>
If a level has no intermediate nodes, print:
Level X: No intermediate nodes
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
Level 1: No intermediate nodes
Level 2: No intermediate nodes
Level 3: 5 6

Sample Test Case 2
Input:
11
10 5 20 3 7 15 25 -1 4 6 8

Output:
Level 1: No intermediate nodes
Level 2: No intermediate nodes
Level 3: 7 15
Level 4: 6
 {
    
}
*/
import java.util.*;

public class BTBS {
    static class Node {
        Node left = null;
        Node right = null;
        int data;
        Node(int data) {
            this.data = data;
        }
    }

    static Node ConstructTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node current = q.poll();
            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                q.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }

    static void levelOrder(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                currentLevel.add(current.data);

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }

            System.out.print("Level " + level + ": ");

            if (currentLevel.size() <= 2) {
                System.out.println("No intermediate nodes");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < currentLevel.size() - 1; i++) {
                    sb.append(currentLevel.get(i));
                    if (i < currentLevel.size() - 2) sb.append(" ");
                }
                System.out.println(sb.toString());
            }

            level++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = ConstructTree(arr);
        levelOrder(root);

        sc.close();
    }
}