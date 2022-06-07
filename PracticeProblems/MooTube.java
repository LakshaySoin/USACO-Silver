import java.util.*;
import java.io.*;

public class MooTube {
    static boolean[] visited;
    static ArrayList<ArrayList<Pair>> relevance = new ArrayList<ArrayList<Pair>>();
    static class Pair {
        int v, r;
        public Pair(int v, int r) {
            this.v = v;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("mootube.in"));
        PrintWriter pw = new PrintWriter(new File("mootube.out"));
        // Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            relevance.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            relevance.get(a).add(new Pair(b, c));
            relevance.get(b).add(new Pair(a, c));
        }
        for (int i = 0; i < q; i++) {
            Arrays.fill(visited, false);
            int k = scanner.nextInt();
            int v = scanner.nextInt() - 1;
            int cnt = dfs(k, v, Integer.MAX_VALUE);
            System.out.println(cnt);
            pw.println(cnt);
        }
        pw.close();
    }
    public static int dfs(int k, int v, int m) {
        visited[v] = true;
        int ans = 0;
        for (Pair i : relevance.get(v)) {
            if (!visited[i.v]) {
                int min = Math.min(m, i.r);
                if (min >= k) {
                    ans++;
                }
                ans += dfs(k ,i.v, min);
            }
        }
        return ans;
    }
}

// 1 2 3
// 1 3 2
// 1 4 3 
// 2 1 3
// 2 3 2
// 2 4 4
// 3 1 2
// 3 2 2
// 3 4 2
// 4 1 3
// 4 2 4
// 4 3 2