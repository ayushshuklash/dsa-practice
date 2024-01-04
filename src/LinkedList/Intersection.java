package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Intersection {
    static class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static Node inputList(int size) {
        Node head, tail;
        int val;

        val = sc.nextInt();

        head = tail = new Node(val);

        size--;

        while (size-- > 0) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String args[]) {

        int t = sc.nextInt();
        while (t-- > 0) {
            int n, m;

            n = sc.nextInt();
            m = sc.nextInt();

            Node head1 = inputList(n);
            Node head2 = inputList(m);


            Node result = findIntersection(head1, head2);

            printList(result);
            System.out.println();
        }
    }

    public static Node findIntersection(Node head1, Node head2) {
        HashMap<Integer,Integer> mapper = new HashMap<Integer,Integer>();
        Node previous = null;
        Node current = head1;
        while(current != null){
            mapper.put(current.data,1);
            current = current.next;
        }
        current =head2;
        while(current != null){
            if(mapper.containsKey(current.data)){
                int value = mapper.get(current.data);
                if(value < 2){
                    Node newNode = new Node(current.data);
                    newNode.next = previous;
                    previous = newNode;
                }
                mapper.replace(current.data,value+1);
            }else{
                mapper.put(current.data,1);
            }
            current = current.next;
        }
        Node currentEle = null;
        Node nextEle = previous;

        while(nextEle != null){
            Node swapEle = nextEle.next;
            nextEle.next = currentEle;
            currentEle = nextEle;
            nextEle = swapEle;
        }
        previous = currentEle;
        return previous;
    }
}


