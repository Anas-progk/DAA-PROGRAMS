/*you are  working as a software engineer, you want to earn some passive income, 
you find the best way of investing in shares.you are analyzing the stock market 
when to purchase and sell shares.As part of this you are given an array prices 
where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and 
choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.

Example 1:
input =6
7 1 5 3 6 4
output = 5
Explanation:
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed 
because you must buy before you sell.

Example 2:
input = 5
7 6 4 3 1
output=0

Example 3:
input = 8
10 9 8 7 9 6 12 10
output = 6
*/
class BuyAndSellStock 
{
	public int maxProfit(int prices[]) 
	{
       int profit=0,buy=prices[0];
	   for(int i=0;i<prices.length;i++)
	   {
		if(buy>prices[i]) buy =prices[i];
		profit=Math.max(profit,prices[i]-buy);
		System.out.println("iteration "+i);
		System.out.println("buy "+buy);
		System.out.println("profit "+profit+"\n");
	}
	return profit;
    }
	public static void main(String args[])
	{
		int ar[]={10,9,8,7,9,6,12,10};
		System.out.println(new BuyAndSellStock().maxProfit(ar));
	}
}
