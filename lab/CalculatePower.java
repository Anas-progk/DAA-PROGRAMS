/*Input two integers x and n
Calculate power(x,n) using Recursion

We can recursively define the problem as:
power(x, n) = power(x, n / 2) × power(x, n / 2);        // otherwise, n is even
power(x, n) = x × power(x, n / 2) × power(x, n / 2);    // if n is odd*


Example Test Cases
input=2 10
output=1024

input=-5 7
output=-78125*/
import java.util.*;

public class PowerRecursion
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(power(x, n));
    }

    public static long power(int x, int n)
    {
        // Base case
        if (n == 0)
            return 1;

        long half = power(x, n / 2);

        if (n % 2 == 0)
            return half * half;
        else
            return x * half * half;
    }
}