import java.util.*;
class happyNumber 
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    if(isHappy(num))
      System.out.println(num+" is a Happy Number");
    else
      System.out.println(num+" is Not a Happy Number");
  }
  private static boolean isHappy(int num)
  {
    if(num==1) return true;
    if(num==4) return false;
    return isHappy(sumOfDigits(num));
  }
  //Function to return sum of square of digits
  private static int sumOfDigits(int num)
  {
    int sum=0;
    while(num>0)
    {
        int n=num%10;
        sum=sum+n*n;
        num/=10;
    }
    return sum;
  }
}