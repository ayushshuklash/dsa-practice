package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WiggleSequence {
    public int wiggleMaxLength(int[] nums) {
        int length = 0;
        if(nums.length == 0){
            return 0;
        }else{
            int expect =-1;
            int iter = 0;
            for (int i = 0; i < nums.length-1; i++) {
                int diff = nums[i+1]-nums[i];
                if(iter>1 ||  iter<-1){
                    length = length-1;
                }
                 if(diff >= expect && diff !=0 ){
                    length = length+1;
                    expect = 1;
                    iter++;

                }else {
                    length = length+1;
                    expect =-1;
                     iter--;
                }
            }
            return length+1;
        }
    }
    public static void main(String [] args) throws IOException {
        WiggleSequence reObj = new WiggleSequence();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input []= read.readLine().split(",");
        int nums [] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println(reObj.wiggleMaxLength(nums));
    }
}
