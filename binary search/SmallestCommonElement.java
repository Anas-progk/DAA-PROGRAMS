import java.util.*;
class SmallestCommonElement
{
    private boolean binarySearch(int[] arr, int low, int high, int target) 
    {
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
    
    public int smallestCommonElement(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        // Try every element of row 0 (smallest to largest, since row is sorted)
        for (int j = 0; j < n; j++) 
        {
            int candidate = mat[0][j];
            boolean foundInAll = true;

            // Check this candidate against every other row
            for (int i = 1; i < m; i++) 
            {
                if (!binarySearch(mat[i], 0, n - 1, candidate)) 
                {
                    foundInAll = false;
                    break;
                }
            }

            if (foundInAll)
                return candidate; // first match = smallest, since row0 is sorted
        }
        return -1;
    }

    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n]; 
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        
        System.out.println(new SmallestCommonElement().smallestCommonElement(arr)); 
    } 
}
