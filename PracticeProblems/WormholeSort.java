import java.util.*;
import java.io.*;

public class WormholeSort {
    static int n, m;
    static int[] cows;
    static boolean[] visited;
    static ArrayList<ArrayList<Pair>> wormholes = new ArrayList<ArrayList<Pair>>();
    static class Pair {
        int loc, width;
        public Pair(int loc, int width) {
            this.loc = loc;
            this.width = width;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("wormsort.in"));
        PrintWriter pw = new PrintWriter(new File("wormsort.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        visited = new boolean[n];
        cows = new int[n];
        for (int i = 0; i < n; i++) {
            wormholes.add(new ArrayList<>());
            int a = scanner.nextInt() - 1;
            cows[i] = a;
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            wormholes.get(a).add(new Pair(b, w));
            wormholes.get(b).add(new Pair(a, w));
        }
        int lo = 0;
        int hi = 1000000000;
        while (lo < hi) {
            int w = lo + ((hi - lo) / 2);
            Arrays.fill(visited, false);
            if (check(w)) {
                lo = w;
            } else {
                hi = w - 1;
            }
        }
        if (lo == 1000000000) {
            System.out.println(-1);
            pw.println(-1);
        } else {
            System.out.println(lo);
            pw.println(lo);
        }
        pw.close();
    }

    public static void dfs(int node, int w) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (Pair i : wormholes.get(node)) {
            if (i.width >= w) {
                dfs(i.loc, w);
            }
        }
    }

    public static boolean check(int w) {
        dfs(0, w);
        for (int i = 0; i < n; i++) {
            if ((visited[i] == false || visited[cows[i]] == false) && i != cows[i]) {
                return false;
            }
        }
        return true;
    }
}
