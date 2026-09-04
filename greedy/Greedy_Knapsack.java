/*
Greedy approach solves Fractional Knapsack problem reasonably in a good time
In this problem we have a Knapsack that has a weight limit M.
There are items i1, i2, ..., in each having weight w1, w2, ... wn and 
some benefit (value or profit) associated with its p1, p2, ..., pn.

Our objective is to maximize the benefit such that the total weight inside 
the knapsack is at most N, and we are also allowed to take an item in fractional part.


EXAMPLES
input:
60				//Kanpsack size
4				//No.of Items
40 10 20 24		//Weigths of Items
280 100 120 120	//Profits of Items
output: 440.0

feasible solution is
Itemno  Weights Profits pi/wi Ratio     Selected
2       10.0    100.0   10.0            1.0
1       40.0    280.0   7.0             1.0
3       20.0    120.0   6.0             0.5
4       24.0    120.0   5.0             0.0
Optimal Solution: Maximum Profit is
440.0


input:
16
6

6 10 3 5 1 3
6 2  1 8 3 5
output: 22.333334

feasible solution is
Itemno  Weights Profits pi/wi Ratio     Selected
5       1.0     3.0     3.0             1.0
6       3.0     5.0     1.6666666       1.0
4       5.0     8.0     1.6             1.0
1       6.0     6.0     1.0             1.0
3       3.0     1.0     0.33333334      0.33333334
2       10.0    2.0     0.2             0.0
Total Profit is
22.333334

Sample Test Case:
case =1
input =4 15
10 2
10 4
12 6
18 9
output =38.0
*/
import java.util.*;
public class Greedy_Knapsack 
{
	public static float knapsack(int W, int wt[], int val[], int n) 
	{
		Integer indices[]=new Integer[n];
		for(int i=0;i<indices.length;i++) indices[i]=i;
		Arrays.sort(indices,(a,b)->{
			double r1=(double)val[a]/wt[a];
			double r2=(double)val[b]/wt[b];
			return Double.compare(r2,r1);
		});
		float totalVal=0;
		for (int i = 0; i < n; i++) {
			int item = indices[i];

			if (wt[item] <= W) {
				totalVal += val[item];
				W -= wt[item];
			} else {
				totalVal += (float) val[item] / wt[item] * W;
				break;
			}
		}
		return totalVal;
	}
	public static void main(String[] args) 
	{
		int N =4;
		int[] val = {280,100,120,120};
		int[] wt = {40,10,20,24};
		int W =60;
      System.out.print(knapsack(W, wt, val, N));
	}
}