/*
There are N sticks of various lengths, stklen[], where stklen[i] is 
the length of the i-th stick.
And you need to break them into pieces of any length.
And you will be given another integer P, number of pieces you need to make.
You need to break the sticks to make P pieces of equal lengths.
You can consider the unwanted piece as scrap.

You can break a stick of length 6 as follows:
	- 6 pieces of length-1.
	- 1 piece of length-1 and 1 piece of length-2 and one piece of length-3.
	- 3 pieces of length-2, etc.
	
Your task is to check, can you break the sticks into P pieces of equal length,
if possible, retrun the maximum length of the pieces possible.
otherwise return 0.

Input Format:
-------------
Line-1: Two space separated integers, N and P.
Line-2: N space separated integers, length of the sticks.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 3
6 8 10

Sample Output-1:
----------------
6

Explanation:
------------
- Keep the stick-1 as it is.
- Break the stick-2 into two pieces, one of length 6 and one of length 2.
- Break the stick-3 into two pieces, one of length 6 and one of length 4.
Finally, you have 3 pieces of length 6.


Sample Input-2:
---------------
3 4
6 8 10

Sample Output-2:
----------------
5

Explanation:
------------
- Break the stick-1 into two pieces, one of length 5 and one of length 1.
- Break the stick-2 into two pieces, one of length 5 and one of length 3.
- Break the stick-3 into two pieces, one of length 5 and one of length 5.
Finally, you have 3 pieces of length 4.


Sample Input-3:
---------------
3 25
6 8 10

Sample Output-3:
----------------
0
*/
class Solution 
{
    public int maxLength(int[] ribbons, int k) 
    {
		if(ribbons.length==0 || ribbons==null) return 0;
		int l=1,h=ribbons[ribbons.length-1],ans=0;
		while(l<=h)
		{
			int m=(l+h)/2;
			if(helper(ribbons,m)>=k) {l=m+1;ans=m;}
			else h=m-1;
		}
        return ans;
    }
	static int helper(int[]ribbons,int m)
	{
		int count=0;
		for(int ribbon:ribbons)
		{
			count+=ribbon/m;
		}
		return count;
	}
	public static void main(String[] args)
    {
	System.out.println(new Solution().maxLength(new int[]{6, 8, 10}, 3));  // expect 6
    System.out.println(new Solution().maxLength(new int[]{6, 8, 10}, 4));  // expect 5
    System.out.println(new Solution().maxLength(new int[]{6, 8, 10}, 25)); // expect 0
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		
		System.out.println(new Solution().maxLength(ar,k));*/
	
	}
}