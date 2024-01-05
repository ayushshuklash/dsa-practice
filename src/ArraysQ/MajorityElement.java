package ArraysQ;

import java.util.Scanner;

public class MajorityElement {

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
            System.out.println(new MajorityElement().majElement(arr));

        }
    }

    /*
    Solution:- 1.Solving it by map takes more space and to save space
               2.create two pointer to count and find number
               3.check if number appears again and increase counter
               4.else if not same number and decrease counter, if counter is 0 change major to current number
     */
    public int majElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;

        }
        return major;

    }

}
