import java.util.*;
import java.io.*;

public class ClosingTheFarm {
    static ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
    static boolean[] closings, visited;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("closing.in"));
        PrintWriter pw = new PrintWriter(new File("closing.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            roads.add(new ArrayList<Integer>());
        }
 
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            roads.get(a).add(b);
            roads.get(b).add(a);
        }

        closings = new boolean[n];
        visited = new boolean[n];

        int goal = n;

        for (int i = 0; i < n; i++) {

            Arrays.fill(visited, false);
            int nodes = 0;

            for (int x = 0; x < n; x++) {
                if (!closings[x]) {
                    nodes = dfs(x);
                    break;
                }
            }

            if (nodes == goal) {
                System.out.println("YES");
                pw.println("YES");
            } else {
                System.out.println("NO");
                pw.println("NO");
            }
            goal--;
            closings[scanner.nextInt() - 1] = true;
        }
        pw.close();
    }

    public static int dfs(int node) {
        int cnt = 1;
        visited[node] = true;
        for (int i : roads.get(node)) {
            if (!visited[i] && !closings[i]) {
                cnt += dfs(i);
            }
        }
        return cnt;
    }
}
