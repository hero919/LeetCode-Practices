/**
 * Created by zeqingzhang on 1/13/17.
 */
public class reorder {
    public ListNode reorderList(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }

        ListNode h = head;
        ListNode reversedNode = reverse(head);
        ListNode result = mergeTwoLists(h, reversedNode);
        return result;
    }


    private ListNode reverse(ListNode list){
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


    private ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        while(list1 != null && list2 != null){
            node.next = list1;
            list1 = list1.next;
            node = node.next;

            node.next = list2;
            list2 = list2.next;
            node = node.next;
        }

        return dummyHead.next;
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

        reorder r = new reorder();

        //System.out.println(r.reverse(l1));



        System.out.println(r.reorderList(l1));


    }


}
