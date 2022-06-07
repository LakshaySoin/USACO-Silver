import java.util.*;
import java.io.*;

public class Convention {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("convention.in"));
        PrintWriter pw = new PrintWriter(new File("convention.out"));

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();

        int[] arrivals = new int[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            arrivals[i] = a;
        }

        Arrays.sort(arrivals);

        int ans = Integer.MAX_VALUE;

        int lo = 0;
        int hi = 1000000000;

        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            int bus = 0;
            int x = 0;
            int start = 0;
            while (x < n - 1) {
                if (arrivals[x + 1] - arrivals[start] <= mid && ((x + 1) - start) < c) {
                    x++;
                } else {
                    bus++;
                    start = x + 1;
                }
            }
            bus++;
            if (bus > m) {
                lo = mid + 1;
            } else if (bus <= m) {
                hi = mid;
                ans = Math.min(ans, mid);
            }
        }

        pw.println(ans);
        pw.close();
    }
}