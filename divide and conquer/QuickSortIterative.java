/*Input N, Input N random integer numbers. 
Sort them using Quick sort technique without using recursion.
Display space separated values of sorted list 

Sample Test Case
Input:5
12
32
41
56
20
output: 12 20 32 41 56
*/
import java.util.*; 
   
class QuickSortIterative
{ 
	//partitions the array around pivot=> last element
	static int partition(int numArray[], int low, int high)   
	{ 
	    int i=low+1,j=high,pivotnum=numArray[low];
		while(i<=j)
		{
		    if(nums[i]<pivotnum) i++;
		    else if(nums[j]>pivotnum) j--;
		    else
		    {
		        int temp=nums[i];
		        nums[i]=nums[j];
		        nums[j]=temp;
		        i++;j--;
		    }
		}
		nums[low]=nums[j];
		nums[j]=pivotnum;
		return j;
	} 
		 
	//sort the array using quickSort
	static void quickSort(int numArray[], int low, int high) 
	{ 
		//WRITE YOUR CODE HERE
		int[] stack=new int [numArray.length];
		//initialise stack
		int top=-1;
		stack[++top]=L;
		stack[++top]=R;
	}
	 
	public static void main(String args[]) 
	{ 
		//define array to be sorted
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int n = sc.nextInt(); 
		int a[]=new int[n];
		System.out.println("enter the elements of array ");
		for(int i=0;i<n;i++)
			a[i] =sc.nextInt();

		System.out.println("Original Array:" + Arrays.toString(a)); 
		// call quickSort routine to sort the array 
		quickSort(a, 0, n - 1); 
		//print the sorted array
		System.out.println("\nSorted Array:" + Arrays.toString(a)); 
	} 
}


