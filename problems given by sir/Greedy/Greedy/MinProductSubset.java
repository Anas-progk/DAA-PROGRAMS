/*Given an array a, we have to find the minimum product possible with the subset of elements present in the array. The minimum product can be a single element also.

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

->If there are even number of negative numbers and no zeros, 
the result is the product of all except the largest valued negative number.
->If there are an odd number of negative numbers and no zeros, 
the result is simply the product of all.
->If there are zeros and positive, no negative, the result is 0. 
The exceptional case is when there is no negative number and 
all other elements positive then our result should be 
the first minimum positive number.

Complexity Analysis:
Time Complexity : O(n) 
Auxiliary Space : O(1)

Test cases:
case=1
input= enter size of the array  
5
enter elements  -1 -1 -2 4 3
output= -24                                                                                                                     
case=2
input=enter size of the array 2
enter elements -1 0
output=-1

case=3
input=enter size of the array 3
enter elements 0 0 0
output=0                    
*/

// Java program to find maximum product of a subset.
import java.util.*;
class MinProductSubset
{
	static int minProductSubset(int a[], int n)
	{
		if (n == 1)
			return a[0];

		// Find count of negative numbers, count of zeros, maximum valued negative number, minimum valued positive number and product of non-zero numbers
		int negmax = Integer.MIN_VALUE;
		int posmin = Integer.MAX_VALUE;
		int count_neg = 0, count_zero = 0;
		int product = 1;
		System.out.println("Initial Values:");
		System.out.println("-ve Max: "+negmax);
		System.out.println("+ve Min: "+posmin);
		System.out.println("-ve count: "+count_neg);
		System.out.println("zero count: "+count_zero);
		System.out.println("Non zero Product: "+product+"\n");
		for (int i = 0; i < n; i++) 
		{
			System.out.println("ITERATION-"+(i+1)+" "+ Arrays.toString(Arrays.copyOfRange(a,0,i+1)));
			// if number is zero,count it but dont multiply
			if (a[i] == 0) 
			{
				count_zero++;
				continue;
			}

			// count the negative numbers and find the max negative number
			if (a[i] < 0) 
			{
				count_neg++;
				negmax = Math.max(negmax, a[i]);
			}

			// find the minimum positive number
			if (a[i] > 0 && a[i] < posmin)
				posmin = a[i];

			product *= a[i];
		System.out.println("-ve Max: "+negmax);
		System.out.println("+ve Min: "+posmin);
		System.out.println("-ve count: "+count_neg);
		System.out.println("zero count: "+count_zero);
		System.out.println("Non zero Product: "+product+"\n");
		}
		//System.out.println(negmax);
		// if there are all zeroes or zero is present but no negative number is present
		if (count_zero == n	|| (count_neg == 0 && count_zero > 0))
		{
			System.out.println("No -ve values\n0s Exist");
			return 0;
		}

		// If there are all positive
		if (count_neg == 0)
		{
			System.out.println("No -ve values and No 0s\n+ve Min is Answer");
			return posmin;
		}

		// If there are even number of negative numbers result is product of all non-zeros divided by maximum valued negative.
		if (count_neg % 2 == 0)
		{
			System.out.println("even number of -ve values\nTotal product/-ve Max is Answer");
			product = product / negmax;
		}
		else System.out.println("odd number of -ve values\nTotal product of non 0s is Answer");
		return product;
	}

	// main function
	public static void main(String[] args)
	{

		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of the array");
		int n=sc.nextInt();
			System.out.println("enter elements");
           	int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println(minProductSubset(a, n));
}}


/*
case =1
input =4
2 3 -2 4
output =-48

case =2
input =3
-2 0 -3
output =-3

case=3
input=5
-4 2 -3 4 -5
output =-480

case =4
input =7
-1 -2 -3 -4 -5 -6 7
output=-5040

case =5
input=7
1 2 -3 -4 -5 -6 7
output=-1680

case=6
input=5
4 2 -3 4 -5
output =-160

case =7
input =4
10 5 20 35
output =5

case =8
input =3
-20 0 -35
output =-35

case=9
input=6
0 0 0 10 20 30
output =0

case =10
input =7
-10 20 -5 15 -2 4 0
output=-120000
*/