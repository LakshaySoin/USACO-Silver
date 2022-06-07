import java.util.*;
import java.io.*;

public class MyCowAteMyHomework {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("homework.in"));
        PrintWriter pw = new PrintWriter(new File("homework.out"));
        // Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            scores[i] = a;
        }
        // Arrays.sort(scores);
        int[] prefix = new int[n];
        int smallest = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            smallest = Math.min(smallest, scores[i]);
            prefix[i] = smallest;
        }
        double max = Double.MIN_VALUE;
        double sum = 0;
        int divisor = 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int k = n - 2; k > 0; k--) {
            sum += scores[k];
            double temp = (sum - prefix[k]) / (divisor);
            // System.out.println(prefix[k]);
            // System.out.println(prefix[k]);
            if (temp > max) {
                ans = new ArrayList<Integer>();
                max = temp;
                ans.add(k);
            } else if (temp == max) {
                ans.add(k); 
            }
            divisor++;
        }
        Collections.sort(ans);
        for (int i : ans) {
            System.out.println(i);
            pw.println(i);
        }
        pw.close();
    }
}
