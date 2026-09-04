/*MAXIMUM NUMBER OF ACTIVITIES
You are given N activities. Each activity has a start time and an end time.

A person can participate in only one activity at a time. An activity can be 
selected only if its start time is greater than or equal to the end time of the 
previously selected activity.

Your task is to select the maximum possible number of non-overlapping activities.

Input Format:
-------------
The first line contains an integer N, representing the number of activities.

The next N lines contain two space-separated integers:
start_time end_time

Output Format:
--------------
Print the maximum number of activities that can be selected.

Sample Input 1:
---------------
6
1 2
3 4
0 6
5 7
8 9
5 9

Sample Output 1:
----------------
4

Explanation:
------------
One possible selection is:

(1,2) -> (3,4) -> (5,7) -> (8,9)

Therefore, the maximum number of activities is 4.


Sample Input 2:
---------------
5
1 3
2 5
4 7
6 8
8 10

Sample Output 2:
----------------
3


Sample Input 3:
---------------
4
1 2
2 3
3 4
4 5

Sample Output 3:
----------------
4

*/

import java.util.*;
public class MaxActivities 
{

    static class Activity 
	{
        int start, end;

        Activity(int start, int end) 
		{
            this.start = start;
            this.end = end;
        }
    }

    static void sortByEndTime(Activity[] a) 
	{
        Arrays.sort(a,Comparator.comparingInt(x->x.end));
    }

    static int selectActivities(Activity[] activities) 
	{
        sortByEndTime(activities);
        int count=0,prevEnd=0;
        for(Activity c:activities)
        {
            if(c.start>=prevEnd)
            {
                prevEnd=c.end;
                count++;
            }
            else continue;
        }
        return count;
    }

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) 
		{
            int start = sc.nextInt();
            int end = sc.nextInt();
            activities[i] = new Activity(start, end);
        }
        System.out.println(selectActivities(activities));
        sc.close();
    }
}