import java.util.Arrays;
import java.util.Scanner;
public class lc455AssignCookies {
    static int findContentChildren(int[] g, int[] s)
    {
        int i=0,j=0,count=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length)
        {
            if(s[j]>=g[i])
            {
                i++;j++;count++;
            }
            else j++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String []gStr=sc.nextLine().split(" ");
        String []sStr=sc.nextLine().split(" ");
        int []g=new int[gStr.length];
        int []s=new int[sStr.length];
        for(int i=0;i<g.length;i++) g[i]=Integer.parseInt(gStr[i]);
        for(int i=0;i<s.length;i++) s[i]=Integer.parseInt(sStr[i]);
        System.out.println(findContentChildren(g,s));
        sc.close();
    }  
}
