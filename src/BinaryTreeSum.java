import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 10/29/16.
 */
public class BinaryTreeSum {
    public static void helper(TreeNode t, String result, List<String> finalResult){
        if(t.left == null && t.right == null){
            finalResult.add(result + t.val);
        }
        if(t.left != null){
            helper(t.left, result + t.val + "->", finalResult);
        }

        if(t.right != null){
            helper(t.right ,  result + t.val + "->", finalResult);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> array = new ArrayList<>();
        if(root != null){
            helper(root, "" , array);
        }

        return array;
    }

    public static void main(String[] args){
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(10);
        t0.left = t1;
        t0.right = t3;
        t1.left = t2;
        t1.right = t4;
        t3.left = t5;


        System.out.println(binaryTreePaths(t0));
    }

}
