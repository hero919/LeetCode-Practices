import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by zeqingzhang on 11/6/16.
 */
public class MergeKSortedLists {
    class comp implements Comparator<ListNode>{
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
        ListNode head = dummyHead;

        Queue<ListNode> queue = new PriorityQueue<>(new comp());
        for(ListNode l : lists){
            queue.add(l);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node == null){
                continue;
            }
            head.next = node;
            node = node.next;
            if(node != null){
                queue.add(node);
            }
            head = head.next;
        }
        return dummyHead.next;
    }

    public ListNode mergeKLists02(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }

        };
        Queue<ListNode> queue = new PriorityQueue<ListNode>(comparator);
        for(ListNode l : lists){
            if(l != null) {
                queue.add(l);
            }
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node == null){
                continue;
            }
            head.next = node;
            node = node.next;
            if(node != null){
                queue.add(node);
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
