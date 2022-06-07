import java.util.*;
import java.io.*;

public class MooBuzz {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("moobuzz.in"));
        PrintWriter pw = new PrintWriter(new File("moobuzz.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int lo = 1;
        int hi = (int) 10e9;
        int ans = 0;

        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            int moos = (mid / 3) + (mid / 5) - (mid / 15);
            if (mid - moos == n) {
                ans = mid;
                break;
            } else if (mid - moos < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        while (ans % 3 == 0 || ans % 5 == 0) {
            ans--;
        }

        // System.out.println(ans);

        pw.println(ans);
        pw.close();
    }
}
