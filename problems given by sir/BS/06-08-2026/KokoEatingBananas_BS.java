/*Koko loves to eat bananas. 
There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K. 
Each hour, she chooses some pile of bananas and 
eats K bananas from that pile.
If the pile has less than K bananas, she eats all of them 
instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating 
all the bananas before the guards return.

Return the minimum integer K such that she can eat all the 
bananas within H hours.


Sample Input-1:
---------------
4 8 9 13
8

Sample Output-1:
----------------
5

Sample Input-2:
---------------
15 18 12 17 22
7

Sample Output-2:
----------------
17



/*
1) Initialize the two boundaries of the binary search 
as left=1, right=max(piles).

2) Get the middle value from left and right, that is, 
middle=(left+right)/2, 
this is Koko's eating speed during this iteration.

3) Iterate over the piles and check if Koko can eat 
all the piles within h hours given at this eating speed

4) If Koko can finish all the piles within h hours, 
set right equal to middle signifying that 
all speeds greater than middle are less desirable for Koko. 

Otherwise, set left equal to middle+1 signifying that 
all speeds less than or equal to middle are not workable.

5) Repeat the steps 2, 3, and 4 until the two boundaries 
overlap, i.e., left==right, which means that we have 
found the minimum speed by which Koko could finish 
eating all the piles within h hours. 

We can return either left or right as the answer. 

Space complexity: O(1)

Time complexity: O(n⋅log ⁡m)

The initial search space is from 1 to m, 
it takes "log ⁡m "comparisons to reduce search space to 1.
For each eating speed middle, we traverse the array and 
calculate the overall
time Koko spends, which takes O(n) for each traversal.

*/















import java.util.*;

public class KokoEatingBananas_BS 
{
	public static int minEatingSpeed(int[] piles, int hrs) 
	{
		// Initalize the left and right boundaries 
        int left = 1, right = 1;
        for (int pile : piles) 
            right = Math.max(right, pile);

        while (left < right) 
		{
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles)
                hourSpent += Math.ceil((double) pile / middle);

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= hrs)
                right = middle;
			else
                left = middle + 1;
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }	

	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");	
		
        int[] boxes = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            boxes[i] = Integer.valueOf(str[i]);
        }
 
		int hours = sc.nextInt();
		System.out.println(minEatingSpeed(boxes, hours));
	}
}


/******* Testcases *******
case =1
input =3 6 7 11
8
output =4

case =2
input =6 9 12 13
7
output =7

case =3
input =9 5 7 3 12 8
10
output =6

case =4
input =12 65 43 37 85 73 92 56
35
output =15

case =5
input =9 3 8 6 4 5 7
16
output =3

case =6
input =11 15 18 17 12 14 13 19 16
20
output =9

case =7
input =23 17 18 15 16 26 27
15
output =13

case =8
input =8 5 6 4 9 5 3 7 8 10 12 16 15 18 19 13
23
output =10

*/