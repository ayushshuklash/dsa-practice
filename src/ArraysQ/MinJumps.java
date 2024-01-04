import java.util.*;
import java.io.*;
public class MinJumps {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[0];
        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine().trim());
            String[] a = br.readLine().split(" ");
            for (int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(a[i]);
            }
            System.out.println(solution(arr));
        }
    }

    public int solution(int[] arr){
        int i =0;
        int b=0;
       while(i < arr.length){
            if(arr[i] == 0)
                return -1;
            else {
                i = arr[i];
                b++;
            }
        }
       return b;
    }
}