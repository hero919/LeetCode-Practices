/**
 * Created by zeqingzhang on 11/13/16.
 */
public class BinaryTreeMaxPathSum {

    public int maxPathSum(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }


    private int traverseToBottom(TreeNode root, int sum) {
        return 0;
    }

    public static void main(String[] args){
        TreeNode t0 = new TreeNode(-1);
        TreeNode t1 = new TreeNode(-3);
        TreeNode t2 = new TreeNode(-7);
        t0.left = t1;
        t0.right = t2;
        BinaryTreeMaxPathSum b = new BinaryTreeMaxPathSum();
        System.out.println(b.maxPathSum(t0));

    }

}
