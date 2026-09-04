/*MAXIMUM NUMBER OF ACTIVITIES
You are given N activities. Each activity has a start time and an end time.

A person can participate in only one activity at a time. An activity can be selected only if its start time is greater than or equal to the end time of the previously selected activity.

Your task is to select the maximum possible number of non-overlapping activities.

Input Format:
The first line contains an integer N, representing the number of activities.
The next N lines contain two space-separated integers:
start_time end_time

Output Format:
Print the maximum number of activities that can be selected.

Sample Input 1:
6
1 2
3 4
0 6
5 7
8 9
5 9
Output:
4

Explanation:
One possible selection is:
(1,2) -> (3,4) -> (5,7) -> (8,9)
Therefore, the maximum number of activities is 4.

Sample Input 2:
5
1 3
2 5
4 7
6 8
8 10
Output:
3


Sample Input 3:
4
1 2
2 3
3 4
4 5
Output:
4
*/

import java.util.Scanner;

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
        // Selection sort
        for (int i = 0; i < a.length - 1; i++) 
		{
            int min = i;

            for (int j = i + 1; j < a.length; j++) 
                if (a[j].end < a[min].end)
                    min = j;

            Activity temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    static int selectActivities(Activity[] activities) 
	{
        sortByEndTime(activities);

        int count = 0;
        int lastEndTime = -1;

        for (Activity activity : activities) 
		{
            if (activity.start >= lastEndTime) 
			{
                count++;
                lastEndTime = activity.end;
            }
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

        int answer = selectActivities(activities);
        System.out.println(answer);
        sc.close();
    }
}


/*

Test Case 1:
Input:
6
1 2
3 4
0 6
5 7
8 9
5 9
Expected Output:
4


Test Case 2:
Input:
5
1 3
2 5
4 7
6 8
8 10
Expected Output:
3

Test Case 3:
Input:
4
1 2
2 3
3 4
4 5
Expected Output:
4

Test Case 4:
Input:
7
5 9
1 2
3 5
0 6
5 7
8 10
6 9
Expected Output:
4

Test Case 5:
Input:
8
2 4
1 3
5 7
6 8
8 9
9 11
10 12
12 14
Expected Output:
6
*/