import java.util.*;

public class Towers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> towers = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            int lo = 0;
            int hi = towers.size();
            int mid = 0;
            while (lo < hi) {
                mid = lo + ((hi - lo) / 2);
                if (towers.get(mid) <= k) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo == towers.size()) {
                towers.add(k);
            } else {
                towers.set(lo, k);
            }
        }
        System.out.println(towers.size());
    }
}
