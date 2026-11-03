/*
Ram is playing a game where there are N levels.
In order to win the game he has to reach Nth level.

In one step he can either cross one level or two levels.
Return the number of distinct possible ways to win the game.
*/
import java.util.Scanner;

public class ClimbingStairsTabulation {
    static int climb(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(climb(n));
        scanner.close();
    }
}
