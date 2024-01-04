package ArraysQ;

import java.util.Scanner;

/*
Given an array of integers. Find the Inversion Count in the array.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array
are same, so there is no inversion count.
 */
public class CountInversion {
    static long count = 0;

    static long inversionCount(long[] arr, long N) {
        mergeSort(arr, 0, N - 1);
        return count;
    }

    private static long[] mergeSort(long[] arr, long i, long l) {
        if (i == l) {
            long[] ba = new long[1];
            ba[0] = arr[(int) i];
            return ba;
        }
        long mid = (i + l) / 2;
        long[] left = mergeSort(arr, i, mid);
        long[] right = mergeSort(arr, mid + 1, l);
        long[] merged = merge2sortedArrays(left, right);
        return merged;

    }

    private static long[] merge2sortedArrays(long[] left, long[] right) {
        long i = 0;
        long j = 0;
        long k = 0;
        long[] merged = new long[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[(int) i] <= right[(int) j]) {
                merged[(int) k] = left[(int) i];
                i++;
                k++;
            } else {
                count += (left.length - i);
                merged[(int) k] = right[(int) j];
                k++;
                j++;
            }
        }
        while (i < left.length) {
            merged[(int) k] = left[(int) i];
            k++;
            i++;
        }
        while (j < right.length) {
            merged[(int) k] = right[(int) j];
            k++;
            j++;
        }
        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            System.out.println("Enter length");
            long n = sc.nextLong();
            long[] arr = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(new CountInversion().inversionCount(arr, n));

        }
    }
}
