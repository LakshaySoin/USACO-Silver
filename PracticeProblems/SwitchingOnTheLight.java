import java.util.*;
import java.io.*;

public class SwitchingOnTheLight {
    static List<Pair>[][] switches;
    static boolean[][] lit, visited;
    static int n, m, ans;
    static int[] dirx = {0, 0, 1, -1};
    static int[] diry = {1, -1, 0, 0};
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lightson.in"));
        PrintWriter pw = new PrintWriter(new File("lightson.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        lit = new boolean[n][n];
        visited = new boolean[n][n];
        switches = new ArrayList[n][n];
        lit[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switches[i][j] = new ArrayList<Pair>();
            }
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            switches[x - 1][y - 1].add(new Pair(a - 1, b - 1));
        }
        ans = 1;
        floodfill(0, 0);
        System.out.println(ans);
        pw.println(ans);
        pw.close();
    }
    public static void floodfill(int r, int c) {
        if (r > n - 1 || r < 0 || c > n - 1 || c < 0 || !lit[r][c] || visited[r][c]) {
            return;
        }
        if (!connected(r, c) && !(r == 0 && c == 0)) {
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < switches[r][c].size(); i++) {
            int xcoor = switches[r][c].get(i).x;
            int ycoor = switches[r][c].get(i).y;
            if (!lit[xcoor][ycoor]) {
                ans++;
            }
            lit[xcoor][ycoor] = true;
            floodfill(xcoor, ycoor);
        }
        floodfill(r, c - 1);
        floodfill(r, c + 1);
        floodfill(r - 1, c);
        floodfill(r + 1, c);
    }
    public static boolean connected(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int tempx = x + dirx[i];
            int tempy = y + diry[i];
            if (tempx < 0 || tempx > n - 1 || tempy < 0 || tempy > n - 1) {
                continue;
            }
            if (visited[tempx][tempy]) {
                return true;
            }
        }
        return false;
    }
}
