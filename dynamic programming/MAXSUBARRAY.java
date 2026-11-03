/*
You are playing a game. There are N boxes placed in a row (0-indexed),
every box has some points. You need to play the game with the following rules:
 - Initially your score is '0' points.
 - Suppose the box has P points in it.
   if p>0 you will gain P points, if p<0 you will lose P points.
 - You are allowed to choose any number of consecutive boxes, at least 1 box.

You are given the points in the N boxes as points[].
Your target is to maximize your score, and return the highest score possible.
*/
import java.util.Scanner;

public class MAXSUBARRAY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = scanner.nextInt();
        }

        int currentSum = points[0];
        int maxSum = points[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(points[i], currentSum + points[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        scanner.close();
    }
}
