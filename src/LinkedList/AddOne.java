package LinkedList;

import java.io.IOException;
import java.util.Scanner;

/*
Add 1 to a number represented as linked list
EasyAccuracy: 51.33%Submissions: 100k+Points: 2
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457
Example 2:

Input:
LinkedList: 1->2->3
Output: 124
Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 101000
 */
public class AddOne {
    static class Node
    {
        int data;
        Node next;

        Node(int x)
        {
            data = x;
            next = null;
        }
    }
        public static void printList(Node node)
        {
            while (node != null)
            {
                System.out.print(node.data);
                node = node.next;
            }
            System.out.println();
        }
        public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                String s = sc.next();
                Node head = new Node( s.charAt(0) - '0' );
                Node tail = head;
                for(int i=1; i<s.length(); i++)
                {
                    tail.next = new Node( s.charAt(i) - '0' );
                    tail = tail.next;
                }
                Solution obj = new Solution();
                head = obj.addOnelink(head);
                printList(head);
            }
        }


    static class Solution {
        public static Node addOnelink(Node head) {
            Node currentEle = null;
            Node nextEle = head;
            Node prevEle = null;
            while(nextEle != null){
                Node swapEle = nextEle.next;
                nextEle.next = currentEle;
                currentEle = nextEle;
                nextEle = swapEle;
            }
            head = currentEle;
            int carry = 0;
            if(head.data ==9){
                carry=1;
                head.data = 0;
            }else{
                head.data = head.data+1;
            }
            while(carry==1){
                prevEle = currentEle;
                currentEle= currentEle.next;
                if(currentEle == null){
                    Node extra = new Node(1);
                    carry =0;
                    prevEle.data =0;
                    prevEle.next = extra;
                }else{
                    if(currentEle.data ==9){
                        currentEle.data =0;
                        carry =1;
                    }else{
                        currentEle.data = currentEle.data+1;
                        carry =0;
                    }
                }
            }
            currentEle = null;
            nextEle = head;
            prevEle = null;
            while(nextEle != null){
                Node swapEle = nextEle.next;
                nextEle.next = currentEle;
                currentEle = nextEle;
                nextEle = swapEle;
            }
            return currentEle;
        }
    }
}
