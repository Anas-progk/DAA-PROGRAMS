/*In the village library of Amarpur, books are often returned in batches and 
arranged on a long shelf. The librarian, Ravi, is very methodical: 
when he receives books, he first organizes each batch in sorted order by serial number.
However, due to time constraints, he places the first sorted batch, 
then immediately appends the second sorted batch - without merging the two.

Now, he asks for your help to rearrange the entire shelf so that all books 
are in proper serial order from start to end.

You are given:
The total number of books on the shelf,
The last index of the first sorted batch (i.e., the index where the first sorted part ends),
The full list of serial numbers of books as they appear on the shelf.
Your task is to merge the two sorted parts into a single fully sorted list - 
so Ravi can label the shelf properly.

Sample Test Case:
input=10
4
10 20 30 40 50 8 15 19 25 46
output=8 10 15 19 20 25 30 40 46 50

Explanation: 
First sorted part: 10 20 30 40 50
Second sorted part: 8 15 19 25 46
After merging the two sorted parts correctly, the complete sorted list becomes:
8 10 15 19 20 25 30 40 46 50
*/

import java.util.*;
public class Merge_Books 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] books = new int[n];
        for (int i = 0; i < n; i++) 
            books[i] = sc.nextInt();
        
        merge(books, 0, k, n - 1);

        for (int num : books) 
            System.out.print(num + " ");
    }

    private static void merge(int list[], int low, int middle, int high) 
	{
	    int i=low,j=middle;
	    int[] res=new int[high+1];
	    System.out.println("i "+i+"j "+j+"list[i] "+list[i]+"list[j]"+list[j]);
        while(i<=j)
        {
            if(list[i]<list[j]) 
            {
                res[i]=list[i];i++;
	    System.out.println("i "+i+"j "+j+"list[i] "+list[i]+"list[j]"+list[j]);
            }
            else
            {
                res[j]=list[j];j++;
	    System.out.println("i "+i+"j "+j+"list[i] "+list[i]+"list[j]"+list[j]);
            }
        }
        while(i<middle)
        {
            res[i]=list[i];i++;
	    System.out.println("i "+i+"j "+j+"list[i] "+list[i]+"list[j]"+list[j]);
        }
        while(j<=high )
        {
            res[j]=list[j];j++;
	    System.out.println("i "+i+"j "+j+"list[i] "+list[i]+"list[j]"+list[j]);
        }
    }
}