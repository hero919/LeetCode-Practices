/**
 * Created by zeqingzhang on 11/17/16.
 */
public class BSTMinPath {
    int findMinPath(TreeNode root){
        if(root == null){
            return 0;
        }
        return helper(root);
    }


    private int helper(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        return Math.min(root.val + Math.min(left, 0), root.val + Math.min(right, 0));
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(-50);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        BSTMinPath b = new BSTMinPath();
        System.out.println(b.findMinPath(t1));
    }
}
