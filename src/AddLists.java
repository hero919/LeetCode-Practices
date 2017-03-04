/**
 * Created by zeqingzhang on 11/7/16.
 */
public class AddLists {
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;
        int tracker = 0;
        while(l1 != null && l2 != null){
            ListNode nextNode = new ListNode(0);
            nextNode.val = (l1.val + l2.val + tracker)%10;
            if(l1.val + l2.val + tracker >= 10){
                tracker = 1;
            }
            result.next = nextNode;
        }
        while(l1 != null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }

        while(l2 != null){
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(1);
        n4.next = n5;
        n5.next = n6;


        AddLists a = new AddLists();
        System.out.println(a.addLists(n1, n4));
    }
}
