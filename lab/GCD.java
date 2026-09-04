import java.util.*;
public class GCD 
{
	public static int calculateGCD(int a, int b)
	{
		if(a==b) return a;
		if(b==0) return a;
		if(a==0) return b;
		return a>b?calculateGCD(a%b,b):calculateGCD(a,b%a);
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a= in.nextInt();
		int b= in.nextInt();
		System.out.println(calculateGCD(a, b));
	}
} 
    

