import java.io.*;
import java.util.*;

public class lemonadeLine {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("lemonade.in"));
        PrintWriter wr = new PrintWriter(new File("lemonade.out"));

        int n = scanner.nextInt();

        int[] cows = new int[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            cows[i] = a;
        }

        Arrays.sort(cows);
        
        int cnt = 0;

        for (int i = n - 1; i > -1; i--) {
            if (cows[i] < cnt) {
                break;
            }
            cnt++;
        }

        wr.println(cnt);
        wr.close();
    }
}
