

/*Given the array of strings S[], you need to find the 
longest string S which is the prefix of ALL the strings 
in the array. 
Longest common prefix (LCP) for a pair of strings 
S1 and S2 is the longest string S which is the 
prefix of both S1 and S2. 

Examples: 
case=1
input=abcdefgh abcefgh 
output=abc

case=2
input=abcdefgh aefghijk abcefgh 
output=a
*/










import java.util.*;
class LongestCommonPrefix 
{
	public String longestCommonPrefix(String[] strs)
	{
		if (strs == null || strs.length == 0) 
			return "";    
		return LCP(strs, 0 , strs.length-1);
	}

	
	
	private String LCP(String[] strs, int l, int r) 
	{
		//System.out.println("LCP Called with "+(l+1)+" and "+(r+1));
		if (l == r)
			return strs[l];
		else 
		{
			int mid = (l + r)/2;
			String lcpLeft =   LCP(strs, l , mid);
			String lcpRight =  LCP(strs, mid + 1,r);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}






	String commonPrefix(String left,String right)
	{
		System.out.println("left "+left+" right "+right);
		int min = Math.min(left.length(), right.length());       
		for (int i = 0; i < min; i++)
			if ( left.charAt(i) != right.charAt(i) )
			{
				System.out.println("Common Prefix "+left.substring(0, i)+"\n");
				return left.substring(0, i);
			}
		
		System.out.println("Common Prefix "+left.substring(0, min)+"\n");
		return left.substring(0, min);
	}

	public static void main(String args[]) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Strings");
		String[] words = sc.nextLine().split(" ");
		System.out.println("Longest common Prefix is: "+new LongestCommonPrefix().longestCommonPrefix(words));
	}
}








/*
case=1
input=abcdefgh abcefgh 
output=abc

case=2
input=abcdefgh aefghijk abcefgh 
output=a

case=3
input=interview interstellar international internet intermittent interstate internal intercom
output=inter


case=4
input =intermediationist intermediationism intermediately intermediate intermediatehood intermediateism intermediatistic intermediate-grade intermediate-term intermediativity
output =intermediat

case=5
input =encyclopedia encyclopedic encyclopedically encyclopedias encyclopedists encyclopedism encyclopedical encyclopedist encyclopediac encyclo
output =encyclo
*/