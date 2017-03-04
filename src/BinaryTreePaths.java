import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 2/19/17.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        String path = root.val + "";
        helper(root, result, path);
        return result;
    }


    private void helper(TreeNode root, List<String> result, String path){
        if(root.left == null && root.right == null){
            //path += "->" + root.val;
            result.add(path);
            return;
        }

        if(root.left != null && root.right != null){
            helper(root.left, result, path + "->" + root.left.val);
            helper(root.right, result, path + "->" + root.right.val);
            return;
        }

        if(root.left != null){
            helper(root.left, result, path + "->" + root.left.val);
            return;
        }

        helper(root.right, result, path + "->" + root.right.val);
    }

}
