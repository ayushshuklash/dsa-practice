package DynamicPrograming;

import java.util.Arrays;

public class CountGivenSum {
    public static int dp[][];
    static int  calculateSum(int nums [],int len,int sum){
        dp = new int [len+1][sum+1];
        for (int i = 0; i < len+1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < sum+1 ; j++) {
            dp[0][j] = 0;
        }
        return  calculateHelper(nums,len,sum);
    }

    static int calculateHelper(int[] nums, int len, int sum){
        for(int i =1; i<=len;i++){
            for(int j =1; j<=sum;j++){
                if(sum <= nums[i-1]){
                    dp[i][j] = dp[i-1][j]+ dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len][sum];
    }
}
