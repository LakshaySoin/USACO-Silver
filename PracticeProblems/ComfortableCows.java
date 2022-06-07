import java.util.*;

public class ComfortableCows {
    static boolean[][] grid;
    static int[] xchange = {0, 0, 1, -1};
    static int[] ychange = {1, -1, 0, 0};
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        grid = new boolean[1001][1001];
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for (int j = 0; j < 4; j++) {
                if (check(x + xchange[j], y + ychange[j])) {
                    ans--;
                }
            }
            grid[x][y] = true;
            for (int j = 0; j < 4; j++) {
                if (check(x + xchange[j], y + ychange[j])) {
                    ans++;
                }
            }
            if (check(x, y)) {
                ans++;
            }
            System.out.println(ans);
        }
    }
    public static boolean check(int x, int y) {
        int cnt = 0;
        if (y < 1001 && x + 1 > -1 && x + 1 < 1001 && y > -1) {
            if (grid[x + 1][y]) {
                cnt++;
            }
        }
        if (y + 1 < 1001 && x > -1 && x < 1001 && y + 1 > -1) {
            if (grid[x][y + 1]) {
                cnt++;
            }
        }
        if (y < 1001 && x - 1 > -1 && x - 1 < 1001 && y > -1) {
            if (grid[x - 1][y]) {
                cnt++;
            } 
        }
        if (y - 1 < 1001 && x > -1 && x < 1001 && y - 1 > -1) {
            if (grid[x][y - 1]) {
                cnt++;
            }
        }
        return cnt == 3;
    }
}
