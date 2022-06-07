import java.util.*;

public class KGoodnessString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String str = scanner.next();
            int start = 0;
            int end = t - 1;
            int cnt = 0;
            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    cnt++;
                }
            }
            int ans = k - cnt;
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}