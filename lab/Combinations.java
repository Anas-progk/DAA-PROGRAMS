// You are attending an interview, interviewer given a positive integer n,
// asked you to print all combinations of numbers between 1 and n having sum 'm'.
// Write a program to do this task.
// Note : 1. To avoid ambiguity, combination will be constructed in  
//           non-decreasing order.
// 	   2. Distinct combinations are to be printed, i.e [1,2] and [2,1]   
// 	      are same, if [1,2] is printed then avoid [2,1].
// 	   2. m <= n.

// input format: two integer numbers n and m
// output format : Lists

// For example,
// Example 1:
// For n = 5,m=5 the following combinations are possible:
 
// [1, 1, 1, 1, 1]
// [1, 1, 1, 2]
// [1, 1, 3]
// [1, 2, 2]
// [1, 4]
// [2, 3]
// [5]
 
// Example 2: 
// input = 4 3
//  output =
// [1, 1, 1]
// [1, 2]
// [3]


// import java.util.*;
// import java.util.stream.Collectors;

// class Main
// {
// 	// Recursive function to print all combinations of numbers from 'i' to 'n'
// 	// having sum `n`. The `index` denotes the next free slot in the output array `out`
// 	public static void printCombinations(int i, int n, int[] out, int index)
// 	{
// 		//WRITE YOUR LOGIC HERE
// 	}

// 	public static void main(String[] args)
// 	{
// 		Scanner sc = new Scanner(System.in);
// 		int n = sc.nextInt();
// 		int m = sc.nextInt();
// 		int[] out = new int[n];

// 		// print all combinations of numbers from 1 to 'n' having sum 'm'
// 		printCombinations(1, m, out, 0);
// 	}
// }
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        findCombinations(1, n, m, list);
    }

    public static void findCombinations(int start, int n, int sum, ArrayList<Integer> list)
    {
        if (sum == 0)
        {
            System.out.println(list);
            return;
        }

        for (int i = start; i <= n; i++)
        {
            if (i > sum)
                break;

            list.add(i);
            findCombinations(i, n, sum - i, list);
            list.remove(list.size() - 1);
        }
    }
}