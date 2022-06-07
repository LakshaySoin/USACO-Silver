import java.util.*;
import java.io.*;


public class Problem3 {

    private static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static PrintWriter pw = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        String str = read();
        char sigma = findsigma(str);
        char[] stepOne = process1(str);
        char[] stepTwo = process2(str);
        int queries = nums();
        
        StringBuilder yn = new StringBuilder();

        for (int query = 0; query < queries; query++) {

            int a = nums();
            int b = nums();
            char c = stepOne[a-1];
            char d = stepTwo[b];
            char e = find(c, d, sigma);
            
            if (e == 'C') {
                yn.append("Y");
            }
            else {
                yn.append("N");
            }
        }

        findQuery(yn.toString(), true);
        
    }

    public static String read() throws IOException {
        return sc.readLine();
    }
    
    public static char[] process1(String str) {
        char[] arr = new char[str.length() + 1];
        int len = str.length();
        arr[len] = ' ';


        for (int i = str.length() -1; i >=  0; i--) arr[i] = sum(arr[i+1], str.charAt(i));
        return arr;
    }


    public static char[] process2(String str) {
        char[] arr = new char[str.length() + 1];
        arr[0] = ' ';

        for (int i = 0; i < str.length(); i++) arr[i+1] = sum(arr[i],str.charAt(i));
        return arr;
    }

    public static char sum(char c1, char c2) {
        if (c1 == ' ') return c2;
        else if (c2 == ' ') return c1;
        else if (c1 == c2) return ' ';
        int sigma = (c1 - 'A') + (c2 - 'A');
        if (sigma == 36) return 'C';
        if (sigma == 24) return 'O';
        if (sigma == 16) return 'W';
        return 'a';
    }

    public static char findsigma(String str) {

        char partial = ' ';
        //
        for (char c : str.toCharArray()) partial = sum(partial, c);
        return partial;
        
    }

    public static void findQuery(String con, boolean b) {

        pw.println(con);
        if (b) pw.close();

    }

    public static char find(char firstpointer, char secondpointer, char sigma) {
        

        char[] can = new char[] {'C', 'O', 'W', ' '};
        for (char ch : can) {
            if (sum(sum(firstpointer, ch), secondpointer) == sigma) return ch;
        }
        return 'a';

    }


    public static int nums() throws IOException {

        if (st != null && st.hasMoreTokens()) return Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(sc.readLine());
        return Integer.parseInt(st.nextToken());

    }

}