/*Given a staircase of N steps and you can either climb 1 or 2 steps at a given time. 
The task is to return the count of distinct ways to climb to the top. 

Input: a positive integer number N
output:display the count

Sample Testcases:
Exaple1
Input: N=3 
Output: 3 
Explanation:
There are three distinct ways of climbing a staircase of 3 steps : 
[1, 1, 1], [2, 1] and [1, 2].

Example2
Input: N=2 
Output: 2 
Explanation:
There are two distinct ways of climbing a staircase of 3 steps: [1, 1] and [2].

Example3
Input: N=4
Output: 5
(1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)

0<=N<=50
0<=count<=pow(10,11)
*/
import java.util.*;
class Stairs
{	
	static int ClimbStairs(int n)
	{
		if(n==0) return 1;
		int sum=0;
		for(int i=1;i<=2;i++)
		{
			if(n-i >=0) sum+=ClimbStairs(n-i);
		}
		return sum;
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		System.out.println(ClimbStairs(n));
	}
}
