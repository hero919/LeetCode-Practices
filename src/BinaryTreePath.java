import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 11/1/16.
 */
public class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> array = new ArrayList<>();
        if(root != null){
            helper(root, "" , array);
        }

        return array;
    }


    public static void helper(TreeNode t, String result, List<String> finalResult){
        if(t.left == null && t.right == null){
            System.out.println(finalResult);
            System.out.println(t.val);
            finalResult.add(result + t.val);
        }
        if(t.left != null){
            helper(t.left, result + t.val + "->", finalResult);
        }

        if(t.right != null){
            helper(t.right ,  result + t.val + "->", finalResult);
        }
    }




    public static void main(String[] args){
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        t0.left = t1;
        t0.right = t3;
        t1.left = t2;
        t1.right = t4;
        System.out.println(binaryTreePaths(t0));
    }
}
