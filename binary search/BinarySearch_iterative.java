import java.util.*;
class BinarySearch_iterative 
{
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //String[] in=sc.nextLine().trim().split(" ");
        int a[]=new int [n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int x=sc.nextInt();
        System.out.println(binarySearch(a,x,0,n-1));
        sc.close();
    }
    static int binarySearch(int a[], int x, int low, int high) 
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]==x) return mid;
            if(a[mid]>x) high=mid-1;
            else if(a[mid]<x) low=mid+1;
        }
        return -1;
    }
}
