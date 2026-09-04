/*
Problem Name: Pivot Position After Partition

Problem Statement:
A data analytics system stores a sequence of integer measurements collected 
from multiple sensors. To organize the data efficiently, the system performs a 
partition operation using a selected pivot value from the given sequence.

You are given a list of space-separated integers. Rearrange the list such that:
- All values smaller than the pivot appear before it.
- All values greater than the pivot appear after it.
- The relative order of the other elements is not important.

After completing the partition, determine and print the final index (0-based) 
of the pivot element.
Note: Assume first element as pivot

Input Format:
First line: Space-separated integers.

Output Format:
Print a single integer representing the final (0-based) index of the pivot 
after partitioning.

Constraints:
- The pivot value is guaranteed to exist exactly once in the given list.
- Number of elements >= 2.

Test Case1
Input:
5 9 3 7 1 8 2
Output:
3

Test Case2
Input:
45 12 67 23 89 34 56 78 10 91
Output:
4
*/
import java.util.*;
public class partition
{
    static int pivot(int nums[])
    {
        int pivotnum=nums[0];
        int i=1,j=nums.length-1;
        while(i<=j)
        {
            System.out.println(Arrays.toString(nums)+" beginning of while loop i= "+i+" j= "+j);
            if(nums[i]<pivotnum) {i++;System.out.println(Arrays.toString(nums)+" from if i= "+i+" j= "+j);}
            
            else if(nums[j]>pivotnum) {j--;System.out.println(Arrays.toString(nums)+" from else if i= "+i+" j= "+j);}
            else
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;j--;
                System.out.println(Arrays.toString(nums)+" from else i= "+i+" j= "+j);
            }
        }
        System.out.println(Arrays.toString(nums)+" after while loop i= "+i+" j= "+j);
        nums[0]=nums[j];
        nums[j]=pivotnum;
        System.out.println(Arrays.toString(nums)+" before return j i= "+i+" j= "+j);
        return j;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        sc.close();
        String[] parts=line.trim().split("\\s+");
        int n=parts.length;
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=Integer.parseInt(parts[i]);
        System.out.println(pivot(nums));
    }
}