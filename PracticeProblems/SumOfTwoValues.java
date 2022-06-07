import java.util.*;

public class SumOfTwoValues {
    static class Nums implements Comparable<Nums> {
        int a, i;

        public Nums(int a, int i) {
            this.a = a;
            this.i = i;
        }

        @Override
        public int compareTo(SumOfTwoValues.Nums o) {
            return Integer.compare(a, o.a);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int x = scanner.nextInt();

        Nums[] nums = new Nums[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            nums[i] = new Nums(a, i);
        }

        Arrays.sort(nums);

        int i = 0;
        int j = n - 1;

        boolean good = false;

        int val1 = 0;
        int val2 = 0;

        while (i < j) {
            if (nums[i].a + nums[j].a < x) {
                i++;
            } else if (nums[i].a + nums[j].a > x) {
                j--;
            } else if (nums[i].a + nums[j].a == x) {
                good = true;
                val1 = nums[i].i;
                val2 = nums[j].i;
                break;
            }
        }

        if (good) {
            System.out.println((val1 + 1) + " " + (val2 + 1));
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
