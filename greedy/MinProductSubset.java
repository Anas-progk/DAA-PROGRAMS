/*Minimum product subset of an array
Given an array a, we have to find the minimum product possible with the subset 
of elements present in the array. The minimum product can be a single element also.

Examples: 
Input : a[] = { -1, -1, -2, 4, 3 }
Output : -24
Explanation : Minimum product will be ( -2 * -1 * -1 * 4 * 3 ) = -24

Input : a[] = { -1, 0 }
Output : -1
Explanation : -1(single element) is minimum product possible
 
Input : a[] = { 0, 0, 0 }
Output : 0
A simple solution is to generate all subsets, find the product of every subset
and return the minimum product.

A better solution is to use the below facts.  

->If there are even number of negative numbers and no zeros, the result is 
the product of all except the largest valued negative number.
->If there are an odd number of negative numbers and no zeros, 
the result is simply the product of all.
->If there are zeros and positive, no negative, the result is 0. 
The exceptional case is when there is no negative number and all other elements 
positive then our result should be the first minimum positive number.

Complexity Analysis:
Time Complexity : O(n) 
Auxiliary Space : O(1)

Test cases:
case=1
input= 5
-1 -1 -2 4 3
output= -24                                                                                                                     
case=2
input=2
-1 0
output=-1

case=3
input=3
0 0 0
output=0                    
*/

// Java program to find maximum product of a subset.
import java.util.*;
class MinProductSubset
{
	static int minProductSubset(int a[], int n)
	{
    	//Write your code here
	}

	// main function
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println(minProductSubset(a, n));
}}


