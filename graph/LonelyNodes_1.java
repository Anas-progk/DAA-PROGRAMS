//true correct solution
import java.util.*;
class BinaryTreeNode{
    public BinaryTreeNode left,right;
    public int data;
    BinaryTreeNode(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
public class LonelyNodes_1 
{
    static void insert(BinaryTreeNode root,int key)
    {
        Queue<BinaryTreeNode>q=new LinkedList<BinaryTreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            BinaryTreeNode temp=q.peek();q.remove();
            if(temp.left ==null)
            {
                temp.left=new BinaryTreeNode(key);break;
            }
            else q.add(temp.left);
            if(temp.right ==null)
            {
                temp.right=new BinaryTreeNode(key);break;
            }
            else q.add(temp.right);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Solution sol=new Solution();
        String str[]=sc.nextLine().split(" ");
        BinaryTreeNode root=new BinaryTreeNode(Integer.parseInt(str[0]));
        for(int i=1;i<str.length;i++)
        {
            int value=Integer.parseInt(str[i]);
            //if(value != -1) insert(root,value);
            insert(root, value);
        }
        ArrayList<Integer> res=sol.getPersonIds(root);
        Collections.sort(res);
        System.out.println(res);
        sc.close();
    }
}
class Solution
{
    public ArrayList<Integer> getPersonIds(BinaryTreeNode root)
    {
        ArrayList<Integer>nodes=new ArrayList<>();
        getPersonIDs(root, false, nodes);
        return nodes;
    }
    private void getPersonIDs(BinaryTreeNode node,boolean isLonely,ArrayList<Integer> nodes)
    {
        if(node==null || node.data==-1) return;
        if(isLonely) nodes.add(node.data);
        boolean leftExists=node.left!=null && node.left.data !=-1;
        boolean rightExists=node.right!=null && node.right.data !=-1;
        if(leftExists && !rightExists) getPersonIDs(node.left,true, nodes);
        if(!leftExists && rightExists) getPersonIDs(node.right,true, nodes);
        else
        {
            if(leftExists) getPersonIDs(node.left,false, nodes);
            if(rightExists) getPersonIDs(node.right,false, nodes);
        }
    }
}
