import java.util.*;
public class PeakElementsList 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        ArrayList<Integer> peakElements = findPeaks(nums);
		Collections.sort(peakElements);
        System.out.println(peakElements);
    }

	public static ArrayList<Integer> findPeaks(int[] nums) 
	{
        ArrayList<Integer> peaks = new ArrayList<>();
        findPeakElements(nums, 0, nums.length - 1, peaks);
        return peaks;
    }
    private static void findPeakElements(int[] nums, int low, int high, ArrayList<Integer> peaks) 
	{
		if(low>high) return;
		int mid=low+(high-low)/2;
		boolean isPeak=true;
		if(mid>0 && nums[mid]<=nums[mid-1]) isPeak=false;
		if(mid<nums.length-1 && nums[mid] <=nums[mid+1]) isPeak=false;
		if(isPeak) peaks.add(nums[mid]);
		findPeakElements(nums,low,mid-1,peaks);
		findPeakElements(nums,mid+1,high,peaks);
    }
}
