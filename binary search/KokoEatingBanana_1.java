public class KokoEatingBanana_1 {
    static int kokospeed(int[] piles,int hours)
    {
        int l=0,h=Integer.MIN_VALUE;
        for (int c:piles) {if(h<c) h=c;}
        while(l<h)
        {
            int m=(l+h)/2;
            if(canEat(piles,hours,m)) h=m;
            else l=m+1;
        }
        return l;
    }
    static boolean canEat(int[] piles,int hours,int m)
    {
        int x=0;
        for(int c:piles) x+=(c+m-1)/m;
        return x<=hours;
    }
    public static void main(String[] args) throws Exception{
        int piles[]={30,11,23,4,20};
        System.out.println(kokospeed(piles, 5));
    }
}
