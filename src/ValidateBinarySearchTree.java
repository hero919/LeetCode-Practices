/**
 * Created by zeqingzhang on 1/3/17.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, null, null);
    }


    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        return (min == null|| root.val > min) && (max == null || root.val < max)
                &&helper(root.left, min, root.val)&&helper(root.right, root.val, max);
    }


    public static void main(String[] args){
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t2.left = t1;
        t2.right = t4;
        t4.left = t3;
        t4.right = t5;



        ValidateBinarySearchTree v = new ValidateBinarySearchTree();
        v.isValidBST(t2);

    }
}
