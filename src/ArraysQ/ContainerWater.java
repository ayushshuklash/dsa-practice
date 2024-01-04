package ArraysQ;

import java.util.Scanner;

public class ContainerWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            System.out.println("Enter length");
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextInt();

            System.out.println(new ContainerWater().maxArea(arr));

        }
    }

    private int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (Math.min(height[left], height[right]) * (right - left)));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}

