/**
 * Created by zeqingzhang on 12/6/16.
 */
import java.util.*;
class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }

    public String toString(){
        return val + "";
    }

}
public class PopulatingNode {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode cur = new TreeLinkNode(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeLinkNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    cur.next = node.left;
                    cur = cur.next;
                }

                if(node.right != null){
                    queue.add(node.right);
                    cur.next = node.right;
                    cur = cur.next;
                }
                if(i == size - 1){
                    cur = new TreeLinkNode(0);
                }
            }
        }
    }

    public static void main(String[] args){
        TreeLinkNode t0 = new TreeLinkNode(0);
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        PopulatingNode p= new PopulatingNode();
        p.connect(t0);
        System.out.println(t0.next);
        System.out.println(t1.next);
        System.out.println(t2.next);
        System.out.println(t3.next);
        System.out.println(t4.next);
        System.out.println(t5.next);
        System.out.println(t6.next);

    }

}
