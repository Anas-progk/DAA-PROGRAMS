import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
public class Strobogrammatic_Number 
{
    //Do the required declarations here
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<String> res = buildStroboNumbers(N,N);
		Collections.sort(res);
		System.out.println(res);
    }

    public static List<String> buildStroboNumbers(int n,int m)
	{
        ArrayList<String>l1=new ArrayList<>(Arrays.asList("0","1","8"));
        ArrayList<String>l2=new ArrayList<>(Arrays.asList("00","11","69","88","96"));
        if(n==0) return new ArrayList<>(Arrays.asList(""));
        if(n==1) return new ArrayList<>(Arrays.asList("0","1","8"));
            List<String>inner=buildStroboNumbers(n-2,m);
            ArrayList<String>res=new ArrayList<>();
            Arrays.toString(inner.toArray());
              for(int i=0;i<inner.size();i++)
            {
                String mid=inner.get(i);
                if(n != m) res.add("0"+mid+"0");
                res.add("1"+mid+"1");
                res.add("6"+mid+"9");
                res.add("8"+mid+"8");
                res.add("9"+mid+"6");
            } 
    return res;
    }
}
