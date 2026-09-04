/*
There are B bags containing N gold boxes each. In each bag, gold boxes are 
arranged  in ascending order of their weights strictly, create a method in 
such a way that we need to return the least weight of gold box which is 
common least weight in all the given bags.

If we don’t have any common least weighted gold box, 
among all the bags then return -1.

Input Format:
-------------
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.

Output Format:
--------------
Print the least weight of gold box, if found
Print -1, if not found.


Sample Input:
---------------
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8

Sample Output:
----------------
3
*/
import java.util.*;
class SmallestCommonElement
{
	private static boolean binarySearch(int[] arr, int low, int high, int target) 
	{
			System.out.println("target " + target);
		while(low <= high) 
		{
			int mid = (low + high)/2; 
			if(arr[mid] == target) 
				return true;     
			else if(arr[mid] < target) 
					low = mid+1; 
				else 
					high = mid-1; 
		}    
		return false; 
	}
	public static int smallestCommonElement(int[][] mat) 
	{
		if(mat.length == 1) 
			return mat[0][0]; 
				// Get each element of array 1. Compare with each element of remaining array elements
		for(int ele : mat[0]) 
		{
			int count = 1; 
			for(int i = 1; i < mat.length; i++) 
				{	
					if(binarySearch(mat[i], 0, mat[i].length-1, ele)) 
						count++; 
					else
						break; 
				}
					System.out.println("Count " + count);
			if(count == mat.length) 
				return ele; 
		}
		return -1; 
	}
	public static void main(String[] args) 
	{ 
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] arr = new int[m][n]; 
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				arr[i][j] = sc.nextInt();
		System.out.println(smallestCommonElement(arr)); 
	} 
}


/*

case =1
input =4 5
1 2 3 4 5
2 4 5 8 10
3 5 7 9 11
1 3 5 7 9
output =5

case =2
input =4 5
3 4 5 6 8
2 4 5 8 10
3 5 7 8 11
1 3 5 7 8
output =5

case =3
input =4 5
3 4 5 6 8
2 4 6 8 10
3 5 7 8 11
1 3 5 7 8
output =8

case =4
input =4 5
2 4 5 6 8
2 4 5 8 10
4 5 7 8 11
1 4 5 7 8
output =4

case =5
input =4 5
12 14 15 16 18
12 13 25 28 30
24 25 27 28 31
11 14 15 17 18
output =-1

case =6
input =4 5
12 14 15 16 18
12 13 18 28 30
18 25 27 28 31
11 14 15 17 18
output =18

case =7
input =4 5
32 34 35 36 38
12 13 18 28 30
18 25 27 28 31
11 14 15 17 18
output =-1

case =8
input =4 5
32 34 35 36 38
32 33 35 38 50
35 45 47 58 61
1 14 25 27 35
output =35

case =9
input =5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8
output =3

case =10
input =4 5
1 2 3 4 5
2 4 5 8 10
3 5 7 9 11
1 3 5 7 9
output =5

*/