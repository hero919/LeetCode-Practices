/**
 * Created by zeqingzhang on 11/26/16.
 */
import java.util.*;

public class CompanyTree02 {

    static class average{
        int num;
        double hours;
        average(int num, double hours) {
            this.num = num;
            this.hours = hours;
        }
    }

    private static Node result;
    private static double hours = Integer.MIN_VALUE;
    public static Node getHighAve(Node root){
        if(root == null){
            return null;
        }
        dfs(root);
        return result;
    }


    private static average dfs(Node root){
        if(root.children == null || root.children.size() == 0){
            return new average(1, root.val);
        }

        double curValue = root.val;
        int curCount = 1;
        for(Node node : root.children){
            average a = dfs(node);
            curCount += a.num;
            curValue += a.hours;
        }
        double ave = curValue/curCount;
        if(ave > hours){
            hours = ave;
            result = root;
        }
        return new average(curCount, curValue);
    }








    public static void main(String[] args){
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        System.out.println("The root is: " + getHighAve(root).val + " The max average is: " + hours);
    }
}
