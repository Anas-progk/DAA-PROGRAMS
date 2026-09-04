/*In the year 3125, interstellar travel is regulated by AI-driven access 
systems at every galaxy portal. These portals grant access only to 
registered starships, each assigned a unique entry code.

However, due to security upgrades, a portal now uses a mathematical logic 
to detect fraudulent ships. The portal opens only if the entry code is an Armstrong number.

A number is called an Armstrong number (also known as a narcissistic number) 
if the sum of its digits raised to the power of the number of digits equals the original number.

For example:

153 is an Armstrong number because:
1^3+5^3+3^3=1+125+27=153
You've been hired to build a verification module for the access portal.

case=1
input=153
output=ACCESS APPROVED

case=2
input=123
output=ACCESS DENIED


import java.util.*;
class ArmstrongNumber 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		//WRITE YOUR CODE HERE
	}
	public static int ArmNum(int N)
	{
		//WRITE YOUR CODE HERE
	}
}*/
import java.util.*;

class ArmstrongNumber
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num == ArmNum(num))
            System.out.println("ACCESS APPROVED");
        else
            System.out.println("ACCESS DENIED");
    }

    public static int ArmNum(int N)
    {
        int temp = N;
        int digits = 0;

        // Count the number of digits
        while (temp > 0)
        {
            digits++;
            temp /= 10;
        }

        // Handle the case when N = 0
        if (N == 0)
            digits = 1;

        temp = N;
        int sum = 0;

        // Calculate sum of digits^digits
        while (temp > 0)
        {
            int digit = temp % 10;
            sum += (int)Math.pow(digit, digits);
            temp /= 10;
        }

        // Handle N = 0
        if (N == 0)
            sum = 0;

        return sum;
    }
}