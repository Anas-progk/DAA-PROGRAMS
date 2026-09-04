/*Input N, Input N random integer numbers. 
Sort them using Merge sort technique without using recursion.
Display space separated values of sorted list 

Sample Test Case
Input:5
12 41 32 56 20
output: 12 20 32 41 56
*/

import java.lang.Math.*;
import java.util.*;

class Mergesort_iterative
{

	/* Iterative mergesort function to sor 	t arr[0...n-1] */
	static void mergeSort(int arr[], int n)
	{
	    //WRITE YOUR CODE HERE
	}
	
	/* Function to merge the two haves arr[l..m] and
	arr[m+1..r] of array arr[] */
	static void merge(int arr[], int l, int m, int r)
	{
		//WRITE YOUR CODE HERE
	}
	
	/* Function to print an array */
	static void printArray(int A[], int size)
	{
		int i;
		for (i=0; i < size; i++)
			System.out.printf("%d ", A[i]);
		System.out.printf("\n");
	}
	
	/* Driver program to test above functions */
	public static void main(String[] args)
	{
    	Scanner sc=new Scanner (System.in);
    	System.out.println("Enter array size");
    	int n = sc.nextInt();
    	int [] arr=new int[n];
    	System.out.println("Enter numbers ");
    	for (int i=0 ; i<n; i++)
    	{
    	    int  number = sc.nextInt();
    	    arr[i]=number;
    	}
        
        System.out.printf("Given array is \n");
    	printArray(arr, n);
    	mergeSort(arr, n);
    	
    	System.out.printf("\nSorted array is \n");
    	printArray(arr, n);
	}
}