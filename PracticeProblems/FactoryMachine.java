import java.util.*;

public class FactoryMachine {
    static long[] machines;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        machines = new long[n];

        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            machines[i] = a;
        }

        long lo = 0;
        long hi = Long.MAX_VALUE;

        long ans = Long.MAX_VALUE;

        while (lo < hi) {
            long mid = lo + ((hi - lo) / 2);
            if (solve(mid, t)) {
                ans = Math.min(ans, mid);
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        System.out.println(ans);
    }

    public static boolean solve(long time, int t) {
        long num = 0;
        for (int i = 0; i < machines.length; i++) {
            num += (time / machines[i]);
            if (num >= t) {
                return true;
            }
        }
        return false;
    }
}
