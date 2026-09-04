/*Mr. Ram is working in a manufacturing industry where items with different 
weights are manufactured. His duty is to pick pairs of items whose weight 
difference is equal to 'k'. Can you help him with a program? 
The condition is not to use extra space.

input format:an integer number n
			 n number of positive integers
			 an integer number k
output format : pairs of integers

Example 1:
input = 8
1 2 3 4 5 6 7 8
3
output =
1 4
2 5
3 6
4 7
5 8
Example 2:
input = 10
5 10 15 20 25 30 35 40 45 50
5
output =5 10
10 15
15 20
20 25
25 30
30 35
35 40
40 45
45 50

*/
import java.util.*;
public class FindPairs 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// int[] array = new int[n];
		// for(int i=0;i<n;i++)
		// 	array[i]=sc.nextInt();
        // int k = sc.nextInt();
		int array[]={1,2,3,4,5,6,7,8};
        findPairsWithDifference(array, 3);
		sc.close();
    }
	private static void findPairsWithDifference(int[] array, int k) 
	{
		Arrays.sort(array);
        for(int i=0;i<array.length;i++) 
		{
			if(i>0 && array[i]==array[i-1]);
			int j=binarySearch(array, i+1, array.length-1, array[i]+k);
			if(j!=-1) System.out.println(array[i]+" "+array[j]);
		}
    }
    private static int binarySearch(int[] array, int low, int high, int target) 
    {
        while(low<=high)
		{
			int mid=(low+high)/2;
		
			if(array[mid]==target) return mid;
			else if(array[mid]>target) high=mid-1;
			else low=mid+1;
		}
		return -1;
    }
}