/*Implement a Comparator to sort strings in descending order using compareTo.

Input format: space-separated strings
Output format: sorted strings

Sample Input 1:
banana apple cherry date
Output:
date cherry banana apple

Sample Input 2:
hello world java
Output:
world java hello
*/
import java.util.*;
public class customSort
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String[] words = s.split(" ");
        Arrays.sort(words, new Comparator<String>()
        {
            public int compare(String a, String b)
            {
                return b.compareTo(a);
            }
        });
        for (String w : words)
            System.out.print(w + " ");
    }
}
