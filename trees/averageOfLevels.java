/*For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we can attach atmost two bulbs, one is to left side
	  and/or the other is to right side of every bulb in previous level.
	- The empty attachements in a level are indicated with -1. 
	(for example: look in hint)
		
You will be given the X-Mas Tree root,
Your task is to findout the average of each level of the X-Mas tree, starts from level-0.

Implement the class Solution.
1.public boolean averageOfLevels(Node root): returns a boolean value.

Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print a list of double values (averages of each level)

Sample Input-1:
---------------
3 8 4 3 5 -1 7 

Sample Output-1:
----------------
[3.0, 6.0, 5.0]

Sample Input-2:
---------------
3 8 4 3 5 7 7 

Sample Output-2:
----------------
[3.0, 6.0, 5.5]

*/
import java.util.*;
class averageOfLevels {
    static class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
    static Node buildTree(int[] arr)
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
    static ArrayList<Double> Average(Node root)
    {
        if(root ==null || root.data==-1) return new ArrayList<>();
        ArrayList<Double>res=new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            double avg=0;
            for(int i=0;i<size;i++)
            {
                Node current=q.poll();
                avg+=current.data;
                if(current.left != null && current.left.data !=-1) q.offer(current.left);
                if(current.right != null && current.right.data !=-1) q.offer(current.right);
            }
            res.add(avg/size);
        }
        return res;
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
        System.out.println(Average(root));
        sc.close();
    }
}