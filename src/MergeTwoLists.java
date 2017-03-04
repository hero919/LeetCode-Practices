/**
 * Created by zeqingzhang on 11/6/16.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            }else{
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }

        if(l1 != null){
            node.next = l1;
        }

        if(l2 != null){
            node.next = l2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args){
        //1->3->8->11->15->null, 2->null
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(11);
        ListNode n5 = new ListNode(15);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n6 = new ListNode(2);

        MergeTwoLists m = new MergeTwoLists();

        System.out.println(m.mergeTwoLists(n1 , n6));


    }
}
