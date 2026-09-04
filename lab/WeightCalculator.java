/*
You are part of a computational task engine that processes a chain of nested tasks.
Each task depends on completing all its sub-tasks first, and the total weight 
of a task is calculated by multiplying the weights of all sub-tasks below it, 
down to the simplest task which has a base weight of 1.

Given a non-negative integer n, representing the depth of nested tasks,
write a function to compute the total weight of the task at depth n.
input format : an integer 
output format : an integer 

example 1:
input=5
output=120

example 2:
input=12
output=479001600
*/
import java.util.*;

class WeightCalc
{
    // Recursive method to compute the task weight
    public static int computeTaskWeight(int n)
    {
        if (n == 0 || n == 1)
            return 1;

        return n * computeTaskWeight(n - 1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int depth = sc.nextInt();
        int result = computeTaskWeight(depth);
        System.out.println(result);
    }
}