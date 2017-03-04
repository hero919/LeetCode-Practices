/**
 * Created by zeqingzhang on 2/19/17.
 */
public class LowestCommonAncestorIII {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null){
            return result;
        }

        helper(root, A, B);
        return result;
    }


    private TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null || root == A || root == B){
            return root;
        }
        TreeNode left = lowestCommonAncestor3(root.left, A, B);
        TreeNode right = lowestCommonAncestor3(root.right, A, B);

        if(left != null && right != null){
            result = root;
            return result;
        }

        if(left != null){
            return left;
        }

        if(right != null){
            return right;
        }

        return null;
    }
}
