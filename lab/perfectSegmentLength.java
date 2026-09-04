import java.util.*;

class PerfectSegmentLength 
{
    public static int GCD(int a,int b)
    {
        if(a==b) return a;
        if(b==0) return a;
        if(a==0) return b;
        return a>b?GCD(a%b,b):GCD(a,b%a);
    }
    public static int PerfectSegmentLength(int[] nums) 
    {
        int res=nums[0];
         for(int i=0;i<=nums.length-1;i++)
         {
             res=GCD(res,nums[i]);
         }
         return res;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        String arr[] = sc.nextLine().split(" ");
        int nums[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            nums[i] = Integer.parseInt(arr[i]);

        System.out.println(PerfectSegmentLength(nums));
    }
}
