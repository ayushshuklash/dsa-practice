package ArraysQ;

import java.io.*;

public class MissingNumber {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(solution(arr, n));
        }
    }

    public int solution(int[] arr, int n) {
        int sumOfArray = 0;
        int sumOfDigitArray = 0;
        for (int i = 1; i <= n; i++) {
            if (i < n)
                sumOfArray = arr[i - 1] + sumOfArray;
            sumOfDigitArray = sumOfDigitArray + i;
        }
        return sumOfDigitArray - sumOfArray;
    }
}