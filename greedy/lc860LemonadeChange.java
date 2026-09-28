
import java.util.*;
public class lc860LemonadeChange{
    static boolean lemonadeChange(int[] bills)
    {
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5) five++;
            else if(bills[i]==10)
            {
                five--;ten++;
                if(five<0) return false;
            }
            else if(bills[i]==20)
            {
                if(ten>=1 && five>=1) {ten--;five--;}
                else if(five>=3 && ten==0) five-=3;
                else return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String ints[]=sc.nextLine().split(" ");
        int bills[]=new int[ints.length];
        for(int i=0;i<ints.length;i++) bills[i]=Integer.parseInt(ints[i]);
        System.out.println(lemonadeChange(bills));
        sc.close();
    }
}