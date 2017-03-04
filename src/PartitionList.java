/**
 * Created by zeqingzhang on 11/21/16.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null){
            return null;
        }

        ListNode smaller = new ListNode(0);
        ListNode sHead = smaller;
        ListNode bigger = new ListNode(0);
        ListNode bHead = bigger;
        while(head != null){
            if(head.val >= x){
                bigger.next = head;
                bigger = bigger.next;
                head = head.next;
            }else{
                smaller.next = head;
                smaller = smaller.next;
                head = head.next;
            }
        }

        bigger.next = null;
        smaller.next = bHead.next;


        return sHead.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        PartitionList p = new PartitionList();
        System.out.println(p.partition(n1, 0));

    }
}
