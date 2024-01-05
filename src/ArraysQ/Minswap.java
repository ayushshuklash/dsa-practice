package ArraysQ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Solution :- 1.Sort a Copy Array
            2.Compare position with sort array and do swap in map
            3.Update the map so that minimum can be calculated
 */
public class Minswap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter length");
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.println(new Minswap().minSwaps(arr));

        }
    }

    public int minSwaps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        Map<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < n; i++) {
            h.put(nums[i], i);
        }

        int init = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != temp[i]) {
                ans++;
                init = nums[i];

                // Swap elements
                int tempIndex = h.get(temp[i]);
                nums[i] = nums[tempIndex];
                nums[tempIndex] = init;

                // Update the positions in the map
                h.put(init, tempIndex);
                h.put(temp[i], i);
            }
        }
        return ans;
    }
}
