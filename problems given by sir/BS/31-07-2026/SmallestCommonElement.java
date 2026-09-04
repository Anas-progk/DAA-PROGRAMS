/*Given a matrix where every row is sorted in increasing order. 
Write a function that finds and returns a smallest common element in all rows. If there is no common element, then returns -1. 

Example-1:
Input: mat [4][5] = {
	{1, 2, 3, 4, 5},
	{2, 4, 5, 8, 10},
	{3, 5, 7, 9, 11},
	{1, 3, 5, 7, 9}	};
Output: 5

Time complexity: 
A simple solution is to take every element of first row and search it in all other rows, till we find a common element. 

Time complexity of this solution is O(m*n*n) where m is number of rows and n is number of columns in given matrix. 
This can be improved to O(m*n*logn) if we use Binary Search instead of linear search.
*/


import java.util.*;
class SmallestCommonElement
{
	private boolean binarySearch(int[] arr, int low, int high, int target) 
	{
        while(low <= high) 
		{
            int mid = (low + high)/2; 
            if(arr[mid] == target) 
			{
                return true;     
            } else if(arr[mid] < target) {
                low = mid+1; 
            } else {
                high = mid-1; 
            }
        }    
        return false; 
    }
    
    public int smallestCommonElement(int[][] mat)
    {
        if(mat.length == 1) 
			return mat[0][0]; 
        for(int a : mat[0]) 
		{
            int count = 0; 
            for(int i=1; i<mat.length; i++) 
			{
                if(binarySearch(mat[i], 0, mat[i].length-1, a)
                    count++; 
                else
                    break;
            }
            if(count == mat.length-1) 
				return a; 
        }
        return -1; 
    }
	public static void main(String[] args) 
    { 
		Scanner sc=new Scanner(System.in);
		

    System.out.println( "enter size of two dimensional matrix" );

    System.out.println( "enter row size of matrix " );
       int m=sc.nextInt();
       System.out.println( "enter column size of matrix " );
		int n=sc.nextInt();
		int[][] arr = new int[m][n]; 
		for(int i=0;i<m;i++)
		for(int j=0;j<n;j++)
			arr[i][j] = sc.nextInt();
		
		System.out.println( "smallest comman element :"+new SmallestCommonElement().smallestCommonElement(arr) ); 
	} 
}



/*
case=1
input=4 5
1 2 3 4 5
2 4 5 8 10
3 5 7 9 11
1 3 5 7 9
output=5

case=2
input=3 4
2 4 6 8
4 5 6 8
1 4 6 8
output=4

case=3
input=3 5
1 3 5 7 9
2 3 5 7 11
3 5 7 9 13
output=3


case=4
input=4 4
10 20 30 40
15 20 35 45
20 25 30 50
5 20 25 35
output=20

case=5
input=3 3
1 2 3
4 5 6
7 8 9
output=-1
*/