import java.util.*;
import java.io.*;

public class LoanRepayment {
    static long n, k, m;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("loan.in"));
        PrintWriter pw = new PrintWriter(new File("loan.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        k = scanner.nextLong();
        m = scanner.nextLong();
        long lo = 0;
        long hi = (long) 10e12;
        while (lo < hi) {
            long x = lo + ((hi - lo + 1) / 2);
            if (check(x)) {
                lo = x;
            } else {
                hi = x - 1;
            }
        }
        System.out.println(lo);
        pw.println(lo);
        pw.close();
    }

    public static boolean check(long x) {
        long g = 0;
        long t = 0;
        while (t < k) {
            long y = (n - g) / x;
            if (y <= m) {
                g += (k - t) * m;
                t = k;
            } else {
                long cnt = (n - g) % x;
                long days = cnt / y;
                t += days;
                g += days * y;
                g += y;
                t += 1;
            }
        }
        return g >= n;
    }
}
