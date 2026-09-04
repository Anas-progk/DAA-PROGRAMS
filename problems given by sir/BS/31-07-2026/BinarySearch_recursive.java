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
class BinarySearch_recursive
{
  int binarySearch(int array[], int x, int low, int high) 
  {

    if (high >= low) {
      int mid = low + (high - low) / 2;

      // If found at mid, then return it
      if (array[mid] == x)
        return mid;
      if (array[mid] > x)
        return binarySearch(array, x, low, mid - 1);
	  if (array[mid] > x)
	    return binarySearch(array, x, mid + 1, high);
    }

    return -1;
  }

  public static void main(String args[])
  {
    BinarySearch_recursive ob = new BinarySearch_recursive();
    
        Scanner sc=new Scanner(System.in);
        
      	System.out.println("enter array size");
      	
      	  int n = sc.nextInt(); 
	     
	     int array[]=new int[n];
	
	System.out.println("enter the elements of array ");
  
        for(int i=0;i<n;i++)
    	{
	        array[i] =sc.nextInt();
         }
        // Applying sort() method over to above array
        // by passing the array as an argument
        Arrays.sort(array);
  
        // Printing the array after sorting
        System.out.println("sorted array[]:"+ Arrays.toString(array));
	System.out.println("Enter the key");
    int key=sc.nextInt();
    

    int result = ob.binarySearch(array, key, 0, n - 1);
    if (result == -1)
      System.out.println("Not found");
    else
      System.out.println("Element found at index " + result);
  }
}

/*
case=1
input:6
2 4 6 8 10 12
8
output:3

case=2
input:5
1 3 5 7 9
4
output:-1

case=3
input=8
5 10 15 20 25 30 35 40
25
output=4

case=4
input=7
-50 -30 -10 0 10 20 30
-25
output=-1

case=5
input=6
3 8 15 22 37 50
50
output=5
*/
