/**
 * Created by zeqingzhang on 11/7/16.
 */
public class SortList02 {
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode mid = findMid(head);
        if(mid == null){
            return head;
        }else{
            ListNode tail = mid.next;
            mid.next = null;
            return merge(head, tail);
        }
    }

    private ListNode findMid(ListNode head){
        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }else{
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
        }

        if(l1 == null){
            node.next = l2;
        }

        if(l2 == null){
            node.next = l1;
        }

        return dummyHead.next;
    }

    public static ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...
            // head.next = n2;
            // n1.next = n2.next;
            // n2.next = n1;

            // // move to next pair
            // head = n1;
            ListNode temp = n2.next;
            n2.next = n1;
            n1.next = temp;
            head.next = n2;
            head = head.next.next;

        }

        return dummy.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next  = l2;
        l2.next = l3;
        l3.next = l4;


        System.out.println(swapPairs(l1));
    }
}
