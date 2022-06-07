import java.io.*;
import java.util.*;

public class MilkMeasurementSilver {
    static class Changes implements Comparable<Changes> {
        int d, c, m;
        public Changes(int d, int c, int m) {
            this.d = d;
            this.c = c;
            this.m = m;
        }
        @Override
        public int compareTo(MilkMeasurementSilver.Changes o) {
            return Integer.compare(d, o.d);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("measurement.in"));
        PrintWriter pw = new PrintWriter(new File("measurement.out"));
        // Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int g = scanner.nextInt();
        int[] productions = new int[n];
        Changes[] changes = new Changes[n];
        Set<Integer> prev = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int c = scanner.nextInt() - 1;
            int m = scanner.nextInt();
            prev.add(c);
            changes[i] = new Changes(d, c, m);
        }
        int size = prev.size();
        for (int i = 0; i < size; i++) {
            productions[i] = g;
        }
        Arrays.sort(changes);
        int ans = 0;
        Set<Integer> cows = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            cows.clear();
            productions[changes[i].c] += changes[i].m;
            int curr = Integer.MIN_VALUE;
            for (int x = 0; x < size; x++) {
                curr = Math.max(curr, productions[x]);
            }
            for (int x = 0; x < size; x++) {
                if (productions[x] == curr) {
                    cows.add(x);
                }
            }
            if (cows.size() != prev.size()) {
                ans++;
            } else {
                Integer[] temp1 = cows.toArray(new Integer[cows.size()]);
                Integer[] temp2 = prev.toArray(new Integer[prev.size()]);
                Arrays.sort(temp1);
                Arrays.sort(temp2);
                for (int j = 0; j < cows.size(); j++) {
                    if (temp1[j] != temp2[j]) {
                        ans++;
                        break;
                    }
                } 
            }
            prev = new HashSet(cows);
        }
        System.out.println(ans);
        pw.println(ans);
        pw.close();
    }
}