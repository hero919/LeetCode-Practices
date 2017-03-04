import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zeqingzhang on 1/13/17.
 */
public class MergeK {
    class Comp implements Comparator<ListNode> {
        @Override
        public int compare(ListNode l1, ListNode l2){
            return l1.val - l2.val;
        }

    }

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        Queue<ListNode> queue = new PriorityQueue<>(lists.size(), new Comp());
        for(ListNode n : lists){
            queue.add(n);
        }

        while(!queue.isEmpty()){
            ListNode top = queue.poll();
            dummyHead.next = top;
            top = top.next;
            dummyHead = dummyHead.next;
            if(top != null){
                queue.add(top);
            }
        }
        return dummyHead.next;
    }
}
