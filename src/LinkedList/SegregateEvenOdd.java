package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SegregateEvenOdd {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); }
            return str;
        }

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }
    static class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    static void printList(Node node, PrintWriter out)
    {
        while (node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Node ans = divide(n, head);
            printList(ans, out);
            t--;
        }
        out.flush();
    }

    static Node divide(int N, Node head){
        Node currentEven = null;
        Node currentOdd = null;
        Node headEven  =null;
        Node headOdd  =null;
        Node nextEle = head;
        while(nextEle != null){
            if(nextEle.data % 2 == 0){
                Node newNodeEven = new Node(nextEle.data);
                if(headEven == null){
                    newNodeEven.next = currentEven;
                    headEven = newNodeEven;
                }else{
                    currentEven.next = newNodeEven;
                }
                currentEven = newNodeEven;
            }else{
                Node newNodeOdd = new Node(nextEle.data);
                if(headOdd == null){
                    newNodeOdd.next = currentOdd;
                    headOdd = newNodeOdd;
                }else{
                    currentOdd.next = newNodeOdd;
                }
                currentOdd = newNodeOdd;
            }
            nextEle = nextEle.next;
        }
        if(currentEven !=null){
            currentEven.next = headOdd;
            return headEven;
        }else if(currentOdd != null ){
            return headOdd;
        }else{
            return null;
        }

    }
}
