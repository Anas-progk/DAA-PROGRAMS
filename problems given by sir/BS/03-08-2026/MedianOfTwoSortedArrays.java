/*
There are two sorted arrays A and B of sizes m and n respectively. 
Find the median of the two sorted arrays( The median of the array formed by merging both the arrays). 
Median: The middle element is found by ordering all elements in sorted order and picking out the one in the middle (or if there are two middle numbers, taking the mean of those two numbers).

Follow up: The overall run time complexity should be O(log (m+n)).
Sample Test Cases:
case=1
input=3
1 3 8
4
7 9 10 11
output=8.0



case=2
input=6
10 20 30 40 50 60
10
15 25 35 45 55 65 75 85 95 105
output=47.5

Constraints:
1 <= m <= 1000
1 <= n <= 1000
2 <= m + n <= 2000
-10^6 <= A[i], B[i] <= 10^6
*/

import java.util.*;
public class MedianOfTwoSortedArrays 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt(); 
		int A[]=new int[m];
		for(int i=0;i<m;i++)
			A[i] =sc.nextInt();

		int n = sc.nextInt(); 
		int B[]=new int[n];		
		for(int i=0;i<n;i++)
			B[i] =sc.nextInt();
		
		System.out.println("Median of two sorted arrays :" + findMedian(A, B));
	}
	private static double findMedian(int[] A, int[] B) 
	{
		/* make sure A is smaller than B. 
		   If not, then we will swap A with B*/
		if (A.length > B.length) 
			return findMedian(B, A);
		
		// Lengths of two arrays
		int m = A.length;
		int n = B.length;

		// Pointers for binary search
		int start = 0;
		int end = m;

		// Binary search starts from here
		while (start <= end) 
		{
			// Partitions of both the array
			int i = (start + end) / 2;
            int j = (m + n + 1) / 2 - i;
			System.out.println("i "+i+" j "+j);
			// Edge cases
			// If there are no elements left on the left side after partition
			int AleftMax = (i ==0)? Integer.MIN_VALUE: A[i-1];				
			// If there are no elements left on the right side after partition
			int ArightMin =(i == m)? Integer.MAX_VALUE: A[i];		
			// Similarly for B
			int BleftMax =(j == 0)? Integer.MIN_VALUE: B[j-1];			
			int BrightMin =(j == n)? Integer.MAX_VALUE: B[j];
		


			// Check if we have found the match
			if (AleftMax <= BrightMin && BleftMax <= ArightMin) 
			{
				// Check if the combined array is of even/odd length
				if ((m + n) % 2 == 0) 
					return ( Math.max(AleftMax, BleftMax) + Math.min(ArightMin, BrightMin) ) / 2.0;
				else
					return Math.max(AleftMax, BleftMax);
			}

			// If we are too far on the right, we need to go to left side
			else if (AleftMax > BrightMin)
				end = i - 1;
			// If we are too far on the left, we need to go to right side
			else
				start = i + 1;
		}
		return 0;
	}
	
}



/*
case=1
input=3
1 3 8
4
7 9 10 11
output=8.0

case=2
input=1
5
5
1 2 3 4 6
output=3.5


case=3
input=6
10 20 30 40 50 60
10
15 25 35 45 55 65 75 85 95 105
output=47.5

case=4
input=10
10 20 30 40 50 60 70 80 90 100
10
15 25 35 45 55 65 75 85 95 105
output=57.5

case=5
input=7
10 20 30 40 50 60 70
9
80 90 100 110 120 130 140 150 160
output=85.0
*/