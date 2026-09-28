import java.util.*;
public class lc1710_maximumUnitsOnATruck {
    static int maximumUnits(int[][] boxTypes, int truckSize)
    {
        Arrays.sort(boxTypes,(x,y)->y[1]-x[1]);
        int weight=0;
        for(int i=0;i<boxTypes.length;i++)
        {
            if(boxTypes[i][0]<=truckSize)
            {
                weight+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else
            {
                weight+=truckSize*boxTypes[i][1];
                break;
            }
        }
        return weight;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [][]boxTypes=new int[n][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++) boxTypes[i][j]=sc.nextInt();
        }
        int truckSize=sc.nextInt();
        System.out.println(maximumUnits(boxTypes,truckSize));
        sc.close();
    }
}
