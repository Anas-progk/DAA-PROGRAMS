import java.util.*;
public class LongestcommonPrefixBS_1 {
    static String LCP(String [] strs)
    {
        if(strs.length==0 || strs==null) return "";
        int minLen=Integer.MAX_VALUE;
        for(String c:strs) 
        {
            if(minLen>c.length()) minLen=c.length();
        }
        if(minLen==1) return strs[0].substring(0, minLen);
        int l=0,h=minLen,k=0;
        while(l<h)
        {
            int m=(l+h+1)/2;
            if(isCP(strs,m)) {l=m;k=m;}
            else h=m-1;
        }
        return strs[0].substring(0,k);
    }
    static boolean isCP(String []strs,int m)
    {
        String s=strs[0].substring((0), m);
        boolean valid=false;
        for(int i=1;i<strs.length;i++)
        {
            if(strs[i].startsWith(s))  valid=true;
            else valid=false;
        }
        return valid;
    }
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        String[] strs=sc.nextLine().split(" ");
        System.out.println(LCP(strs));
        sc.close();
    }
}
