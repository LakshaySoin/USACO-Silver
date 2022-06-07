import java.io.*;
import java.util.*;

public class PaintingTheBarn {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("paintbarn.in"));
        PrintWriter pw = new PrintWriter(new File("paintbarn.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] psum = new int[1001][1001];

        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            psum[x1][y1] += 1;
            psum[x2][y2] += 1;
            psum[x1][y2] -= 1;
            psum[x2][y1] -= 1;
        }

        int ans = 0;

        for (int i = 0; i < 1001; i++) {
            for (int x = 0; x < 1001; x++) {
                if (i > 0) {
                    psum[i][x] += psum[i - 1][x];
                }
                if (x > 0) {
                    psum[i][x] += psum[i][x - 1];
                }
                if (i > 0 && x > 0) {
                    psum[i][x] -= psum[i - 1][x - 1];
                }
                if (psum[i][x] == k) {
                    ans += 1;
                }
            }
        }
        
        // System.out.println(ans);

        pw.println(ans);
        pw.close();
    }
}