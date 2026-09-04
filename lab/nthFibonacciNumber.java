import java.util.*;
public class nthFibonacciNumber 
{
    static int fib(int n)
    {
        if(n==0 || n==1) return n;
        return fib(n-1)+fib(n-2);
    }
    static int sumOfFib(int n)
    {
        int sum=0;
        for(int i=0;i<n;i++) sum+=fib(i);
        return sum;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        for(int i=0;i<n;i++) System.out.println(fib(i));
    }
}
