package ArraysQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseVowel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();
            System.out.println(reverseVowels(str));
        }
    }

    public static String reverseVowels(String s) {
        char[] vow = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                vow[j++] = s.charAt(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' || s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
                    s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                s = s.replace(s.charAt(i), vow[j]);
            }
        }
        return s;
    }

}
