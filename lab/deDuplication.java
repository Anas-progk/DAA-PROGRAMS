//  Your team is working on a lingual project,as part of this you are assigned a task, 
// read data from keyboard and remove if any duplicate characeters occurs and 
// return the new string without duplicates.

// input format = string
// output format = string

// example1:
// input=banana
// output=ban

// exaple2:
// input=radar
// output=rad 
import java.util.*;
public class deDuplication
{
    static String dup(String s)
    {
        LinkedHashSet<Character>h=new LinkedHashSet<>();
        for (char c:s.toCharArray()) h.add(c);
        String res="";
        for(char c:h) res+=c;
        return res;
    }
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        System.out.println(dup(s));
    }
}
