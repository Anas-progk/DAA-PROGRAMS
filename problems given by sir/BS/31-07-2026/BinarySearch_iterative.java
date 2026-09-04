/*You are given a sorted array of integers in non-decreasing order and a target integer value. 
Your task is to determine whether the target value exists in the array. If the target exists, return its index (0-based indexing). 
If the target does not exist, return -1. 
You must implement the search using the Binary Search technique, which repeatedly divides the search range in half to achieve a time complexity of O(log n).

Sample Test Cases:
input:6
2 4 6 8 10 12
8
output:3

input:5
1 3 5 7 9
4
output:-1
*/






import java.util.*;
class BinarySearch_iterative 
{
	int binarySearch(int array[], int x, int low, int high) 
	{

		// Repeat until the pointers low and high meet each other
		while (low <= high) 
		{
			int mid = (low + high) / 2;
			if (array[mid] == x)
				return mid;
			if (array[mid] < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	public static void main(String args[]) 
	{
		BinarySearch_iterative ob = new BinarySearch_iterative ( );
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int n = sc.nextInt(); 
		int array[]=new int[n];
		System.out.println("enter the elements of array ");
		for(int i=0;i<n;i++)
			array[i] =sc.nextInt();

		System.out.println("Enter the key");
		int key=sc.nextInt();
		int result = ob.binarySearch(array, key, 0, n - 1);
		if (result == -1)
			System.out.println("Not found");
		else
			System.out.println("Element found at index " + result);
	}
}
