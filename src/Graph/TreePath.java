package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class TreePath {
    public static void main (String args[]) throws Exception{
        Scanner s = new Scanner(System.in);
        String nodeAndK = s.nextLine();
        int node = Integer.parseInt(nodeAndK.split(" ")[0]);
        int k = Integer.parseInt(nodeAndK.split(" ")[1]);
        Integer weigth[] = Arrays.stream(s.nextLine().split(" ")).map(str -> Integer.parseInt(str)).toArray(Integer[]::new);
        int maxWeigth[] = new int[node];
        Arrays.stream(maxWeigth).map( m -> m = 0);
        while(s.hasNextLine() && s.nextLine() !=""){
            String input = s.nextLine();
            int defNode = Integer.parseInt(input.split(" ")[0]);
            int connNode = Integer.parseInt(input.split(" ")[1]);
            maxWeigth[defNode-1] =  maxWeigth[defNode-1] + weigth[connNode-1];
        }
        int max = maxWeigth[0];
        int maxIdx = 0;
        for(int j = 1; j < maxWeigth.length; j++) {
            if(maxWeigth[j] > max) {
                max = maxWeigth[j];
                maxIdx = j;
            }
        }
        System.out.println(maxIdx);
    }
}
