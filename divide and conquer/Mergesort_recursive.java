import java.util.*;
public class Mergesort_recursive {
    
    public static void mergeSort(int list[], int low, int high) {
        if(low >= high) return;  // ← BUG FIX #1: BASE CASE
        
        int mid = (low + high) / 2;
        mergeSort(list, low, mid);
        mergeSort(list, mid + 1, high);
        merge(list, low, mid, high);
    }
    
    private static void merge(int list[], int low, int middle, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = middle + 1, idx = 0;
        
        // Main comparison loop
        while(i <= middle && j <= high) {
            if(list[i] <= list[j]) {
                temp[idx++] = list[i++];
            } else {
                temp[idx++] = list[j++];
            }
        }
        
        // ← BUG FIX #2: Move these OUTSIDE the main while loop
        while(i <= middle) {
            temp[idx++] = list[i++];
        }
        while(j <= high) {
            temp[idx++] = list[j++];
        }
        
        // Copy back to original array
        for(int k = 0; k < temp.length; k++) {
            list[low + k] = temp[k];
        }
    }
    
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();  // You don't use 'k', remove it?
        int list[] = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        mergeSort(list, 0, n - 1);
        
        // Print sorted array to verify
        for(int x : list) System.out.print(x + " ");
    }
}