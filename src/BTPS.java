import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 11/1/16.
 */
public class BTPS {
    public List<List<Integer>> binaryTreePathSum(TreeNode root) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> array = new ArrayList<>();
        helper(root, array, result);
        return result;
    }
    private void helper(TreeNode root,  List<Integer> array,
                        List<List<Integer>> result) {
        array.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(array));
        }

        if (root.left != null) {
            helper(root.left, array, result);
            array.remove(array.size() - 1);
        }

        if (root.right != null) {
            helper(root.right, array, result);
            array.remove(array.size() - 1);
        }
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

        BTPS b = new BTPS();
        System.out.println(b.binaryTreePathSum(t0));
    }
}
