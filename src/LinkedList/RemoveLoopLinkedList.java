package LinkedList;

import java.util.HashSet;

/*
Given a linked list of N nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present.


Example 1:

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|
A loop is present. If you remove it
successfully, the answer will be 1.

Example 2:

Input:
N = 4
value[] = {1,8,3,4}
X = 0
Output: 1
Explanation: The Linked list does not
contains any loop.

Example 3:

Input:
N = 4
value[] = {1,2,3,4}
X = 1
Output: 1
Explanation: The link list looks like
1 -> 2 -> 3 -> 4
     |_________|
A loop is present.
If you remove it successfully,
the answer will be 1.
 */
public class RemoveLoopLinkedList {
    class Node
    {
        int data;
        Node next;
    }

    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        HashSet<Node> a = new HashSet<Node>();
        if(head == null || head.next == null){
            return;
        }
        a.add(head);
        Node nextEle = head.next;
        Node prevEle = head;
        while(nextEle != null){
            if(a.contains(nextEle)){
                prevEle.next = null;
                return;
            }else{
                a.add(nextEle);
            }
            prevEle = nextEle;
            nextEle = nextEle.next;

        }
        return;
    }

}
