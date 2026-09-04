import java.util.*;
class LongestCommonPrefixBS 
{    
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter words separated by space:");
        String[] words = sc.nextLine().split(" ");
        
        LongestCommonPrefixBS lcp = new LongestCommonPrefixBS();
        System.out.println("Longest Common Prefix is: " + lcp.longestCommonPrefix(words));
    }


	public String longestCommonPrefix(String[] strs) 
	{
        if (strs == null || strs.length == 0) 
            return "";

        // Find the minimum string length
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) 
            minLen = Math.min(minLen, s.length());

        int low = 0, high = minLen;
        while (low < high) 
		{
            int mid = (low + high + 1) / 2; // upper mid to avoid infinite loop
            if (isCommonPrefix(strs, mid))
                low = mid; // can try longer prefix
            else
                high = mid - 1; // must try shorter prefix
        }
        return strs[0].substring(0, low);
    }



	// Check if all strings have the given prefix length
    private boolean isCommonPrefix(String[] strs, int len) 
	{
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(prefix))
                return false;

        return true;
    }
}
