import java.util.*;
import java.io.*;

public class countingHaybales {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("haybales.in"));
        PrintWriter pw = new PrintWriter(new File("haybales.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        nums = new int[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            nums[i] = a;
        }

        Arrays.sort(nums);

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            // System.out.println(solve(b) - solve(a - 1));
            pw.println(solve(b) - solve(a - 1));
        }
        pw.close();
    }

    public static int solve(int search) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            if (nums[mid] == search) {
                return mid + 1;
            } else if (nums[mid] <= search) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

// 2 3 5 7