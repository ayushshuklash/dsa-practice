package LinkedList;

import java.util.HashSet;

/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesSortedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode RemoveDuplicatesSorted(ListNode head) {
            HashSet<Integer> a = new HashSet<Integer>();
            if (head == null || head.next == null) {
                return head;
            }
            a.add(head.val);
            ListNode nextEle = head.next;
            ListNode prevEle = head;
            while (nextEle != null) {
                if (a.contains(nextEle.val)) {
                    prevEle.next = nextEle.next;
                } else {
                    a.add(nextEle.val);
                    prevEle = nextEle;
                }
                nextEle = nextEle.next;

            }
            return head;
        }
    }
}
