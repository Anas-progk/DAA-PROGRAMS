/*There is a board with M*N size. 
The board contains M*N blocks of 1*1 size.
Each block is printed a number on it.
You will be given a number, your task is to find whether the number is printed on any of the blocks or not. 
If found print true, otherwise print false.

NOTE: 
-The numbers printed on the board in each row are in increasing order. 
-Next row starting number is greater than the last number of the previous row.

Constarint:
-----------
Can you solve it in log(M)+ log(N) time. 

Input Format:
-------------
Line-1 -> Two integers M and N, board size.
Next M lines -> N space separated integers.
Last Line -> An integer T, number to search.

Output Format:
--------------
Print a boolean value, 'true' if number found.
otherwise, 'false'.


Sample Input-1:
---------------
4 4
1 3 6 10
12 15 19 23
24 28 32 36
37 41 44 47
15

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4 4
1 3 6 10
12 15 19 23
24 28 32 36
37 41 44 47
26

Sample Output-2:
----------------
false

*/
import java.util.*;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
	{
        int n = matrix[0].length;
        int left = 0;
        int right = matrix.length -1;
		//System.out.println("Matrix length is "+right);
        while (left <= right) 
		{
            int mid = (left + right) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) 
			    return search(matrix[mid], target);

            if (target <= matrix[mid][0])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public boolean search(int[] nums, int target) 
	{
        int left = 0;
        int right = nums.length -1;
        while (left <= right) 
		{
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return true;
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();// number of rows
		int n = sc.nextInt(); // number of columns
		int[][] ar = new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				ar[i][j]=sc.nextInt();
		int key = sc.nextInt();
		System.out.println(new Solution().searchMatrix(ar,key));




	}
}
/*

=== testcases ===
case =1
input =5 5
1 4 7 11 15
22 25 28 32 39
43 46 49 56 62
70 73 74 77 84
88 91 93 96 99
73
output =true

case =2
input =5 5
1 4 7 11 15
22 25 28 32 39
43 46 49 56 62
70 73 74 77 84
88 91 93 96 99
79
output =false

case =3
input =6 7
1 2 3 4 5 6 7
8 9 10 11 12 13 14
15 16 17 18 19 20 21
22 23 24 25 26 27 28 
29 30 31 32 33 34 35
36 37 38 39 40 41 42
24
output =true










case =4
input =6 7
1 2 3 4 5 6 7
8 9 10 11 12 13 14
15 16 17 18 19 20 21
22 23 24 25 26 27 28 
29 30 31 32 33 34 35
36 37 38 39 40 41 42
48
output =false

case =5
input =5 8 
1 3 5 7 9 11 13 15
19 22 27 29 31 33 35 37
44 48 50 56 61 63 65 67
68 76 82 88 92 96 99 101
110 118 124 130 134 138 140 142
67
output =true

case =6
input =5 8 
1 3 5 7 9 11 13 15
19 22 27 29 31 33 35 37
44 48 50 56 61 63 65 67
68 76 82 88 92 96 99 101
110 118 124 130 134 138 140 142
135
output =false

case =7
input =8 8
1 4 7 11 15 18 19 22
23 25 27 31 34 37 40 45
46 48 50 53 56 59 63 69
70 73 76 79 82 83 87 94
104 108 109 112 113 116 118 120
122 125 127 129 135 137 138 139
142 144 146 148 151 155 159 166
173 175 177 185 188 192 195 199
142
output =true

case =8
input =8 8
1 4 7 11 15 18 19 22
23 25 27 31 34 37 40 45
46 48 50 53 56 59 63 69
70 73 76 79 82 83 87 94
104 108 109 112 113 116 118 120
122 125 127 129 135 137 138 139
142 144 146 148 151 155 159 166
173 175 177 185 188 192 195 199
66
output =false



*/