/**
 * Created by zeqingzhang on 2/19/17.
 */
public class MinimumSubtree {
    TreeNode result = null;
    int sum = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if(root == null){
            return root;
        }

        helper(root);
        return result;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int total = root.val + left + right;
        if(total < sum){
            result = root;
            sum = total;
        }
        return total;
    }

}
