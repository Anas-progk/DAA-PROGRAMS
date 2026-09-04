/* Fractional Knapsack Problem

You are given n items, each with a specific weight and value. 
You are also given a knapsack that can hold a maximum weight W. 
The goal is to maximize the total value in the knapsack by selecting items to add.

NOTE: You can take fractions of items instead of having to take the whole item. 
You need to calculate the maximum possible value that can be achieved.

Input Format:
-------------
Line-1: Two integers n and W representing the number of items and the maximum weight capacity of the knapsack, respectively.
Line-2 to n: Each line contains two integers value and weight for each item.

Output Format:
--------------
Line-1: Printing the maximum total value that can be obtained in the knapsack, 
rounded to two decimal places.

Constraints:
-------------
1 <= n <= 10^5
0 <= W <= 10^9
1 <= value, weight <= 10^9

Sample Input-1:
---------------
3 50
60 10
100 20
120 30

Sample Output-1:
----------------
240.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 10).
The second item can be added in full (value = 100, weight = 20).
The third item can be added partially, using only 20 out of 30 weight capacity, 
which gives a value of (120/30) * 20 = 80.
Thus, the total value is 60 + 100 + 80 = 240.

Sample Input-2:
---------------
2 50
60 20
100 50

Sample Output-2:
----------------
160.00

Explanation:
------------
The first item can be added in full (value = 60, weight = 20).
From the second item, only 30 weight units can be used, 
so the value will be (100/50) * 30 = 60.
Thus, the total value is 60 + 60 = 160.

Sample Input-3:
---------------
1 10
500 30

Sample Output-3:
----------------
166.67

Explanation:
------------
The item has a value of 500 and a weight of 30. Since the knapsack can only hold 10 units of weight, we take a fraction of the item.
The value of 10 units from the first item is (500/30) * 10 = 166.67.
Thus, the total value is 166.67
*/

import java.util.*;

// item value class
class ItemValue implements Comparable<ItemValue>
{
	int value, weight;
	ItemValue(int value, int weight)
	{
		this.value = value;
		this.weight = weight;
	}
	public int getValue()
	{
		return value;
	}
	public int getWeight()
	{
		return weight;
	}
	@Override
	public int compareTo(ItemValue v1)
	{
		double ratio = (double)this.value/this.weight;
		double ratio2 = (double)v1.value/v1.weight;
		return Double.compare(ratio2, ratio);
	}
	@Override
	public String toString()
	{
		String s = getValue() + "," + getWeight();
		return s;
	}
}

public class Knapsack 
{
	// function to get maximum value
	private static double getMaxValue(ItemValue[] arr, int capacity)
	{		
		printItems(arr);

		// sorting items by value/weight ratio;
		Arrays.sort(arr);

		System.out.println("After sorting");
		printItems(arr);

		double totalValue = 0d;
		for (ItemValue item : arr) 
		{
			if (capacity - item.getWeight() >= 0) 
			{
				// this item can be picked whole
				capacity -= item.getWeight();
				totalValue += item.getValue();
			}
			else 
			{
				// item item cant be picked whole
				totalValue += item.getValue() * ((double) capacity / item.getWeight());
				break;
			}
		}
		return totalValue;
	}

	static void printItems(ItemValue[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println("[" + arr[i] + "]");
		}
	}

	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        // Read number of items and capacity
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        // Create array
        ItemValue[] arr = new ItemValue[n];
        // Read value and weight
        for (int i = 0; i < n; i++) 
		{
            int value = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new ItemValue(value, weight);
        }
        // Calculate maximum value
        double maxValue = getMaxValue(arr, capacity);
        // Print answer to 2 decimal places
        System.out.printf("%.2f\n", maxValue);
        sc.close();
	}
}

/*

case = 1
input =1 10
500 30
output =166.67

case = 2
input =1 50
1000 50
output =1000.00

case = 3
input =3 60
60 10
100 20
120 30
output =280.00

case = 4
input =3 50
100 20
60 10
120 30
output =240.00

case = 5
input =2 0
50 5
100 10
output =0.00

case = 6
input =0 50
output =0.00

case = 7
input =1 999999999
1000000000 1000000000
output =999999999.00

case = 8
input =3 1000000000
100000000 200000000
200000000 300000000
300000000 400000000
output =600000000.00

case = 9
input =5 10
3000 40
1000 20
2000 30
4000 50
5000 60
output =833.33

case = 10
input =4 5
50 10
60 20
70 30
80 40
output =25.00

*/
