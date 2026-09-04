/*Your brother is solving a puzzle, which is on strings. The puzzle is that 
we need to read the given sentence in reverse order.

As you are preparing for a programming contest, you want to develop a 
java program for solving this puzzle. While giving output should not 
include any extra spaces.

Input Format : string 
output fromat : string 

Example 1:
Input=the sky is blue
Output=blue is sky the

Example 2:
Input="  hello world  " 
Output=world hello
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input=a good   example
Output=example good a
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.

Java Concepts:
String.trim()
String.split()
StringBuilder
*/

import java.util.*;
class reverseWords 
{
    public static String ReverseWords(String s) 
	{
       if(s.isEmpty()) return "";
       s=s.trim();
       int spIdx=s.indexOf(' ');
       if(spIdx==-1) return s;
       String firstWord=s.substring(0,spIdx);
       String rest=s.substring(spIdx+1);
       return ReverseWords(rest)+" "+firstWord; 
    }
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(ReverseWords(input));
    }
}
