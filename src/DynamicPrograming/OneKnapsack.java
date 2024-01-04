package DynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OneKnapsack {
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        //reading total testcases
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());

            int val[] = new int[n];
            int wt[] = new int[n];

            String st[] = read.readLine().trim().split("\\s+");

            //inserting the values
            for(int i = 0; i < n; i++)
                val[i] = Integer.parseInt(st[i]);

            String s[] = read.readLine().trim().split("\\s+");

            //inserting the weigths
            for(int i = 0; i < n; i++)
                wt[i] = Integer.parseInt(s[i]);

            //calling method knapSack() of class Knapsack
            System.out.println(new OneKnapsack().knapSack(w, wt, val, n));
        }
        //Function to return max value that can be put in knapsack of capacity W.

    }
    public static int[][] dp;
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n)
    {

        dp =  new int[W+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return helper(W,wt,val,n);


    }


    static int helper(int W, int wt[], int val[], int n)
    {
        if(n==0 || W==0 ) return 0;

        if(dp[W][n]!=-1) return dp[W][n];

        if(W>=wt[n-1])
        {
            dp[W][n]= Math.max(helper(W-wt[n-1],wt,val,n-1)+val[n-1], helper(W,wt,val,n-1));
            return dp[W][n];
        }
        else
        {
            dp[W][n]=helper(W,wt,val,n-1);
            return dp[W][n];
        }
    }




}
