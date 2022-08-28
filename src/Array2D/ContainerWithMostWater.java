package Array2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1

HACK:-
Create a nested loop, the outer loop traverses the array from 0 to end (index of this loop is i).
The inner loop traverses the array from i + 1 to end (index of this loop is j).
Find the water that can be contained in the container with height of boundaries as array[i] and array[j], i.e area = (j – i)* min(array[i],array[j]), if this area is greater than current maximum, update the current maximum
Print the current maximum.
 */
public class ContainerWithMostWater {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
            System.out.println( new ContainerWithMostWater().maxArea(arr) );
    }
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start <end){
            if(height[start]< height[end]){
                maxArea = Math.max(maxArea,Math.min(height[start],height[end])* (end-start));
                start++;

            }else{
                maxArea = Math.max(maxArea,Math.min(height[end],height[start])* (end-start));
                end--;
            }
        }
        return maxArea;
    }
}
