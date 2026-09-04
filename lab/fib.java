import java.util.*;
public class fib {
    static int fib(int n) {
        return fibHelper(n, 0, 1);
    }

    static int fibHelper(int n, int a, int b) {
        if (n == 0) return a;
        return fibHelper(n - 1, b, a + b);  // tail call - last action, nothing after it
    }
}
