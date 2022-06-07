import java.util.*;
import java.io.*;

public class Problem1 {

    // find scc for the graph
    // each node in the directed graph must point toward itself

    static void second(int node) {
        seen[node] = true;
        marked[node] = color;
        for (int n : adj1.get(node)) {
            if (!seen[n]) {
                second(n);
            }
        }
    }

    static void first(int node, Stack stack) {
        seen[node] = true;
        for (int n : adj2.get(node)) {
            if(!seen[n]) {
                first(n, stack);
            }
        }
        stack.push(new Integer(node));
    }

    static void solve(int n) {
        Stack stack = new Stack();
        for (int i = 0; i < seen.length; i++) {
            seen[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                first(i, stack);
            }
        }
        for (int i = 0; i < seen.length; i++) {
            seen[i] = false;
        }
        while (!stack.empty()) {
            int node = (int) stack.pop();
            if (!seen[node]) {
                second(node);
                color++;
            }
        }
    }

    // static variables 

    static int[] marked;
    static boolean[] seen;
    static int color;
    static ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> adj2 = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        // fast input

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<Integer>());
            adj2.add(new ArrayList<Integer>());
        }

        marked = new int[n];
        seen = new boolean[n];
        int[] totals = new int[n];
        long res = 0;
        color = 0;

        for (int i = 0; i < marked.length; i++) {
            marked[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(tokenizer.nextToken()) - 1;
            int m = Integer.parseInt(tokenizer.nextToken());
            totals[i] = m;
            adj1.get(i).add(p);
            adj2.get(p).add(i);
        }

        for (int i = 0; i < n; i++) {
            if (marked[i] == -1) {
                solve(n);
            }
        }

        long[] ans = new long[color];
        long[] deletes = new long[color];
        int[] cnts = new int[color];

        for (int i = 0; i < color; i++) {
            deletes[i] = Long.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            ans[marked[i]] += totals[i];
            deletes[marked[i]] = Math.min(deletes[marked[i]], totals[i]);
            cnts[marked[i]] += 1;
        }

        for (int i = 0; i < color; i++) {
            if (cnts[i] == 1) {
                res += ans[i];
            } else {
                res += (ans[i] - deletes[i]);
            }
        }

        System.out.println(res);

    }
}