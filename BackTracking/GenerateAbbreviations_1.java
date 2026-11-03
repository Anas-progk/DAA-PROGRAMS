import java.util.*;

public class GenerateAbbreviations_1 {
    static List<String> makeShortcutWords(String word)
    {
        List<String> ans=new ArrayList<String>();
        backtrack(ans,new StringBuilder(),word,0,0);
        Collections.sort(ans);
        return ans;
    }
    static void backtrack(List<String>ans,StringBuilder builder,String word,int i,int k)
    {
        if(i==word.length())
        {
            int len=builder.length();
            if(k>0) builder.append(k);
            ans.add(builder.toString());
            builder.setLength(len);
            return;
        }
        backtrack(ans, builder, word, i + 1, k + 1);
        int len = builder.length();
        if(k>0) builder.append(k);
        builder.append(word.charAt(i));
        backtrack(ans, builder, word, i + 1, 0);
        builder.setLength(len);
    } 
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
		String s=sc.next();
        makeShortcutWords(s);
        sc.close();
    }
}
