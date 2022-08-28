package Greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* Maximum Units on a Truck
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.



Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
 */
public class TruckMaximumUnits {

    static class mycomparator implements Comparator<int[]> {
        @Override
        public int compare(int [] o1, int[] o2) {
            if (o1[1] > o2[1])
                return -1;
            else if (o1[1] < o2[1])
                return 1;
            return 0;
        }
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Comparator<? super int[]> mycomparator = new mycomparator();
        int sum =0;
        Arrays.sort(boxTypes,mycomparator);
        for (int [] box : boxTypes) {
            int noOfBoxes = box[0];
            int noOfUnits = box[1];
            if(truckSize >= noOfBoxes){
                sum = sum + noOfBoxes*noOfUnits;
                truckSize = truckSize-noOfBoxes;
            }else{
                sum = sum + truckSize*noOfUnits;
                return sum;
            }
        }
        return sum;
    }
    public static void main (String args[]) throws IOException {
        int[][] boxTypes = new int[3][2];
        boxTypes[0][0] = 1;
        boxTypes[0][1] = 3;
        boxTypes[1][0] = 2;
        boxTypes[1][1] = 2;
        boxTypes[2][0] = 3;
        boxTypes[2][1] = 1;
        int truckSize =4;
        System.out.print(maximumUnits(boxTypes,truckSize));
    }

    }
