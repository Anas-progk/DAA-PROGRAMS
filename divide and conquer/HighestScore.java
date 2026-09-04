import java.util.*;
public class HighestScore 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int max_sum = highestScore(arr, 0, n - 1);
		System.out.println(max_sum);
	}

	static int maxCrossingSum(int arr[], int l, int m, int h)
	{
		// Sweep left from mid, track best sum ending at mid
		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--)
		{
			sum += arr[i];
			if (sum > leftSum)
				leftSum = sum;
		}

		// Sweep right from mid+1, track best sum starting at mid+1
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++)
		{
			sum += arr[i];
			if (sum > rightSum)
				rightSum = sum;
		}

		// Combine both halves across the midpoint
		return leftSum + rightSum;
	}

	static int highestScore(int arr[], int l, int h)
	{ 
		// Base case: only one element, so it's the only possible subarray
		if (l == h)
			return arr[l];

		int m = l + (h - l) / 2;

		// Best subarray entirely in left half
		int leftBest = highestScore(arr, l, m);

		// Best subarray entirely in right half
		int rightBest = highestScore(arr, m + 1, h);

		// Best subarray crossing the middle
		int crossBest = maxCrossingSum(arr, l, m, h);

		// Return the max of all three
		return Math.max(Math.max(leftBest, rightBest), crossBest);
	}
}