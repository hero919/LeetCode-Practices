/**
 * Created by zeqingzhang on 11/25/16.
 */
public class TreeAmplitude {
    public int Solution(TreeNode root) {
        if (root == null)   return 0;
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode root, int min, int max) {
        if (root == null)   return max - min;

        if (root.val < min) min = root.val;
        if (root.val > max) max = root.val;

        return Math.max(helper(root.left, min, max), helper(root.right, min, max));
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        t3.left = t7;
        t3.right = t8;
        TreeAmplitude t = new TreeAmplitude();
        System.out.println(t.Solution(t1));
    }

}
