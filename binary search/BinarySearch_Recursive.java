import java.util.*;
class BinarySearch_Recursive
{
    public static void main(String args[]) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int x=sc.nextInt();
        System.out.println(binarySearch(a,x,0,n-1));
        sc.close();
    }
    static int binarySearch(int a[], int x, int low, int high) 
    {
        if(low>high) return -1;
        int mid=low+(high-low)/2;
        if(a[mid]==x) return mid;
        if(a[mid]>x) return binarySearch(a,x,low,mid-1);
        else return binarySearch(a,x,low,mid-1);
    }
}