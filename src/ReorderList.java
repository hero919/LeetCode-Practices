import java.util.List;

/**
 * Created by zeqingzhang on 11/9/16.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // write your code here
        if(head == null){
            return;
        }

         ListNode h = head;
        ListNode slow = h;
        ListNode fast = h.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        System.out.println("h is: " + h);
        System.out.println("tail is: " + tail);
        ListNode rev = reverse(tail);
        merge(h, rev);

    }


    private ListNode reverse(ListNode n){
        if(n == null){
            return null;
        }

        ListNode pre = null;
        while(n != null){
            ListNode temp = n.next;
            n.next = pre;
            pre = n;
            n = temp;
        }
        return pre;
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
        int counter = 0;
        while(l1 != null && l2 != null){
            if(counter%2 == 0){
                node.next = l1;
                l1 = l1.next;
                node = node.next;
                counter++;
            }else{
                node.next = l2;
                l2 = l2.next;
                node = node.next;
                counter++;
            }
        }

        if(l1 == null){
            node.next = l2;
        }else{
            node.next = l1;
        }

        System.out.println(dummyHead.next);
        return dummyHead.next;

    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(-1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        int m = 2;
        for (int i = 1; i < m; i++) {
            l1 = l1.next;
        }
        System.out.println(l1);

    }



}
