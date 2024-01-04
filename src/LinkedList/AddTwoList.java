package LinkedList;

public class AddTwoList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1CurrentEle = l1;
        ListNode l2CurrentEle = l2;
        int carry =0;
        ListNode sumnode = null;
        while(l2CurrentEle != null && l1CurrentEle != null ){
            ListNode newSumnode = new ListNode(0);
            newSumnode.next = sumnode;
            sumnode = newSumnode;
            if((l2CurrentEle.val + l1CurrentEle.val + carry) >9){
                sumnode.val = (l2CurrentEle.val + l1CurrentEle.val +carry)%10;
                carry = 1;
            }else {
                sumnode.val = l2CurrentEle.val + l1CurrentEle.val +carry;
                carry = 0;
            }

            l2CurrentEle =l2CurrentEle.next;
            l1CurrentEle = l1CurrentEle.next;
        }
        ListNode currentEle1 = null;
        ListNode prevEle = null;
        if(l2CurrentEle != null){
            currentEle1 = l2CurrentEle;
        }
        if(l1CurrentEle != null){
            currentEle1 = l1CurrentEle;
        }
        while(carry==1 || currentEle1 == null ){
            if(currentEle1 == null){
                ListNode extra = new ListNode(1);
                carry =0;
                sumnode.val =0;
                sumnode.next = extra;
            }else{
                ListNode newSumnode = new ListNode(0);
                newSumnode.next = sumnode;
                sumnode = newSumnode;
                if((currentEle1.val + carry) >9){
                    sumnode.val = (currentEle1.val  +carry)%10;
                    carry = 1;

                }else{
                    sumnode.val = currentEle1.val + carry;
                    carry = 0;
                }
            }
            if(currentEle1 != null)
                currentEle1= currentEle1.next;

        }
        return sumnode;
    }
}
