import java.util.*;
import java.io.*;

public class loadBalancing {
    static class Locs implements Comparable<Locs> {
        int a, b;

        public Locs(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(loadBalancing.Locs o) {
            return Integer.compare(a, o.a);
        }
    }

    static class State implements Comparable<State> {
        int a, b;

        public State(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(loadBalancing.State o) {
            return Integer.compare(a, o.a);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("balancing.in"));
        PrintWriter pw = new PrintWriter(new File("balancing.out"));
        // Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Locs[] locs = new Locs[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            locs[i] = new Locs(a, b);
        }

        Arrays.sort(locs);  

        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            ArrayList<State> above = new ArrayList<State>();
            ArrayList<State> below = new ArrayList<State>();
            for (int x = 0; x < n; x++) {
                if (locs[x].b <= locs[i].b) {
                    below.add(new State(locs[x].a, locs[x].b));
                } else {
                    above.add(new State(locs[x].a, locs[x].b));
                }
            }
            int belowI = 0;
            int aboveI = 0;
            while (belowI < below.size() || aboveI < above.size()) {
                int xborder = Integer.MAX_VALUE;
                if (belowI < below.size()) {
                    xborder = Math.min(xborder, below.get(belowI).a);
                }
                if (aboveI < above.size()) {
                    xborder = Math.min(xborder, above.get(aboveI).a);
                }
                while (belowI < below.size() && below.get(belowI).a == xborder) {
                    belowI++;
                }
                while (aboveI < above.size() && above.get(aboveI).a == xborder) {
                    aboveI++;
                }
                ans = Math.min(ans, Math.max(Math.max(belowI, below.size() - belowI), Math.max(aboveI, above.size() - aboveI)));
            }
        }

        // System.out.println(ans);

        pw.println(ans);
        pw.close();
    }
}
