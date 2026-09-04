/*
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

******* Testcases *******
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

/*
1) Start at speed=1
2) Given the current speed, calculate how many hours Koko needs to eat all of the piles.
	i) If Koko cannot finish all piles within h hours, 
		increment speed by 1, that is speed=speed+1 and start over step 2.
	ii) If Koko can finish all piles within h hours, go to step 3.
3) Return the speed as the answer.

Space complexity: O(1)
Time complexity: O(nm)

For each eating speed speed, we iterate over piles and calculate the overall time, which takes O(n)time.
Before finding the first workable eating speed, we must try every smaller eating speed. 
Suppose in the worst-case scenario (when the answer is m), we have to try every eating speed 
from 1 to m, that is a total of m iterations over the array.
*/

import java.util.*;

public class KokoEatingBananas_BF
{	
	public static int minEatingSpeed(int[] piles, int hrs) 
	{
		// Start at an eating speed of 1.
        int speed = 1;

        while (true) 
		{
            // hourSpent stands for the total hour Koko spends with 
            // the given eating speed.
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / speed)
            for (int pile : piles) 
			{
                hourSpent += Math.ceil((double) pile / speed);
                if (hourSpent > hrs)
                    break;
            }

            // Check if Koko can finish all the piles within h hours,
            // If so, return speed. Otherwise, let speed increment by
            // 1 and repeat the previous iteration.
            if (hourSpent <= hrs)
                return speed;
            else
                speed += 1;            
        }
    }

	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().split(" ");	
		
        int[] boxes = new int[str.length];
        for (int i = 0; i < str.length; i++)
            boxes[i] = Integer.valueOf(str[i]);
 
		int hours = sc.nextInt();
		System.out.println(minEatingSpeed(boxes, hours));
	}
}
