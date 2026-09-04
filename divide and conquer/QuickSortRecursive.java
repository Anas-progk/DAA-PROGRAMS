/*Input N, Input N random integer numbers. 
Sort them using Quick sort technique and recursion.
Display space separated values of sorted list 

Sample Test Case
Input:5
12
32
41
56
20
output: 12 20 32 41 565
*/

import java.util.*;
class QuickSortRecursive
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		int n = sc.nextInt(); 
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
			a[i] =sc.nextInt();

		//call quick_sort routine 
		quick_sort(a, 0, n-1);
		System.out.println(Arrays.toString(a)+" from main function ");
		
	}

	static int partition(int nums[], int low, int high)
	{ 
		int pivotnum=nums[low];
		int i=low+1,j=high;
		while(i<=j)
		{
			System.out.println(Arrays.toString(nums)+" partition func beginning of while i= "+i+" j= "+j);
		    if(nums[i]<pivotnum) {i++;System.out.println(Arrays.toString(nums)+" partition func from if i= "+i+" j= "+j);}
		    else if(nums[j]>pivotnum) {j--;System.out.println(Arrays.toString(nums)+" partition func from else if i= "+i+" j= "+j);}
		    else
		    {
		        int temp=nums[i];
		        nums[i]=nums[j];
		        nums[j]=temp;
		        i++;j--;System.out.println(Arrays.toString(nums)+" partition func from else i= "+i+" j= "+j);
		    }
		}
		System.out.println(Arrays.toString(nums)+" partition func after while loop i= "+i+" j= "+j);
		nums[low]=nums[j];
		nums[j]=pivotnum;
		System.out.println(Arrays.toString(nums)+" partition func after putting nums[j] in nums[low],pivot in nums[j] i= "+i+" j= "+j);
		return j;
	} 

	static void quick_sort(int intArray[], int low, int high) 
	{ 
		System.out.println(Arrays.toString(intArray)+" quick sort func outside if low= "+low+" high= "+high);
		if(low<high)
		{
			System.out.println(Arrays.toString(intArray)+" quick sort func inside if low= "+low+" high= "+high);
		    int p=partition(intArray,low,high);
			System.out.println(Arrays.toString(intArray)+" quick sort func after p low= "+low+" high= "+high);
		    quick_sort(intArray,low,p-1);
			System.out.println(Arrays.toString(intArray)+" quick sort func after left array quick sort low= "+low+" high= "+p);
		    quick_sort(intArray,p+1,high);
			System.out.println(Arrays.toString(intArray)+" quick sort func after right array quick sort low= "+p+" high= "+high);
		}
	} 
}