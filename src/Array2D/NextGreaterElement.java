package Array2D;
import java.lang.*;
import java.io.*;
public class NextGreaterElement {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[n];
            for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
            long[] res = new NextGreaterElement().nextLargerElement(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }

        public static long[] nextLargerElement(long[] arr, int n)
        {
            int arrLength = arr.length;
            int k =0;
            long [] resArr = new long[arrLength];
            for (int i = 0; i < arrLength-1 ; i++) {
                int j = i+1;
                long curr = arr[i];
                long next = arr[j];
                while(j < arrLength && next > curr ){
                    next = arr[j++];
                    j++;
                }
                if(j > arrLength){
                    resArr[k] = -1;
                }else{
                    resArr[k] = next;
                }
            }
            resArr[arrLength-1] = -1;
            return  resArr;
        }
}
