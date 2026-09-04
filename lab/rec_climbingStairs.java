/*Problem Statement: Climbing Stairs with Maximum M Steps

A person wants to climb a staircase consisting of N stairs. 
In a single move, the person can climb at least 1 stair and at most M stairs.

Your task is to determine the total number of distinct ways the person can reach 
the top of the staircase. Two ways are considered different 
if the sequence of steps taken is different.

Input Format:
- The first line contains an integer N, representing the total number of stairs.
- The second line contains an integer M, representing the maximum number of stairs 
that can be climbed in a single move.

Output Format:
- Print a single integer representing the total number of distinct ways 
to reach the top.

1<=N<=50
1<=M<=N
0<=count<=pow(10,11)

Sample Test Case 1:
Input:
4
2

Output:
5

Explanation:
The five possible ways are:
1. 1 + 1 + 1 + 1
2. 1 + 1 + 2
3. 1 + 2 + 1
4. 2 + 1 + 1
5. 2 + 2

Sample Test Case 2:
Input:
5
2

Output:
8

Explanation:
The eight possible ways are:
1. 1 + 1 + 1 + 1 + 1
2. 1 + 1 + 1 + 2
3. 1 + 1 + 2 + 1
4. 1 + 2 + 1 + 1
5. 2 + 1 + 1 + 1
6. 1 + 2 + 2
7. 2 + 1 + 2
8. 2 + 2 + 1


*/
import java.util.*;
class solution


{


	static int countWays(int n, int m)
	

{
if(m>1)
{
    if(n<=2) return n;
    int res=0;
    for(int i=1;i<=m && i<=n;i++) {res+=countWays(n-i,m);}
    return res;
}
else return 1;
}
	public static void main(String args[])
	

{


		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		sc.close();
		System.out.println(countWays(n,m));
	

}

}