/*Type II: Infinite transactions are allowed
Given an array price[] of length N, representing the prices of the stocks on different days,
the task is to find the maximum profit possible for buying and selling the stocks on
different days using transactions where any number of transactions are allowed.

nput: prices[] = {7, 1, 5, 3, 6, 4} 
Output: 7
Explanation:
Purchase on 2nd day. Price = 1.
Sell on 3rd day. Price = 5.
Therefore, profit = 5 – 1 = 4.
Purchase on 4th day. Price = 3.
Sell on 5th day. Price = 6.
Therefore, profit = 4 + (6 – 3) = 7.

Input: prices = {1, 2, 3, 4, 5} 
Output: 4
Explanation: 
Purchase on 1st day. Price = 1.
Sell on 5th day. Price = 5. 
Therefore, profit = 5 – 1 = 4.

Approach: The idea is to maintain a boolean value that denotes if there is 
any current purchase ongoing or not. If yes, then at the current state, 
the stock can be sold to maximize profit or move to the next price without 
selling the stock. Otherwise, if no transaction is happening, the current 
stock can be bought or move to the next price without buying.
*/
    class BTBS2
	{
        public static void main(String [] args)
		{
        int arr[]={7, 1, 5, 3, 6, 4};
        System.out.println(BTBS(arr,arr.length));
        }
		public static int BTBS(int prices[] , int n)
		{
            int profit=0;
           for(int i=1;i<n;i++)
           {
            if(prices[i]>prices[i-1]) profit+=prices[i]-prices[i-1];
            }
           return profit;
        }
    }