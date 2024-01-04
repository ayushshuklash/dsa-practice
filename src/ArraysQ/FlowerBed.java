package ArraysQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlowerBed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(canPlaceFlowers(arr, n));
        }
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 1; i < flowerbed.length - 1; i++) {
            System.out.println("var-1" + flowerbed[i] + " var " + flowerbed[i] + " var+1 " + flowerbed[i]);
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i - 1] = flowerbed[i + 1] = 1;
                n = n - 2;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 1) {
                flowerbed[i - 1] = 1;
                n--;
            }
            if (flowerbed[i - 1] == 1 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i + 1] = 1;
                n--;
            }
        }
        return n <= 0;

    }
}
