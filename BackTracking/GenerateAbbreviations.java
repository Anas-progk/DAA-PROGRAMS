/*Now a days, everyone is used to type the words in short-forms,
A short-form can be created by replacing non-intersected substrings 
and non-adjacent substrings with their respective lengths.

e.g., elite can be written as follows:
    - e3e (by replacing lit with 3), 
    - el2e (by replacing it with 2), 
	- 1l1t1 (by replacing e,i,e, with 1,1,1)
    - 3t1 (by replacing eli and e with 3 and 1), etc.
	and can't be written as follows:
	- 22e (by replacing el and it with 2 and 2)
	- 32 (by replacing eli and te with  3 and 2)

You will be given a word.
Your task is to find all possible short-forms of the given word, 
and print them as a list of lexicographic order.


Input Format:
-------------
A string W, the word.

Output Format:
--------------
Print the list of possible short-forms of W in lexographic order. 


Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[1s1, 1se, 2e, 3, c1e, c2, cs1, cse]

*/

/*
The backtracking algorithm enumerates a set of partial candidates that, in principle, 
could be completed in several choices to give all the possible solutions to the problem. 
The completion is done incrementally, by extending the candidate in many steps. 
Abstractly, the partial candidates can be seen as nodes of a tree, the potential search tree. 
Each partial candidate is the parent of the candidates that derives from it by an extension step; 
the leaves of the tree are the partial candidates that cannot be extended any further.

In our problem, the partial candidates are incomplete abbreviations that can be extended by one of the two choices:

keep the next character;
abbreviate the next character.

We extend the potential candidate in a depth-first manner. 
We backtrack when we reach a leaf node in the search tree. 
All the leaves in the search tree are valid abbreviations and shall be put into a 
shared list which will be returned at the end.

Time complexity : O(n*2 power n) 
Space complexity : O(n)
*/

import java.util.*;

class GenerateAbbreviations {
	public List<String> makeShortcutWords(String word)
	{
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        Collections.sort(ans);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k)
	{
    if (i == word.length()) {

    int len = builder.length();

    if (k > 0) {
        builder.append(k);
    }

    ans.add(builder.toString());

    builder.setLength(len);  // Restore builder

    return;
}  
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(new GenerateAbbreviations().makeShortcutWords(s));
	}
}