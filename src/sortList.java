/**
 * Created by zeqingzhang on 10/24/16.
 */
public class sortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        System.out.println("Left Node is: " + left);
        System.out.println("Right Node is: " + right);
        return Merge(left , right);
    }



    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode Merge(ListNode n1, ListNode n2){
        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;
        if(n1 == null){
            return n2;
        }
        if(n2 == null){
            return n1;
        }

        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                node.next = n1;
                n1 = n1.next;
            }else{
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if(n1 == null){
            node.next = n2;
        }else{
            node.next = n1;
        }

        return dummyHead.next;
    }


    public static void main(String[] args){
        sortList s = new sortList();
        ListNode n0 = new ListNode(5);
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(s.sortList(n0));
        System.out.println();
    }
}
