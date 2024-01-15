package ArraysQ;

import java.util.Scanner;

/*
Solution:- Get the total size of two arrays m + n

If m + n is odd, we are looking for the (m + n) / 2-th element.
If m + n is even, we are looking for the average of the (m + n) / 2-th and the (m + n) / 2 + 1-th elements.
Set two pointers p1 and p2 at the beginning of arrays nums1 and nums2.

If both p1 and p2 are in bounds of the arrays, compare the values at p1 and p2:

If nums1[p1] is smaller than nums2[p2], we move p1 one place to the right.
Otherwise, we move p2 one place to the right.
If p1 is outside nums1, just move p2 one place to the right.
If p2 is outside nums2, just move p1 one place to the right.

Get the target elements and calculate the median:

If m + n is odd, repeat step 3 by (m + n + 1) / 2 times and return the element from the last step.
If m + n is even, repeat step 3 by (m + n) / 2 + 1 times and return the average of the elements from the last two steps.
 */
public class MedianSortedArray {
    private int p1 = 0;
    private int p2 = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            System.out.println("Enter length");
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] arr2 = new int[n];

            for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                    arr2[i] = sc.nextInt();
            }
            System.out.print(new MedianSortedArray().findMedianSortedArrays(arr,arr2));
        }
    }

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        } else if (p1 < nums1.length) {
            return nums1[p1++];
        } else if (p2 < nums2.length) {
            return nums2[p2++];
        }
        return -1;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0) {
            for (int i = 0; i < (m + n) / 2 - 1; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        } else {
            for (int i = 0; i < (m + n) / 2; ++i) {
                int tmp = getMin(nums1, nums2);
            }
            return getMin(nums1, nums2);
        }
    }
}
