/**
 * Created by zeqingzhang on 11/7/16.
 */
public class deleteDup {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(-999);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode curr = dummyHead.next;
        while(curr != null){
            if(curr.val == pre.val){
                curr = curr.next;
                pre.next = curr;
            }else{
                pre = curr;
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args){
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        System.out.println(deleteDuplicates(n0));
    }
}
