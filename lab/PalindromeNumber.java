/*In the abc Galaxy, space stations are protected by digital access gates that 
only accept symmetric codes. The command center at the docking port uses a special 
validator system that only unlocks the gate if the entry code is a palindrome number.

A palindrome number is a number that remains the same when its digits are 
reversed — like 121, 1331, or 7.

As a security software developer for the Andromeda Mission, 
your job is to write a program that:
Takes a numeric entry code
Checks whether it is a valid symmetric code (i.e., a palindrome number)
Displays whether access should be GRANTED or DENIED

sample test case:
case=1
input=1223221
output=ACCESS GRANTED FOR 1223221 

case=2
input=1234
output=ACCESS DENIED FOR 1234

import java.util.*;
public class PalindromeNumber 
{
	public static void main(String[] args) 
	{
		//WRITE YOUR CODE HERE
	}
	public static boolean isPalindrome(int X )
	{
		//WRITE YOUR CODE HERE
	}
	
	public static int rev(int N, int reversed)
	{
		//WRITE YOUR CODE HERE
	}
}
    */

import java.util.*;

public class PalindromeNumber
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (isPalindrome(x))
            System.out.println("ACCESS GRANTED FOR " + x);
        else
            System.out.println("ACCESS DENIED FOR " + x);

        sc.close();
    }

    public static boolean isPalindrome(int X)
    {
        if (X < 0)
            return false;

        return X == rev(X, 0);
    }

    public static int rev(int N, int reversed)
    {
        if (N == 0)
            return reversed;

        return rev(N / 10, reversed * 10 + (N % 10));
    }
}