package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            TowerOfHanoi obj = new TowerOfHanoi();
            int N;

            //taking input N
            N = sc.nextInt();

            //calling toh() method
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }

    long a =0;
    public long toh(int N, int from, int to, int aux) {
        if (N == 0) {
            return a;
        }
        a++;
        a = toh(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod "
                + from + " to rod "
                + to);
        a = toh(N - 1, aux, to, from);
        return a;
    }
}
