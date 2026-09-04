/*Koko loves to eat bananas. 
There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K. 
Each hour, she chooses some pile of bananas and eats K bananas from that pile.
If the pile has less than K bananas, she eats all of them instead and will not
eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer K such that she can eat all the bananas within H hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
*/


import java.util.*;

public class Kokoeatingbanana
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt(); 
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i] =sc.nextInt();
		int H = sc.nextInt();
		int ans= minK(arr,H);
		System.out.println(ans);
	}

	public static int minK(int[] piles, int H) 
	{
		int left = 1, right =getBigPile(piles);
		while (left < right)
		{
			int mid = (left + right) / 2;
			int total = getReqHours(piles,mid);
			//WYC
		}
		return left;
	}









	public static int getReqHours(int[] piles, int k)
	{
		int total=0;
		//WYC
		return total;
	}
	public static int getBigPile(int[] piles)
	{
		int max=Integer.MIN_VALUE;
		//WYC
		return max;
	}
}