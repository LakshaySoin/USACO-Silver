import java.util.*;
import java.io.*;

public class convention2 {
    static class Cows implements Comparable<Cows> {
        int a, b, i;

        public Cows(int a, int b, int i) {
            this.a = a;
            this.b = b;
            this.i = i;
        }

        @Override
        public int compareTo(convention2.Cows o) {
            return Integer.compare(a, o.a);
        }
    }

    static class Index implements Comparable<Index> {
        int index, priority;

        public Index(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(convention2.Index o) {
            return Integer.compare(priority, o.priority);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("convention2.in"));
        PrintWriter pw = new PrintWriter(new File("convention2.out"));
        // Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();

        Cows[] cows = new Cows[n];
        
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            cows[i] = new Cows(a, b, i);
        }

        Arrays.sort(cows);

        int i = 0;
        
        ArrayList<Index> waiting = new ArrayList<Index>();

        int time = 0;

        int ans = 0;

        while (i < n) {
            if (cows[i].a > time && waiting.size() == 0) {
                time = cows[i].a + cows[i].b;
                i++;
            } else if (cows[i].a > time) {
                Collections.sort(waiting);
                ans = Math.max(ans, time - cows[waiting.get(0).index].a);
                time += cows[waiting.get(0).index].b;
                waiting.remove(0);
            } else {
                waiting.add(new Index(i, cows[i].i));
                i++;
            }
        }

        // System.out.println(ans);

        pw.println(ans);
        pw.close();
    }
}
