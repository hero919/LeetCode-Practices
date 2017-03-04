/**
 * Created by zeqingzhang on 10/23/16.
 */
public class convertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head.next;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        if(slow.next != null){
            thead.right = toBST(slow.next,tail);
        }else{
            thead.right = null;
        }

        return thead;
    }

    public static void main(String[] args){
        convertSortedListToBST c1 = new convertSortedListToBST();
        ListNode n1 = new ListNode(0);
        c1.sortedListToBST(n1);
    }
}
