import java.util.HashMap;

/**
 * Created by zeqingzhang on 11/12/16.
 */

class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     };
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        //Copy next;
        while(node != null){
            if(map.containsKey(node)){
                break;
            }else{
                RandomListNode newNode = new RandomListNode(node.label);
                map.put(node, newNode);
                node = node.next;
            }
        }


        //Copy random
        node = head;
        while(node != null){
            if(map.get(node).random == null){
                RandomListNode newNode = map.get(node);
                newNode.random = map.get(node).random;
                node = node.random;
            }else{
                break;
            }
        }

        return map.get(head);
    }

    public static RandomListNode copyRandomList02(RandomListNode head) {
        if(head == null)
            return head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head,newHead);
        RandomListNode pre = newHead;
        RandomListNode node = head.next;
        while(node!=null)
        {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node,newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        RandomListNode copyNode = newHead;
        while(node!=null)
        {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }

    public static RandomListNode copyRandomList03(RandomListNode head) {
        // write your code here
        if(head == null){
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy, newNode;
        RandomListNode node = head;
        while (node != null) {
            if (map.containsKey(node)) {
                newNode = map.get(node);
            } else {
                newNode = new RandomListNode(node.label);
                map.put(node, newNode);
            }
            pre.next = newNode;
            pre = pre.next;
            node = node.next;
        }

        node = head;

        while(node != null){
            newNode = map.get(node);
            if (node.random != null) {
                if (map.containsKey(node.random)) {
                    newNode.random = map.get(node.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }

            }
            node = node.next;
        }

        return dummy.next;



    }


    public static void main(String[] args){
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        r1.next = r2;
        r2.next = r3;
        r3.next = r2;

        RandomListNode r4 = new RandomListNode(-1);
        copyRandomList03(r4);
    }
}
