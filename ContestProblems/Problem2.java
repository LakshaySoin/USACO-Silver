import java.io.*;
import java.util.*;

public class Problem2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = (String) st.nextToken();

        st = new StringTokenizer(br.readLine());

        String str2 = (String) st.nextToken();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] alpha_frequency = new int[18];
        int[] beta_frequency = new int[18];

        for (int i = 0; i < str1.length(); i++) {
            alpha_frequency[str1.charAt(i) - 97] += 1;
        }

        for(int i = 0; i < str2.length(); i++) {
            beta_frequency[str2.charAt(i) - 97] += 1;
        }

        StringBuilder res = new StringBuilder();

        String[] works = new String[n];
        boolean[] data = new boolean[n];

        for (int i = 0; i < n; i++) {
            data[i] = false;
        }

        for(int j = 0; j < n; j++){

            st = new StringTokenizer(br.readLine());

            works[j] = st.nextToken();

            boolean[] temp = new boolean[18];

            for(int i = 0; i < works[j].length();i++) {
                temp[works[j].charAt(i) - 97] = true;
            }

            data[j] = true;

            // if the frequency of the a and b cnts are not the same then we can just say it doesn't work

            for (int i = 0; i < 18 && data[j]; i++) {
                if (temp[i] == true && alpha_frequency[i] != beta_frequency[i]) {
                    data[j] = false;
                }
            } 

            if (!data[j]) {
                res.append("N");
                continue;
            }
            if (works[j].length() == 1) {
                res.append("Y");
                continue;
            }

            data[j] = equals(str1, str2, temp);

            if (data[j]) {
                res.append("Y");
            } else {
                res.append("N");
            }

        }

        System.out.println(res);

    }

    public static boolean equals(String str1, String str2, boolean[] temp){

        int p1 = 0;
        int p2 = -1;

        boolean valid = true;

        // two pointers to check if altered strings are equal

        while (p1 < str1.length() || p2 < str2.length()) {

            if (valid) {

                if (p1 >= str1.length() || temp[str1.charAt(p1) - 97]){
                    p2 += 1;
                    valid = false;
                } else {
                    p1 += 1;
                }

            } else{

                if (p1 < str1.length() && p2 >= str2.length()) {
                    return false;
                }

                if (temp[str2.charAt(p2) - 97]) {

                    if (p1 >= str1.length() || str1.charAt(p1) != str2.charAt(p2)) {
                        return false;
                    }

                    p1++;
                    valid = true;

                } else {
                    p2++;
                }
            }
        }

        return true;

    }
}
