package Greedy;
/*Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.


Example 1:

Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.
Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to
safely manage the arrival and departure
of all trains.

HACK:(Same as minimum meetings) - Sort both arrival and departure
                                -
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Train {
    int pos;
    int arr;
    int dep;

    Train(int pos, int arr, int dep) {
        this.pos = pos;
        this.arr = arr;
        this.dep = dep;
    }
}

class TrainComparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
        if (o1.dep < o2.dep) {
            return -1;
        } else if (o1.dep > o2.dep)
            return 1;
        return 0;
    }
}

public class MinimumPlatform {

    static int findPlatform(int arr[], int dep[], int n) {
        // sort arrival time of trains
        Arrays.sort(arr);

        // sort departure time of trains
        Arrays.sort(dep);

        // maintains the count of trains
        int count = 0;

        // stores minimum platforms needed
        int platforms = 0;

        // take two indices for arrival and departure time
        int i = 0, j = 0;

        // run till all trains have arrived
        while (i < arr.length) {
            // if a train is scheduled to arrive next
            if (arr[i] < dep[j]) {
                // increase the count of trains and update minimum
                // platforms if required
                platforms = Integer.max(platforms, ++count);

                // move the pointer to the next arrival
                i++;
            }

            // if the train is scheduled to depart next i.e.
            // `departure[j] < arrival[i]`, decrease trains' count
            // and move pointer `j` to the next departure.

            // If two trains are arriving and departing simultaneously,
            // i.e., `arrival[i] == departure[j]`, depart the train first
            else {
                count--;
                j++;
            }
        }

        return platforms;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);


            System.out.println(new MinimumPlatform().findPlatform(arr, dep, n));
        }
    }
}
