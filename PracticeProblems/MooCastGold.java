import java.util.*;
import java.io.*;

public class MooCastGold {
    static int[][] cows;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("moocast.in"));
        PrintWriter pw = new PrintWriter(new File("moocast.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        cows = new int[n][2];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            cows[i][0] = x;
            cows[i][1] = y;
        }
        int lo = 0;
        int hi = 1000000000;
        int ans = Integer.MAX_VALUE;
        while (lo < hi) {
            Arrays.fill(visited, false);
            int x = lo + ((hi - lo) / 2);
            dfs(0, x);
            if (check()) {
                ans = Math.min(ans, x);
                hi = x;
            } else {
                lo = x + 1;
            }
        }
        // System.out.println(ans);
        pw.println(ans);
        pw.close();
    }

    public static void dfs(int node, int x) {
        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (Math.sqrt(Math.pow(cows[node][0] - cows[i][0], 2) + Math.pow(cows[node][1] - cows[i][1], 2)) <= Math.sqrt(x) && !visited[i]) {
                dfs(i, x);
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}
