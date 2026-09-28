import java.util.*;
public class BTIntermediateNodes_1 {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=null;right=null;
        }
    }
    static Node ConstructTree(int[] arr)
        {
            if(arr.length==0 || arr[0]==-1) return null;
            Node root=new Node(arr[0]);
            Queue<Node>q=new LinkedList<>();
            int i=1;
            q.offer(root);
            while(!q.isEmpty() && i<arr.length)
            {
                Node current=q.poll();
                if(i<arr.length && arr[i] !=-1){
                    current.left=new Node(arr[i]);
                    q.offer(current.left);
                }
                i++;
                if(i<arr.length && arr[i] !=-1){
                    current.right=new Node(arr[i]);
                    q.offer(current.right);
                }
                i++;
            }
            return root;
        }
        static void levelOrder(Node root)
        {
            if(root==null || root.data==-1) return;
            Queue<Node>q=new LinkedList<>();
            q.offer(root);
            int level=1;
            while(!q.isEmpty())
                {
                List<Integer> currentLevel=new ArrayList<>();
                int size=q.size();
                for(int i=0;i<size;i++)
                {
                    Node current=q.poll();
                    currentLevel.add(current.data);
                    if(current.left !=null && current.left.data !=-1) q.offer(current.left); 
                    if(current.right !=null && current.right.data !=-1) q.offer(current.right); 
                }
                System.out.println("level "+level);
                if(currentLevel.size()<=2) System.out.println("No Intermediate nodes");
                else
                {
                    StringBuilder sb=new StringBuilder();
                    for(int i=1;i<currentLevel.size()-1;i++)
                    {
                        sb.append(currentLevel.get(i));
                        if (i < currentLevel.size() - 2) sb.append(" ");
                    }
                    System.out.println(sb.toString());
                }
                level++;
            }
        }
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = ConstructTree(arr);
        levelOrder(root);

        sc.close();
    }
}
