/*John is working as a software engineer.
He want to earn some passive income by finding the best way of investing in shares.
He is analyzing the stock market when to purchase and sell shares.
As part of this he is given an array prices where 
prices[i] is the price of a given stock on the ith day.
He want to maximize your profit by choosing a single day to buy one stock 
and choosing a different day in the future to sell that stock.

Return the maximum profit he can achieve from this transaction. 
If he cannot achieve any profit, return 0.

Example 1:
input =6
7 1 5 3 6 4
output = 5
Explanation:
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you 
sell.

Example 2:
input = 5
7 6 4 3 1
output=0

Example 3:
input = 8
10 9 8 7 9 6 12 10
output =6
*/
import java.util.*;
class BuyAndSellStock 
{
	public int maxProfit(int prices[]) 
	{
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
		System.out.println("Check MAX_PROFIT at each day");
		System.out.println("INITIALLY:\nMAX_PROFIT is 0");
        for (int i = 0; i < prices.length; i++) 
		{
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
		System.out.println("\n"+Arrays.toString(Arrays.copyOfRange(prices,0,i+1)));
		System.out.println("DAY-"+(i+1)+"\nMinPrice as of today: "+minprice+"\nMAX_PROFIT: "+maxprofit);
		}
        return maxprofit;
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();
		System.out.println(new BuyAndSellStock().maxProfit(ar));
	}
}
/*
Test cases:
case =1
input =8
6 1 7 2 8 9 4 10
output=9

case =2
input=6
9 8 7 6 5 4
output=0

case =3
input=6
9 8 4 5 3 2
output=1

case =4
input=8
1 2 3 4 5 6 7 8
output=7

case =5
input=12
8 7 6 5 4 3 2 1 2 3 4 5
output=4
*/