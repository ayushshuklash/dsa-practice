/*
There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output:
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output:
1
Explanation:
Only one meetings can be held
with given start and end timings.

Your Task :
You don't need to read inputs or print anything. Complete the function maxMeetings() that takes two arrays start[] and end[] along with their size N as input parameters and returns the maximum number of meetings that can be held in the meeting room.


Expected Time Complexity : O(N*LogN)
Expected Auxilliary Space : O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ start[i] < end[i] ≤ 105


HACK: -Sort Meeting by End time
      -Traverse the array and compare the end time with next start time and keep updating the end time
 */


package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Meeting
{
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting>
{
    @Override
    public int compare(Meeting o1, Meeting o2)
    {
        if (o1.end < o2.end)
        {

            // Return -1 if second object is
            // bigger then first
            return -1;
        }
        else if (o1.end > o2.end)

            // Return 1 if second object is
            // smaller then first
            return 1;

        return 0;
    }
}
public class MaxMeetingInaRoom {

    public int evaluateNoOfMeetings(ArrayList<Meeting> al, int s){
        // Initialising an arraylist for storing answer
        ArrayList<Integer> m = new ArrayList<>();

        int time_limit = 0;

        MeetingComparator mc = new MeetingComparator();

        // Sorting of meeting according to
        // their finish time.

        Collections.sort(al, mc);

        // Initially select first meeting.
        m.add(al.get(0).pos);

        // time_limit to check whether new
        // meeting can be conducted or not.
        time_limit = al.get(0).end;

        // Check for all meeting whether it
        // can be selected or not.
        for(int i = 1; i < al.size(); i++)
        {
            if (al.get(i).start > time_limit)
            {

                // Add selected meeting to arraylist
                m.add(al.get(i).pos);

                // Update time limit
                time_limit = al.get(i).end;
            }
        }

        // Print final selected meetings.
        for(int i = 0; i < m.size(); i++)
            System.out.print(m.get(i) + 1 + " ");

        return m.size();
    }
    public static void main (String args[]) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        ArrayList<Meeting> meet = new ArrayList<Meeting>();
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                end[i] = Integer.parseInt(inputLine[i]);

            for (int i = 0; i < n; i++) {
                Meeting temp = new Meeting(start[i],end[i],i);
                meet.add(new Meeting(start[i],end[i],i));
            }

            int ans = new MaxMeetingInaRoom().evaluateNoOfMeetings(meet, n);
            System.out.println(ans);
        }
    }



}
