package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DefAKingdom {
    public int calculatePenalty(int wArr[],int hArr[], int width, int height, int noOfTower){
        int sum =0;
        Arrays.sort(wArr);
        Arrays.sort(hArr);
        int maxWidth = wArr[0];
        int maxHeight =hArr[0];
        for (int i = 0; i < noOfTower; i++) {
            if(i == noOfTower-1){
                if(maxHeight < height-hArr[i])
                    maxHeight = height-hArr[i];
                if(maxWidth< width-wArr[i])
                    maxHeight = width-wArr[i];
            }else{
                if(maxHeight < hArr[i+1]-hArr[i])
                maxHeight = hArr[i+1]-hArr[i];
                if(maxWidth< wArr[i+1]-wArr[i])
                    maxHeight = wArr[i+1]-wArr[i];
            }
        }
        sum = maxHeight*maxWidth;
        return sum;
    }

    public static void main(String [] args) throws IOException {
        DefAKingdom DAK = new DefAKingdom();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[2]);
            int w = Integer.parseInt(str[0]);
            int h = Integer.parseInt(str[1]);
            int a [] =  new int[n];
            int b[] =  new int[n];
            for (int i = 0; i < n; i++){
                str = read.readLine().trim().split(" ");
                a[i] = Integer.parseInt(str[0]);
                b[i] = Integer.parseInt(str[1]);
            }
            System.out.println(DAK.calculatePenalty(a,b,w,h,n));
        }
    }
}
