/**
 * Created by zeqingzhang on 1/13/17.
 */
public class reverseLinkedList {
    private static ListNode reverse(ListNode list){
        if(list == null){
            return null;
        }
        ListNode pre = null;
        while(list != null){
            ListNode temp = list.next;
            list.next = pre;
            pre = list;
            list = temp;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(l1);
        System.out.println(reverse(l1));
    }
}
