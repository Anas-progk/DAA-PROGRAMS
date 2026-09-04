import java.util.*;
public class Power_Dnc
{
	public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(power(x,n));
    }


    // Optimized recursive solution to calculate `pow(x, n)`
    // using divide-and-conquer
    public static long power(int x, int n)
    {
        if(n==0) return 1;
        if(n<0) return power(x,-n);
        long half=power(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
    
}
/*
implement power function using Iterative and Recursive Given two integers, 
x and n, where x and n are +ve are –ve numbers, efficiently compute 
the power function pow(x, n).

Sample Testcases:
case=1
input=-2 10
output=1024 

case=2
input=-3 4
output=81 

case=3
input=-2 3
output=-8
*/
import java.util.*;
public class Power_Dnc
{
	public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(power(x,n));
    }


    // Optimized recursive solution to calculate `pow(x, n)`
    // using divide-and-conquer
    public static long power(int x, int n)
    {
        if(n==0) return 1;
        if(n<0) return power(x,-n);
        long half=power(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
    
}