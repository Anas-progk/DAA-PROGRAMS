/*Mr.. Rana is writing mathematics exam. one question is as follows
Given an integer array, replace each element with the product of 
every other element without using the division operator.
He is facing difficulty to solve this, can you help him to solve this.

Input format : an integer number n
				n number of integers
output format :List of n integers

For example:
Example 1:
Input: 5  
1 2 3 4 5 
Output:[ 120, 60, 40, 30, 24 ]
 
 Example 2:
Input:6  
 5 3 4 2 6 8
Output:[ 1152, 1920, 1440, 2880, 960, 720 ]*/
import java.util.Arrays;
import java.util.*;
class Exam
{
	public static long exam(long[] A, int n, long left, int i)
	{
	    if(i==n) return 1;
	    long original=A[i];
	    long rp=exam(A,n,left*original,i+1);
	    A[i]=left*rp;
		return rp*original;
	}

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		long[] A = new long[n] ;
		for(int i =0;i<n;i++)
		{
			A[i] = sc.nextInt();
		}
		exam(A, A.length, 1, 0);
		// print the modified array
		System.out.println(Arrays.toString(A));
	}
}
