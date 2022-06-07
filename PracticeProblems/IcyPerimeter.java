import java.io.*;
import java.util.*;

public class IcyPerimeter {
    static int n, area, perimeter, a, p;
    static char[][] grid;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("perimeter.in"));
        PrintWriter pw = new PrintWriter(new File("perimeter.out"));
        // Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        grid = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String temp = scanner.next();
            for (int x = 0; x < n; x++) {
                grid[i][x] = temp.charAt(x);
            }
        }
        area = 0;
        perimeter = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && grid[r][c] != '.') {
                    a = 0;
                    p = 0;
                    floodfill(r, c);
                    if (a > area) {
                        area = a;
                        perimeter = p;
                    } else if (a == area) {
                        perimeter = Math.min(perimeter, p);
                    }
                }
            }
        }
        System.out.println(area + " " + perimeter);
        pw.println(area + " " + perimeter);
        pw.close();
    }
    
    public static void floodfill(int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || grid[r][c] == '.') {
            return;
        }
        a++;
        visited[r][c] = true;
        if (c == 0) p++;
        if (c == n - 1) p++;
        if (r == 0) p++;
        if (r == n - 1) p++;
        if (c - 1 > -1) {
            if (grid[r][c - 1] == '.') {
                p++;
            }
        }
        if (c + 1 < n) {
            if (grid[r][c + 1] == '.') {
                p++;
            }
        }
        if (r - 1 > -1) {
            if (grid[r - 1][c] == '.') {
                p++;
            }
        }
        if (r + 1 < n) {
            if (grid[r + 1][c] == '.') {
                p++;
            }
        }
        floodfill(r, c - 1);
        floodfill(r, c + 1);
        floodfill(r - 1, c);
        floodfill(r + 1, c);
    }
}
