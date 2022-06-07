import java.util.*;
import java.io.*;

public class FencePlanning {
    static ArrayList<ArrayList<Integer>> networks = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited, used;
    static Coor[] coors;
    static int minx, maxx, miny, maxy;

    static class Coor {
        int x, y;
        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("fenceplan.in"));
        PrintWriter pw = new PrintWriter(new File("fenceplan.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        visited = new boolean[n];
        coors = new Coor[n];
        used = new boolean[n];

        for (int i = 0; i < n; i++) {
            networks.add(new ArrayList<Integer>());
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            coors[i] = new Coor(x, y);
        }
        
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            networks.get(a).add(b);
            networks.get(b).add(a);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                Arrays.fill(visited, false);
                minx = Integer.MAX_VALUE;
                maxx = Integer.MIN_VALUE;
                miny = Integer.MAX_VALUE;
                maxy = Integer.MIN_VALUE;
                dfs(i);
                int temp = 2 * ((maxx - minx) + (maxy - miny));
                ans = Math.min(ans, temp);
            }
        }

        pw.println(ans);
        pw.close();
    }

    public static void dfs(int node) {
        visited[node] = true;
        used[node] = true;
        minx = Math.min(minx, coors[node].x);
        maxx = Math.max(maxx, coors[node].x);
        miny = Math.min(miny, coors[node].y);
        maxy = Math.max(maxy, coors[node].y);
        for (int i : networks.get(node)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }
}