import java.util.*;
public class reverseWords2 
{
    static String reverseWords(String s)
    {
        StringBuilder sb=new StringBuilder();
        String[] words=s.trim().split("\\s+");
        for(int i=words.length-1;i>=0;i--)
        {
            sb.append(words[i]);
            if(i>0) sb.append(' ');
        }
        return sb.toString();
    }
    public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        System.out.println(reverseWords(input));
    }
}
