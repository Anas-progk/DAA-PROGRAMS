/*Sample Input-1:
---------------
2 3 4 -1 5

Sample Output-1:
----------------
2 3 4 5

Sample Input-2:
---------------
11 99 88 77 -1 -1 66 55 -1 -1 -1 -1 -1 -1 44

Sample Output-2:
----------------
11 99 88 77 66 55 44
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

class BT
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        //W Y C H
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		BT b=new BT();
		Solution sol= new Solution();		
		String str[]=sc.nextLine().split(" ");

		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			b.insert(root,Integer.parseInt(str[i]));

		ArrayList<Integer> result=sol.bfs(root);
		System.out.println(result);
	}
}



class Solution 
{
    public ArrayList<Integer> bfs(BinaryTreeNode root) 
	{
        //W Y C H
    }
}
