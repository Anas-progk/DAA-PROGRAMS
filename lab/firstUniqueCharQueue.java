/*Given a string s, find the first non-repeating character in it and 
return its index. If it does not exist, return -1.


Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur 
at any other index.

Example 2:
Input: s = "aabb"
Output: -1

Example 2:
input=advanced
output=2

Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.*/
import java.util.*;
class firstUniqueCharQueue
{
    public static int firstUniqChar(String s) 
	{
        HashMap<Character,Integer>hm=new HashMap<>();
        for(char c:s.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(hm.get(ch)==1) return i;
        }
        return -1;
    }
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        sc.close();
		String st = sc.nextLine();
        System.out.println(firstUniqChar(st)); 
    }
}
