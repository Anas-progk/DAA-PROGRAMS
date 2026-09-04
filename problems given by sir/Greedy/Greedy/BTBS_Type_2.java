/*Type II: Infinite transactions are allowed
Given an array price[] of length N, 
representing the prices of the stocks on different days, 
the task is to find the maximum profit possible for 
buying and selling the stocks on different days using transactions 
where "any number of transactions are allowed".

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

Approach: 
The idea is to maintain a boolean value that denotes if there is any current purchase ongoing or not. 

If yes, then at the current state, the stock can be sold to maximize profit or 
			move to the next price without selling the stock. 
Otherwise, if no transaction is happening, 
			the current stock can be bought or move to the next price without buying.
*/

	import java.util.*;
    class BTBS_Type_2
	{
        public static void main(String [] args)
		{
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
           System.out.println(BTBS(arr,n));
        }
		public static int BTBS(int arr[] , int n)
		{
           int profit=0;
            for(int i=0;i<n-1;i++)
			{
                if(arr[i]<arr[i+1])
				{
					System.out.println("\n"+arr[i]+" is < "+arr[i+1]);
                    profit+=(arr[i+1]-arr[i]);
					System.out.println("Updated Prifit "+profit);
                }
            }
            return profit;
        }
    }


/*
case=1
input=6
7 1 5 3 6 4
output=7

case=2
input=5
1 2 3 4 5
output=4

case=3
input=7
7 6 5 4 3 2 1
output=0

case=4
input=5
10 50 20 30 25
output=50

case=5
input=8
100 80 50 70 60 75 30 40
output=45
*/