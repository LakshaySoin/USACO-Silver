import java.util.*;

public class Cowntagion {
    static ArrayList<ArrayList<Integer>> roads = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            roads.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            roads.get(a).add(b);
            roads.get(b).add(a);
        }
        int ans = 0;
        ans += dfs(0, -1);
        System.out.println(ans);
    }

    public static int dfs(int node, int parent) {
        int ans = 0;
        int infected = 1;
        visited[node] = true;
        int cows = roads.get(node).size();
        if (parent == -1) {
            cows++;
        }
        while (infected < cows) {
            ans++;
            infected *= 2;
        }
        for (int i : roads.get(node)) {
            if (i != parent) {
                ans += dfs(i, node) + 1;
            }
        }
        return ans;
    }
}
