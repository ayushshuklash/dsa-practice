package Recursion;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0)
                s.push(sc.nextInt());
            SortStack g = new SortStack();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }

    public static Stack<Integer> sort(Stack s){
        if (!s.isEmpty()) {
            int x = (int) s.pop();
            sort(s);
            sortedInsert(s, x);
        }
        return s;
    }
    public static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }
}
