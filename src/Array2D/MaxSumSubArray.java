package Array2D;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSumSubArray {
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);

            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N);

            // Appending new elements at
            // the end of the list
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x);
            }

            MaxSumSubArray ob = new MaxSumSubArray();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
    }
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        Collections.sort(Arr, Collections.reverseOrder());
        long sum = 0;
        for(int i = 0;i<K;i++){
            System.out.println("Sum = "+ sum +" K " +i+ " Element "+ Arr.get(i));
            sum = sum + Arr.get(i);
        }
        return sum;
    }
}
