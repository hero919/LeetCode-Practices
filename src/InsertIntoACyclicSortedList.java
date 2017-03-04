/**
 * Created by zeqingzhang on 3/3/17.
 */
public class InsertIntoACyclicSortedList {
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x <= p.val && x >= prev.val) {
                break;
            }
            if ((prev.val > p.val) && (x < p.val || x > prev.val)) {
                break;
            }
        } while (p != node);

        ListNode newNode = new ListNode(x);
        newNode.next = p;
        prev.next = newNode;
        return newNode;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(0);
        l1.next = l1;
        InsertIntoACyclicSortedList i = new InsertIntoACyclicSortedList();
        System.out.println(i.insert(l1, 1));
    }
}
