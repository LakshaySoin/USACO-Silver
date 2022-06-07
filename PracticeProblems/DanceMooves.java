import java.util.*;

public class DanceMooves {
    static class Swaps implements Comparable<Swaps> {
        int a, b;

        public Swaps(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(DanceMooves.Swaps o) {
            return Integer.compare(a, o.a);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] cows = new int[n];
        int[] original = new int[n];
        boolean[][] done = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            cows[i] = i;
            original[i] = i;
            done[i][i] = true;
        }

        Swaps[] swaps = new Swaps[k];

        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            swaps[i] = new Swaps(a, b);
        }

        int i = 0;
        while (true) {
            int temp = cows[swaps[i].a - 1];
            cows[swaps[i].a - 1] = cows[swaps[i].b - 1];
            cows[swaps[i].b - 1] = temp;
            done[cows[swaps[i].a - 1]][swaps[i].a - 1] = true;
            done[cows[swaps[i].b - 1]][swaps[i].b - 1] = true;
            if (Arrays.equals(cows, original)) {
                break;
            }
            i++;
            i %= k;
        }

        for (int x = 0; x < n; x++) {
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (done[x][j]) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
