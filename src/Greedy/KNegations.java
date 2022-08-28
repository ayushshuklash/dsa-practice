package Greedy;

import java.util.Arrays;

/*
Given an integer array nums and an integer k, modify the array in the following way:

choose an index i and replace nums[i] with -nums[i].
You should apply this process exactly k times. You may choose the same index i multiple times.

Return the largest possible sum of the array after modifying it in this way.
Example 1:

Input: nums = [4,2,3], k = 1
Output: 5
Explanation: Choose index 1 and nums becomes [4,-2,3].

Example 2:

Input: nums = [3,-1,0,2], k = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].

Example 3:

Input: nums = [2,-3,-1,5,-4], k = 2
Output: 13
Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 */
public class KNegations {

    static int sumArray(int[] arr, int n)
    {
        int sum = 0;
        // Iterate from 0 to n - 1
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum;
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        int i =0 ;
        Arrays.sort(nums);
        for (i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k != 0) {
                nums[i] = nums[i] * -1;
                k--;
                continue;
            }
            break;
        }
            if (i == nums.length)
                i--;

            if (k == 0 || k % 2 == 0)
                return sumArray(nums, nums.length);

            if (i != 0 && Math.abs(nums[i]) >= Math.abs(nums[i - 1]))
                i--;

            nums[i] *= -1;
            return sumArray(nums, nums.length);
    }
}
