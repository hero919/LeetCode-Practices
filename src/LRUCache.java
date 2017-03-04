import java.util.HashMap;
import java.util.List;

/**
 * Created by zeqingzhang on 1/14/17.
 */
public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

    }


    private Node head = new Node();
    private Node tail = new Node();
    private int capacity;
    private int size;
    private HashMap<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
        size = 0;

    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if(map.containsKey(key)){
            int result = map.get(key).value;
            move_to_tail(map.get(key));
            return result;
        }else{
            return -1;
        }

    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if( get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }

    }



    public void move_to_tail(Node current){
        Node pre = current.pre;
        Node next = current.next;
        Node tailPre = tail.pre;
        pre.next = next;
        next.pre = pre;
        current.pre = tailPre;
        current.next = tail;
    }

    public static void main(String[] args){


    }

}
