import java.util.Scanner;
public class Mergesort_recursive1
{
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int list[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		
		mergeSort(list, 0, n - 1);
		
		for(int i = 0; i < n; i++) {
			System.out.print(list[i]);
			if(i < n - 1) System.out.print(" ");
		}
	}
	
	public static void mergeSort(int list[], int low, int high)
	{
		if(low >= high) return;
		
		int mid = (low + high) / 2;
		mergeSort(list, low, mid);
		mergeSort(list, mid + 1, high);
		merge(list, low, mid, high);
	}
	
	private static void merge(int list[], int low, int middle, int high)
	{
		int[] temp = new int[high - low + 1];
		int i = low;
		int j = middle + 1;
		int idx = 0;
		
		while(i <= middle && j <= high) {
			if(list[i] <= list[j]) {
				temp[idx++] = list[i++];
			} else {
				temp[idx++] = list[j++];
			}
		}
		
		while(i <= middle) {
			temp[idx++] = list[i++];
		}
		
		while(j <= high) {
			temp[idx++] = list[j++];
		}
		
		for(int k = 0; k < temp.length; k++) {
			list[low + k] = temp[k];
		}
	}
}