import java.util.*;
import java.io.*;

public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new File("gymnastics.out"));
        // Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] cows = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int x = 0; x < n; x++) {
                int a = scanner.nextInt();
                cows[i][x] = a;
            }
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int x = 1; x < n + 1; x++) {
                if (i != x) {
                    int cnt = 0;
                    for (int j = 0; j < k; j++) {
                        for (int l = 0; l < n; l++) {
                            if (cows[j][l] == i) {
                                cnt++;
                                break;
                            } else if (cows[j][l] == x) {
                                break;
                            }
                        }
                    }
                    if (cnt == k) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
        pw.println(ans);
        pw.close();
    }
}

// 4 1 2 3
// 4 1 3 2
// 4 2 1 3