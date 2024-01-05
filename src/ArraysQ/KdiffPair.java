package ArraysQ;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/*
Solution :- 1.First we will create map for counting frequencies of each element in the array.

            2.Now we have 2 cases over here as
            -->a) if k == 0 it means we need to count frequency of the same element by using map.get(i) method.
            -->b) we need to take counter approach for every element by adding k everytime and check whether that element is present in map or not.

            Instead of iterating through array, we will iterate through map.keySet() for getting unique elements.
 */
public class KdiffPair {

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
            System.out.println(new KdiffPair().findPairs(arr, k));

        }
    }

    public int findPairs(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int result = 0;
        for (int i : map.keySet())
            if (k > 0 && map.containsKey(i + k) || k == 0 && map.get(i) > 1)
                result++;
        return result;
    }
}
