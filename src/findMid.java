/**
 * Created by zeqingzhang on 10/23/16.
 */
public class findMid {
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args){
        findMid f = new findMid();
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        n3.next = new ListNode(4);
        ListNode n0 = new ListNode(0);
        System.out.println(f.findMid(n0).val);
        System.out.println(f.findMid(n1).val);
    }

}
