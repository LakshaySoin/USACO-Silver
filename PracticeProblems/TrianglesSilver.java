import java.io.*;
import java.util.*;

public class TrianglesSilver {
    static class Coordinates implements Comparable<Coordinates> {
        int x, y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(TrianglesSilver.Coordinates o) {
            return Integer.compare(x, o.x);
        }
    }
    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(new File("triangles.in"));
        // PrintWriter pw = new PrintWriter(new File("triangles.out"));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Coordinates[] coorsx = new Coordinates[n];
        Coordinates[] coorsy = new Coordinates[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            coorsx[i] = new Coordinates(x, y);
            coorsy[i] = new Coordinates(y, x);
        }
        Arrays.sort(coorsx);
        int xvals = 0;
        for (int i = 0; i < n; i++) {
            int x = i + 1;
            while (x < n) {
                if (coorsx[x].y == coorsx[i].y) {
                    xvals += Math.abs(coorsx[x].x - coorsx[i].x);
                    x++;
                }
            }
        }
        Arrays.sort(coorsy);
        int yvals = 0;
        for (int i = 0; i < n; i++) {
            int x = i + 1;
            while (x < n) {
                if (coorsy[x].x == coorsy[i].x) {
                    yvals += Math.abs(coorsy[x].y + coorsy[i].y);
                    x++;
                }
            }
        }
        System.out.println((xvals * yvals) % (10e9 + 7));
    }
}