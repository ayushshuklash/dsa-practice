package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Comparator<? super int[]> mycomparator = new mycomparator();
        int sum =0;
        Arrays.stream(boxTypes).sorted(mycomparator);
        int i =0;
        while(truckSize >=0){
            if(truckSize-boxTypes[i][1] >0){
                sum = sum + boxTypes[i][1]*boxTypes[i][0];
                truckSize = truckSize-boxTypes[i][1];
            }else{
                sum = truckSize * boxTypes[i][0];
                truckSize =0;
            }
        }
        return sum;
    }

    static class mycomparator implements Comparator<int[]> {
        @Override
        public int compare(int [] o1, int[] o2) {
            if (o1[1] < o2[1])
                return -1;
            else if (o1[1] > o2[1])
                return 1;
            return 0;
        }
    }
}
