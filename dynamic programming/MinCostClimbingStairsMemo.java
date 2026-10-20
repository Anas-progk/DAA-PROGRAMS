/*Pavan is playing a game where there are N levels and each level has some points in it. 
level[i] is the points to spend on ith level(0-indexed) to move forward. 
Inorder to win the game he has to reach the top level.

The rule book explains "In one step you have to spend the points given on the 
present level and you can either cross one level or two levels forward".

Return the minimum number of points to spend to win the game.

Note:You are allowed to start at either level-0 or level-1.

Constraints:

    2 <= N <=1000
    0 <= level[i] <= 999

Input Format:
-------------
Line-1: An Integer N represents number of levels.
Line-2: N space seperated integers represents the points in each level.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
3
20 30 40
  
Sample Output-1:
----------------
30

Explanation:
------------
He can start at index-1 by spending points 30 and he can win.
   
Sample Input-2:
---------------
7
2 3 50 2 2 50 2 
  
Sample Output-2:
----------------
9

Explanation:
------------
Start at index-1:
  -Spend 3 points and reach to index-3
  -Spend 2 points and reach to index-4
  -Spend 2 points and reach to index-6
  -Spend 2 points and he wins.

*/
import java.util.*;
class MinCostClimbingStairs 
{    
	public int minCostClimbingStairsMemoized(int n, int[] cost, int []dp) 
	{
		if(n<=1) return 0;
		if(dp[n]!=-1) return dp[n];
		return dp[n]=Math.min(minCostClimbingStairsMemoized(n-1,cost,dp)+cost[n-1],minCostClimbingStairsMemoized(n-2,cost,dp)+cost[n-2]);
	}
	int minimumCost(int n, int cost[])
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return minCostClimbingStairsMemoized(n,cost,dp);
    }

	public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();     
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		System.out.println(new MinCostClimbingStairs().minimumCost(n,ar) );
	}
}