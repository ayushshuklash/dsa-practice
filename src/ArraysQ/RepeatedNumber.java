package ArraysQ;

import java.util.Scanner;

public class RepeatedNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter length");
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            System.out.println("Enter k");
            int k = sc.nextInt();
            int[] a = new RepeatedNumber().repNumber(arr);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }

        }
    }

    public int[] repNumber(final int[] A) {
        int[] ans = new int[2];
        int major = A[0], count = 1, sum = A[0], sumdiff = 1;
        for (int i = 1; i < A.length; i++) {
            if (count == 0) {
                count++;
                major = A[i];
            } else if (major == A[i]) {
                count++;
            } else
                count--;
            sum = sum + A[i];
            sumdiff = sumdiff + i + 1;
        }


        ans[0] = major;
        ans[1] = sumdiff - sum + major;
        return ans;
    }
}
