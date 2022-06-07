import java.util.*;
import java.io.*;

public class MooCast {
    static Cows[] cows;
    static int n;
    static boolean[] visited;

    static class Cows {

        int x, y, power, index;

        public Cows(int x, int y, int power, int index) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("moocast.in"));
        PrintWriter pw = new PrintWriter(new File("moocast.out"));
        // Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        cows = new Cows[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int p = scanner.nextInt();
            cows[i] = new Cows(x, y, p, i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            ans = Math.max(ans, dfs(cows[i]));
        }
        
        pw.println(ans);
        pw.close();
    }

    public static int dfs(Cows cow) {
        if (visited[cow.index]) {
            return 0;
        }
        int cnt = 0;
        visited[cow.index] = true;
        for (int i = 0; i < n; i++) {
            if (Math.sqrt((Math.pow(cows[i].x - cow.x, 2) + Math.pow(cows[i].y - cow.y, 2))) <= cow.power) {
                cnt += dfs(cows[i]);
            }
        }
        return cnt + 1;
    }
}
