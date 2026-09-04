import java.util.*;
class LongestCommonPrefixBS 
{    
    // Check if all strings have the given prefix length
    private boolean isCommonPrefix(String[] strs, int len) 
    {
        // take the first 'len' characters of the very first string
        String prefix = strs[0].substring(0, len);
        
        // check every other string starts with this same prefix
        for (String s : strs) {
            if (!s.startsWith(prefix)) {
                return false; // mismatch found
            }
        }
        return true; // all strings matched
    }
    
    public String longestCommonPrefix(String[] strs) 
    {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Step 1: find the length of the shortest string
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        
        // Step 2: binary search on prefix length
        int low = 0, high = minLen;
        int ans = 0; // stores the best length found so far
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid == 0) {
                // length 0 is always a valid (empty) prefix, just move on
                low = mid + 1;
                continue;
            }
            
            if (isCommonPrefix(strs, mid)) {
                // this length works, save it, try for longer
                ans = mid;
                low = mid + 1;
            } else {
                // too long, try shorter
                high = mid - 1;
            }
        }
        
        return strs[0].substring(0, ans);
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        
        LongestCommonPrefixBS lcp = new LongestCommonPrefixBS();
        System.out.println(lcp.longestCommonPrefix(words));
    }
}