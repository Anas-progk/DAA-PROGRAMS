/*Your english teacher has given you a task, which is counting the number of 
occurances of each word in given paragraph. write a java program to do this task. 
You need to print the words and 
it's number of occurances in descending order.

input format = space seperated string
output format = String: Intger

Sample input 1=
hello how are you hello kmit hello you
output=hello: 3
you: 2
how: 1
are: 1
kmit: 1

Sample input2 =a b c a b c a b c
output=a: 3
b: 3
c: 3

Java Concepts:
HashMap (from Collections)
ArrayList
Collections.sort
String
CompareTo
*/ 
import java.util.*;
public class wordFreqCounter
{
    static HashMap<String,Integer> freq(String s)
    {
        StringTokenizer st=new StringTokenizer(s);
        HashMap<String,Integer>hm=new HashMap<>();
        while(st.hasMoreTokens())
        {
            String token=st.nextToken();
            hm.put(token,hm.getOrDefault(token, 0)+1);
        }
        return hm;
    }
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        sc.close();
        HashMap<String,Integer>map=freq(s);
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>()
        {
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b)
            {
                int cmp = b.getValue().compareTo(a.getValue());
                if (cmp != 0) return cmp;
                return a.getKey().compareTo(b.getKey());
            }
        });
        for (Map.Entry<String,Integer> entry : list)
            System.out.println(entry.getKey()+": "+entry.getValue());
    }
}
    

