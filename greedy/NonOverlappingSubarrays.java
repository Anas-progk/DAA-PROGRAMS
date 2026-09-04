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

SAMPLE case=1
input= 7 3
1 2 2 -1 3 1 3
Output: 2

Explanation: Possible subarrays with sum 3 include:
[1, 2]       -> indices 0 to 1
[3]          -> index 4
[-1, 3, 1]   -> indices 3 to 5
[3]          -> index 6

One optimal selection is:
[1, 2] and [3]

Therefore, the maximum number of non-overlapping subarrays is 2.


SAMPLE case=2
input=
6 5
2 3 1 4 1 4
Output: 2

Explanation:
[2, 3] -> sum = 5
[1, 4] -> sum = 5

Therefore, the answer is 2.

SAMPLE case=3
input=
5 3
1 2 1 2 1
Output: 2

Explanation:
One optimal selection is:
[1, 2] -> sum = 3
[1, 2] -> sum = 3

Therefore, the answer is 2.

KEY GREEDY STRATEGY
--------
*Process the array from left to right.
*Maintain the prefix sum of the current segment.
*If the current prefix sum is S, then a subarray ending at the current
position has sum K if a previous prefix sum equal to:
S - K
has already been seen.
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
*/

import java.util.*;

public class NonOverlappingSubarrays 
{
    static int maximumNonOverlappingSubarrays(int[] arr, long k) 
	{
        long s=0;int count=0;
        LinkedHashMap <Long,Integer> hm=new LinkedHashMap<>();
        hm.put(0L, 1);
        for(int i=0;i<arr.length;i++)
        {System.out.println("iteration "+i);
            s+=arr[i];
            System.out.println(hm);
            if(hm.containsKey(s-k))
            {
                count++;
                System.out.println("entered if s k count "+s+" "+k+" "+count);
                s=0;
                hm.clear();
                hm.put(0L, 1);
            }
            else hm.put(s,hm.getOrDefault(s,0)+1);
            System.out.println("\n");
        }
        return count;
    }


    public static void main(String[] args) 
	{
        int arr[]={1,1,1,1,1};
        long k=2;
        int answer = maximumNonOverlappingSubarrays(arr, k);
        System.out.println(answer);
    }
}
