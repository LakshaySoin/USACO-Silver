import java.util.*;
import java.io.*;

public class RentalService {
    static class Stores implements Comparable<Stores> {
        int a, b;

        public Stores(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(RentalService.Stores o) {
            if (b == o.b) {
                return -Integer.compare(a, o.a);
            }
            return -Integer.compare(b, o.b);
        }
    }

    static class Rentals implements Comparable<Rentals> {
        int a;

        public Rentals(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(RentalService.Rentals o) {
            return -Integer.compare(a, o.a);
        }
    }

    static class Productions implements Comparable<Productions> {
        int a;

        public Productions(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(RentalService.Productions o) {
            return -Integer.compare(a, o.a);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("rental.in"));
        PrintWriter pw = new PrintWriter(new File("rental.out"));
        // Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(n);

        Productions[] productions = new Productions[n];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            productions[i] = new Productions(a);
        }

        Stores[] stores = new Stores[m];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            stores[i] = new Stores(a, b);
        }

        Rentals[] rentals = new Rentals[r];

        for (int i = 0; i < r; i++) {
            int a = scanner.nextInt();
            rentals[i] = new Rentals(a);
        }

        Arrays.sort(productions);
        Arrays.sort(stores);
        Arrays.sort(rentals);

        int[] profit = new int[n + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            profit[i + 1] = profit[i];
            while (index < m && productions[i].a > 0) {
                int used = Math.min(stores[index].a, productions[i].a);
                profit[i + 1] += used * stores[index].b;
                productions[i].a -= used;
                stores[index].a -= used;
                if (stores[index].a == 0) {
                    index++;
                }
            }
        }

        int num = n - 1;
        int rindex = 0;
        int rent = 0;

        while (num > 0 && rindex < r) {
            rent += rentals[rindex].a;
            profit[num] += rent;
            rindex++;
            num--;
        }

        int ans = 0;

        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, profit[i]);
        }

        System.out.println(ans);
        pw.println(ans);
        pw.close();
    }
}
