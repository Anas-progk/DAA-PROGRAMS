import java.util.*;
public class medianOfTwoSortedArrays 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int m = sc.nextInt(); 
		int A[]=new int[m];
		for(int i=0;i<m;i++)
			A[i] =sc.nextInt();

		int n = sc.nextInt(); 
		int B[]=new int[n];		
		for(int i=0;i<n;i++)
			B[i] =sc.nextInt();
		
		System.out.println(findMedian(A, B));
        sc.close();
	}
	private static double findMedian(int[] A, int[] B) 
	{
		int m=A.length,n=B.length;
        return m>n?partition(B,A):partition(A,B);
	}
	static double partition(int[] A,int[] B)
    {
        int l=0,m=A.length,n=B.length,r=m;
        while(l<=r)
        {
            int ap=(l+r)/2;int bp=(m+n+1)/2-ap;
            int almax= (ap==0) ?Integer.MIN_VALUE:A[ap-1];
            int armin= (ap==m) ?Integer.MAX_VALUE:A[ap];
            int blmax= (bp==0) ?Integer.MIN_VALUE:B[bp-1];
            int brmin= (bp==n) ?Integer.MAX_VALUE:B[bp];
            if(almax<=brmin && blmax<=armin)
            {
                if((m+n)%2==1) return Math.max(almax,blmax);
                else return (Math.max(almax,blmax)+Math.min(armin,brmin))/2.0;
            }
            else if(almax>brmin) r=ap-1;
            else l=ap+1;
        }
        return -1;
    }
}