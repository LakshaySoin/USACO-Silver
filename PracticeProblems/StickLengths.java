import java.util.*;

public class StickLengths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            nums[i] = a;
        }

        Arrays.sort(nums);

        int mid = (n / 2);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums[i] - nums[mid]);
        }
        
        System.out.println(ans);
    }
}
