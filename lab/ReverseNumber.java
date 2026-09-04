/*
A secret underground vault stores rare scientific artifacts. 
It can only be unlocked with a reverse-coded pass number.

The scientists use a handheld scanner that reads the actual number entered by 
the user, but the vault mechanism expects the digits in reverse order. 
For instance, if the user types 4371, the system expects 1734 to open the vault.

You are tasked with writing a program for the scanner software that automatically 
reverses the pass number before sending it to the vault system.
Use recursion instead of loops.

Sample Test Case:
Input: 123
Output: 321

import java.util.*;
public class ReverseNumber 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(rev(num,0));
	}
	public static int rev(int N, int reversed)
	{
		//WRITE YOUR CODE HERE
	}
}
*/
import java.util.*;

public class ReverseNumber 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(rev(num, 0));
    }

    public static int rev(int N, int reversed)
    {
        if (N == 0)
            return reversed;

        return rev(N / 10, reversed * 10 + (N % 10));
    }
}