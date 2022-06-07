import java.util.*;
import java.io.*;

public class MilkVisits {
    static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    static String cows;
    static int num = 1;
    static int[] comp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter pw = new PrintWriter(new File("milkvisits.out"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cows = br.readLine();
        comp = new int[n];
        for (int i = 0; i < n; i++) {
            paths.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            paths.get(x).add(y);
            paths.get(y).add(x);
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
            num++;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            char c = st.nextToken().charAt(0);
            if (comp[a] != comp[b] || c == cows.charAt(a)) {
                System.out.print(1);
                pw.print(1);
            } else {
                System.out.print(0);
                pw.print(0);
            }
        }
        pw.close();
    }
    public static void dfs(int x) {
        if (comp[x] > 0) {
            return;
        }
        comp[x] = num;
        for (int i : paths.get(x)) {
            if (cows.charAt(i) == cows.charAt(x)) {
                dfs(i);
            }
        }
    }
}
