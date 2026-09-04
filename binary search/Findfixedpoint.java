import java.util.*;
class Findfixedpoint 
{

	static int fixedpoint(int a[], int l, int h)
	{
	    if(l>h) return -1;
	    int m=l+(h-l)/2;
	    if(a[m]==m) return m;
        else if(a[m-1]<l && a[m+1]>h) return -1;
	    if(a[m-1]>l) return fixedpoint(a,l,m-1);
	    else return fixedpoint(a,m+1,h);
	}

	// main function
	public static void main(String args[])
	{
        Scanner sc=new Scanner(System.in);        
        int n = sc.nextInt(); 
        int array[]=new int[n];
        for(int i=0;i<n;i++)
          array[i] =sc.nextInt();
		System.out.println(fixedpoint(array, 0, n - 1));
        sc.close();
	}
}
