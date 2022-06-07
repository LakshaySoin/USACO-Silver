import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoad {
    static class Cow implements Comparable<Cow> {
        int start, end;

        public Cow(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(WhyDidTheCowCrossTheRoad.Cow o) {
            return Integer.compare(end, o.end);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("helpcross.in"));
	    PrintWriter wr = new PrintWriter(new File("helpcross.out"));
        // Scanner scanner = new Scanner(System.in);

        int c = scanner.nextInt();
        int n = scanner.nextInt();

        int[] chickens = new int[c];
        for (int i = 0; i < c; i++) {
            int a = scanner.nextInt();
            chickens[i] = a;
        }

        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            cows[i] = new Cow(a, b);
        }

        Arrays.sort(chickens);
        Arrays.sort(cows);

        boolean[] taken = new boolean[c];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int x = 0; x < c; x++) {
                if (taken[x]) {
                    continue;
                } else if (chickens[x] < cows[i].start) {
                    continue;
                } else if (chickens[x] > cows[i].end) {
                    break;
                } else if (chickens[x] >= cows[i].start && chickens[x] <= cows[i].end) {
                    ans++;
                    taken[x] = true;
                    break;
                }
            }
        }
        // System.out.println(ans);
        wr.println(ans);
        wr.close();
    }
}