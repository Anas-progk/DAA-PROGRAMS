/*Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: Two space separated integers, N and C.
Next N lines: Two space separated integers, Ci and Qi.
        			cost and quantity of i-th product.

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.


Sample Input-1:
---------------
4 15
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
38

Explanation:
------------
Quantity = 2 + 4 + 9 = 15
Cost = 10 + 10 + 18 = 38


Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
56

Explanation:
------------
Quantity = 6 + 3 + 9 = 18
Cost = 18 + 20 + 18 = 56



import java.util.*;

/*
Solution is to consider all subsets of items and calculate the total weight and profit of all subsets. 
Consider the only subsets whose total weight is smaller than W. 
From all such subsets, pick the subset with maximum profit.

Optimal Substructure: To consider all subsets of items, there can be two cases for every item. 

Case 1: The item is included in the optimal subset.
Case 2: The item is not included in the optimal set.

The maximum value obtained from ‘N’ items is the max of the following two values. 

Case 1 (include the Nth item): Value of the Nth item plus maximum value obtained by remaining N-1 items 
and remaining weight i.e. (W-weight of the Nth item).

Case 2 (exclude the Nth item): Maximum value obtained by N-1 items and W weight.
If the weight of the ‘Nth‘ item is greater than ‘W’, then the Nth item cannot be 
included and Case 2 is the only possibility.
*/

class ZeroOneKnapsack
{
	/*
	In a DP[][] table let's consider all the possible weights from 1 to W as the columns and 
	cost and weight that can be kept as the rows. 

	The state DP[i][j] will denote maximum value of j-weight considering all values from 1 to ith.
	So if we consider wi (weight in ith row) we can fill it in all 
	columns which have weight values > wi. Now two possibilities can take place: 

	Fill wi in the given column.
	Do not fill wi in the given column.

	Now we have to take a maximum of these two possibilities:
	1) If we do not fill ith weight in jth column then DP[i][j] state will be same as DP[i-1][j]

	2) If we fill the weight, DP[i][j] will be equal to the value of wi + value of the column
	weighing j-wi in the previous row. 

	So we take the maximum of these two possibilities to fill the current state.
	*/

	static int KnapSackDP(int[] val, int[] weight, int n, int w)
	{
		//WRITE YOUR CODE HERE
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			val[i] = sc.nextInt();
			wt[i] = sc.nextInt();
		}
		
		System.out.println(KnapSackDP(val, wt, n, w));
	}
}