import java.util.*;
import java.io.*;

public class AngryCows {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("angry.in"));
        PrintWriter pw = new PrintWriter(new File("angry.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] haybales = new int[n];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            haybales[i] = x;
        }

        Arrays.sort(haybales);

        int lo = 0;
        int hi = 100000000;
        int ans = Integer.MAX_VALUE;

        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            int i = 0;
            for (int x = 0; x < k && i < n; x++) {
                int num = haybales[i];
                num += (mid * 2);
                while (i < n && haybales[i] <= num) {
                    i++;
                }
            }
            boolean good = true;
            if (i < n) {
                good = false;
            }
            if (good) {
                ans = Math.min(ans, mid);
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        // System.out.println(ans);

        pw.println(ans);
        pw.close();
    }
}
