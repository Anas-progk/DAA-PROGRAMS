/* MAXIMUM NON-OVERLAPPING SUBARRAYS

You are given an array of N integers and an integer K.
Your task is to select the maximum possible number of non-overlapping
contiguous subarrays such that the sum of elements in every selected
subarray is exactly K.

Two subarrays are considered non-overlapping if they do not share any
array index.
Return the maximum number of such non-overlapping subarrays.

INPUT FORMAT
The first line contains two space-separated integers:
N K
The second line contains N space-separated integers representing the array.

OUTPUT FORMAT
Print a single integer representing the maximum number of non-overlapping
subarrays whose sum is exactly K.

CONSTRAINTS
1 <= N <= 2 * 10^5
-10^9 <= A[i] <= 10^9
-10^9 <= K <= 10^9

case=1
input=7 30
10 20 20 -10 30 10 30
output=3

We can select the following three subarrays that do not share any indices:
Subarray 1: [10, 20] (indices 0 to 1) -> Sum = 30
Subarray 2: [-10, 30, 10] (indices 3 to 5) -> Sum = 30
Subarray 3: [30] (index 6) -> Sum = 30

Therefore, the maximum number of non-overlapping subarrays is 3.
KEY GREEDY STRATEGY
*Process the array from left to right.
*Maintain the prefix sum of the current segment.
*If the current prefix sum is S, then a subarray ending at the current
position has sum K if a previous prefix sum equal to: S - K has already been seen.
Whenever such a prefix sum is found, select that subarray immediately.
This is the greedy choice:
	Select a valid subarray as soon as it ends.

Choosing the earliest possible ending subarray leaves the maximum possible
space for selecting additional subarrays later.

After selecting a subarray:
    1. Increment the answer.
    2. Reset the prefix sum.
    3. Clear the prefix-sum map.
    4. Insert prefix sum 0 into the new map.

This ensures that all subsequently selected subarrays start after the
previously selected subarray.

Sample Test Case
input=7 30
10 20 20 -10 30 10 30
output=30
*/

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NonOverlappingSubarrays 
{
    static int maximumNonOverlappingSubarrays(int[] arr, long k) 
	{
        Map<Long, Integer> prefixSumMap = new LinkedHashMap<>();

        long prefixSum = 0;
        int count = 0;

        // Prefix sum 0 exists before the first element
        prefixSumMap.put(0L, -1);

        for (int i = 0; i < arr.length; i++) 
		{
			System.out.println(prefixSumMap.toString());
            prefixSum += arr[i];
            // If prefixSum - k has already occurred, then the subarray after that position up to i has sum exactly k. 
            if (prefixSumMap.containsKey(prefixSum - k))
			{
                count++;
                // Greedy choice: Select the subarray immediately because it ends at the earliest possible position. Start a new segment after this subarray.
                prefixSum = 0;

                prefixSumMap.clear();
                prefixSumMap.put(0L, i);
            }
            else 
			{  //Store the prefix sum only if it has not been seen before. 
                prefixSumMap.putIfAbsent(prefixSum, i);
            }
        }
        return count;
    }


    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int answer = maximumNonOverlappingSubarrays(arr, k);
        System.out.println(answer);
        sc.close();
    }
}


/*
case=1
input=7 30
10 20 20 -10 30 10 30
output=30

case=2
input=6 5
2 3 1 4 1 4
output=3

case=3
input=5 3
1 2 1 2 1
output=2

case=4
input=10 4
1 3 2 2 -1 5 1 3 -2 6
output=5

case=5
input=8 0
1 -1 2 -2 3 -3 4 -4
output=4
*/