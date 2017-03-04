/**
 * Created by zeqingzhang on 10/23/16.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }

    @Override
    public String toString(){
        String result = "";
        ListNode copy = this;
        while(copy != null){
            result += copy.val + "->";
            copy = copy.next;
        }
        return result;
    }
}
