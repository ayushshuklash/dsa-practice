package Array2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumSwapstoSort {

    public int minSwaps(int [] nums){
        int sum = 0;

        return sum;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            MinimumSwapstoSort obj = new MinimumSwapstoSort();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
        }
    }
}
