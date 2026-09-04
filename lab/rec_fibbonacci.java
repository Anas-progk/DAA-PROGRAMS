/*Problem Statement: Generate Fibonacci Series Using Recursion

The Fibonacci sequence is a series of numbers in which each number 
is the sum of the two preceding numbers. The sequence starts with 0 and 1.

Write a program to generate and display the first N Fibonacci numbers using a recursive function.

Input Format:
- A single integer N representing the number of Fibonacci terms to generate.

Output Format:
- Print the first N Fibonacci numbers separated by spaces.

Sample Test Case 1:
Input:
10

Output:
0 1 1 2 3 5 8 13 21 34

Explanation:
The Fibonacci sequence begins with 0 and 1. 
Each subsequent term is obtained by adding the previous two terms:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34.

Sample Test Case 2:
Input:
7

Output:
0 1 1 2 3 5 8

Explanation:
The first seven Fibonacci numbers are generated recursively starting from 0 and 1.

*/
import java.util.*;
public class rec_fibbonacci
{
    static int fib(int n)
    {
        if(n==0 || n==1) return n;
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++) System.out.print(fib(i)+" ");
    }
}
