/*There is a board with M*N size. 
The board contains M*N blocks of 1*1 size.
Each block is printed a number on it.

You will be given a number, your task is to find whether the number is printed on 
any of the blocks or not. If found print true, otherwise print false.

NOTE: 
- The numbers printed on the board in each row are in increasing order. 
- Next row starting number is greater than the last number of the previous row.

Constarint:
-----------
Can you solve it in log(M)+ log(N) time. 


Input Format:
-------------
Line-1 -> Two integers M and N, board size.
Next M lines -> N space separated integers.
Last Line -> An integer T, number to search.

Output Format:
--------------
Print a boolean value, 'true' if number found.
otherwise, 'false'.


Sample Input-1:
---------------
4 4
1 3 6 10
12 15 19 23
24 28 32 36
37 41 44 47
15

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4 4
1 3 6 10
12 15 19 23
24 28 32 36
37 41 44 47
26

Sample Output-2:
----------------
false

*/
class BoardGame
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int resRow=searchRow(matrix,target);
        if(resRow != -1) return binarySearchOverRow(matrix,target,resRow);
        else return false;
    }
    int searchRow(int[][]matrix,int target)
    {
        int l=0,h=matrix.length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(matrix[m][0]<=target && target<=matrix[m][matrix[0].length-1]) return m;
            if(matrix[m][0]>target) h=m-1;
            else if(matrix[m][0]<target) l=m+1;
        }
        return -1;
    }
    boolean binarySearchOverRow(int[][]matrix, int target,int resRow)
    {
        int l=0,h=matrix[0].length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(matrix[resRow][m]==target) return true;
            if(matrix[resRow][m]>target) h=m-1;
            else l=m+1;
        }
        return false;
    }
	public static void main(String[] args)
	{
         int[][] ar = {
        {1, 3, 6, 10},
        {12, 15, 19, 23},
        {24, 28, 32, 36},
        {37, 41, 44, 47}
    };
    System.out.println(new BoardGame().searchMatrix(ar, 15)); // expect true
    System.out.println(new BoardGame().searchMatrix(ar, 26)); // expect false
    // Scanner sc = new Scanner(System.in);
		// int m = sc.nextInt();// number of rows
		// int n = sc.nextInt(); // number of columns
		// int[][] ar = new int[m][n];
		// for(int i=0;i<m;i++)
		// 	for(int j=0;j<n;j++)
		// 		ar[i][j]=sc.nextInt();
		// int key = sc.nextInt();
		// System.out.println(new BoardGame().searchMatrix(ar,key));
        // sc.close();
	}
}
