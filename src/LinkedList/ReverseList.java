package LinkedList;
/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

 */

public class ReverseList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseList(ListNode head) {

        ListNode currentEle = null;
        ListNode nextEle = head;

        while(nextEle != null){
            ListNode swapEle = nextEle.next;
            nextEle.next = currentEle;
            currentEle = nextEle;
            nextEle = swapEle;
        }
        head = currentEle;
        return head;
    }
}
