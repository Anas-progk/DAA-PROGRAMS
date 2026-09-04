/*Given an array 'nums' of size n, return the majority element. 
The majority element is the element that appears more than n/2 times. 
You may assume that the majority element always exists in the array.

Example 1:
Input: 3 2 3
Output: 3 

Example 2: 
Input: 2 2 1 1 1 2 2
Output: 2

*/
import java.util.*;
public class MajorityElement 
{
	public static void main (String args[])
	{
		MajorityElement s = new  MajorityElement();
		Scanner sc=new Scanner(System.in);
		String[] in=sc.nextLine().trim().split(" ");
		int X[]=new int[in.length];
		for(int i=0;i<in.length;i++) X[i]=Integer.parseInt(in[i]);
		System.out.println(getMajorityElement(X,in.length)); 
	}
	static int  getMajorityElement (int X[], int n)
	{
		return getMajority(X, 0, n-1) ;
	}

	static int getMajority (int X[], int l, int r)
	{
		if(l==r) return X[l];
		int mid=(l+r)/2;
		int leftMajority=getMajority(X,l,mid);
		int rightMajority=getMajority(X,mid+1,r);
		if(leftMajority==rightMajority) return leftMajority;
		
		int lcount=countFrequency(X,l,r,leftMajority);
		int rcount=countFrequency(X,l,r,rightMajority);
		return (lcount>rcount)?leftMajority:rightMajority;
	}
	static int countFrequency (int X[], int l, int r, int majority)
	{
	    int count=0;
		for(int i=l;i<=r;i++)
		{
		    if(X[i]==majority) count++;
		}
		return count;
	}
}