import java.util.*;

class KthSymbol {
    public static int kth_symbol(int n, int k) {
        // Base case: row 1 has only "0"
        if (n == 1) {
            return 0;
        }

        // size of the previous row
        int half = (int) Math.pow(2, n - 2);

        if (k <= half) {
            // k lies in first half → same as corresponding position in row (n-1)
            return kth_symbol(n - 1, k);
        } else {
            // k lies in second (flipped) half
            // find corresponding position in row (n-1), then flip the result
            int prevResult = kth_symbol(n - 1, k - half);
            return 1 - prevResult;   // flip 0->1 or 1->0
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(kth_symbol(n, k));
    }
}
