

/*Given an array of n distinct integers sorted in ascending order, 
write a function that returns a Fixed Point in the array, 
if there is any Fixed Point present in array, else returns -1. 
Fixed Point in an array is an index i such that arr[i] 
is equal to i. Note that integers in array can be negative. 

Example 1: 
Input: [-10,-5,0,3,7] 
Output: 3 
Explanation: For the given array, A[0] = -10, A[1] = -5, A[2] = 0, A[3] = 3, thus the output is 3. 

Example 2: 
Input: [0,2,5,8,17] 
Output: 0 
Explanation: A[0] = 0, thus the output is 0. 

Example 3: 
Input: [-10,-5,3,4,7,9] 
Output: -1 
Explanation: There is no such i that A[i] = i, thus the output is -1.
*/

import java.util.*;
class Findfixedpoint 
{

	static int fixedpoint(int arr[], int low, int high)
	{
		if (high >= low) 
		{
			int mid = low + (high - low) / 2;
			if (mid == arr[mid])
				return mid;
			int res = -1;
			if (mid + 1 <= arr[high])
				res = fixedpoint(arr, (mid + 1), high);
			if (res != -1)
				return res;
			if (mid - 1 >= arr[low])
				return fixedpoint(arr, low, (mid - 1));
		}

		/* Return -1 if there is no Fixed Point */
		return -1;
	}

	// main function
	public static void main(String args[])
	{
        Scanner sc=new Scanner(System.in);        
        System.out.println("enter array size");
        int n = sc.nextInt(); 
        int array[]=new int[n];
		System.out.println("enter the elements of array ");
  
        for(int i=0;i<n;i++)
          array[i] =sc.nextInt();
  
		System.out.println("Fixed Point is "+ fixedpoint(array, 0, n - 1));
	}
}



/*
case=1
enter array size 10
enter the elements of array
11
30
50
0
3
100
-10
-1
10
102
sorted array[]:[-10, -1, 0, 3, 10, 11, 30, 50, 100, 102]
Fixed Point is 3

case=2
enter array size 6
enter the elements of array
3
9
4
7
-5
-10
sorted array[]:[-10, -5, 3, 4, 7, 9]
Fixed Point is -1

case=3
enter array size 5
enter the elements of array
8
2
5
17
0
sorted array[]:[0, 2, 5, 8, 17]
Fixed Point is 0*/