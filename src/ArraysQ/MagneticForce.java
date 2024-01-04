package ArraysQ;

import java.util.Arrays;
import java.util.Scanner;

public class MagneticForce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter length");
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(new MagneticForce().maxDistance(arr, n));

        }
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int hi = position[position.length - 1];
        int lo = position[0];
        while (lo < hi) {
            int mi = (lo + hi + 1) / 2;
            if (checkPo(position, mi, m)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo - 1;
    }

    private boolean checkPo(int[] position, int mi, int m) {
        int lastPo = position[0];
        int idx = 1;
        m--;
        while (idx < position.length && m > 0) {
            if (position[idx] - lastPo >= mi) {
                lastPo = position[idx];
                m--;
            }
            idx++;
        }
        return m == 0;
    }
}
