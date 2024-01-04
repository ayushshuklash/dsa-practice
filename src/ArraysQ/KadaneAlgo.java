package ArraysQ;

import java.io.*;

public class KadaneAlgo {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[0];
        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine().trim());
            String[] a = br.readLine().split(" ");
            for (int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(a[i]);
            }
            System.out.println(solution(arr, n));
        }
    }

    public int solution(int[] arr, int n) {
        int csum = 0;
        int osum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (csum >= 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            if (csum > osum)
                osum = csum;
        }
        return osum;
    }
}