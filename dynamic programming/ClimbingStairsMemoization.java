/*
Ram is playing a game where there are N levels.
In order to win the game he has to reach Nth level.

In one step he can either cross one level or two levels.
Return the number of distinct possible ways to win the game.
*/
import java.util.Scanner;

public class ClimbingStairsMemoization {
    static int climb(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        System.out.println(climb(n, dp));
        scanner.close();
    }
}
