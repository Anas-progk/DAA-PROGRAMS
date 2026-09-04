/*Mr. Jack runs a fruit market. In his storage, fruits are arranged in sorted order:
	First, all the unripe fruits are kept.
	Then, all the ripe fruits are placed after them.

Since the arrangement is sorted, all the unripe fruits (0) always come before the ripe fruits (1).

Jack wants to quickly find out how many ripe fruits are present in the storage. Can you help him solve this efficiently?

input Format : 
integer number n
n number of integers (contains 0s and 1s only in a sorted order)

output Format :
An integer (Number of 1's)

Sample Test Cases
example 1:
input =5
0 0 1 1 1
output =3

Example 2:
input =10
1 1 1 1 1 1 1 1 1 1
output =10

*/
//Binary Search Solution

import java.util.*;

class CountOnes{
    // Function to find the first index of 1 using binary search
    public static int firstOneIndex(int[] nums, int n) {
        // W Y C H
    }

    public static int countOnes(int[] nums, int n) {
       //W Y C H
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(countOnes(nums, n));
    }
}