import java.util.*;
import java.io.*;

public class cowDanceShow {
    static int[] cows;
    static int n, t;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("cowdance.in"));
        PrintWriter pw = new PrintWriter(new File("cowdance.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        t = scanner.nextInt();
        cows = new int[n];
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            cows[i] = c;
        }
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int k = lo + ((hi - lo) / 2);
            if (check(k)) {
                hi = k;
            } else {
                lo = k + 1;
            }
        }
        System.out.println(hi);
        pw.println(hi);
        pw.close();
    }
    public static boolean check(int k) {
        PriorityQueue<Integer> dances = new PriorityQueue<Integer>();
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (dances.size() == k) {
                curr = dances.poll();
            }
            if (cows[i] + curr > t) {
                return false;
            }
            dances.add(curr + cows[i]);
        }
        return true;
    }
}