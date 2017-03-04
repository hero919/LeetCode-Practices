/**
 * Created by zeqingzhang on 1/14/17.
 */
public class reverseBetween02 {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if(head == null){
            return null;
        }

        if(m >= n){
            return head;
        }


        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode node = dummyHead;
        for(int i = 1; i < m; i++){
            if(node == null){
                return null;
            }
            node = node.next;
        }

        ListNode premNode = node;
        ListNode mNode = node.next;
        ListNode nNode = mNode;
        ListNode postnNode = nNode.next;
        for(int i = 0; i < n - m; i++){
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        System.out.println(postnNode.val);
        mNode.next = postnNode;
        premNode.next = nNode;
        return dummyHead.next;
    }


    public static void main(String[] args){
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        reverseBetween02 r = new reverseBetween02();
        System.out.println(n5);
        System.out.println(r.reverseBetween(n5, 2, 4));
    }
}
