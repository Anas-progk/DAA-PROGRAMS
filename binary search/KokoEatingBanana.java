/*Koko loves to eat bananas. 

There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. 
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not
eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109

Example:
input=enter array size
4
enter the elements of array 3 6 7 11
enter hours
8     
output=Eating hours:4
*/
import java.util.*;
public class KokoEatingBanana
{
    public static int minEatingSpeed(int[] piles, int H) 
    {
        int max=Integer.MIN_VALUE;
        for(int i:piles) 
        {
            if(i>max) max=i;
        }
        int l=1,h=max;
        while(l<h)
        {
            int m=(l+h)/2;
            if(ceil(m,piles,H)) h=m;
            else l=m+1;
        }
        return l;
    }
    static boolean ceil(int m,int[] piles,int H)
    {
        int x=0;
        for(int i=0;i<piles.length;i++)
        {
            x+=(piles[i]+m-1)/m;
        }
        return x<=H;
    }
   public static void main(String[] args) throws Exception
   {
    Scanner sc=new Scanner(System.in);
    int n = sc.nextInt(); 
    int arr[]=new int[n];
    for(int i=0;i<n;i++) arr[i] =sc.nextInt();

    int H = sc.nextInt();
    int ans= minEatingSpeed(arr,H);
    System.out.println(ans);
    sc.close();
  }
}