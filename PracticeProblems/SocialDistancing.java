import java.io.*;
import java.util.*;

public class SocialDistancing {
    static Pair[] intervals;
    static int n, m;
    static class Pair implements Comparable<Pair> {
        long a, b;
        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Pair p) {
            return Long.compare(a, p.a);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("socdist.in"));
        PrintWriter pw = new PrintWriter(new File("socdist.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        intervals = new Pair[m];
        for (int i = 0; i < m; i++) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            intervals[i] = new Pair(a, b);
        }
        Arrays.sort(intervals);
        long lo = 0;
        long hi = (long) 10e18;
        while (lo < hi) {
            long d = lo + ((hi - lo) / 2) + 1;
            if (check(d)) {
                lo = d;
            } else {
                hi = d - 1;
            }
            // System.out.println(d);
        }
        System.out.println(lo);
        pw.println(lo);
        pw.close();
    }

    public static boolean check(long d) {
        long start = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < m; i++) {
            while (Math.max(start + d, intervals[i].a) <= intervals[i].b) {
                start = Math.max(start + d, intervals[i].a);
                num++;
                if (num == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
