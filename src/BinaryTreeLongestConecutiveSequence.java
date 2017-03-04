/**
 * Created by zeqingzhang on 1/24/17.
 */
public class BinaryTreeLongestConecutiveSequence {
    private int sum = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return sum;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }


        int temp = 0;
        int left = helper(root.left);
        int right = helper(root.right);
        boolean test = false;
        if(root.left == null && root.right == null){
            sum = Math.max(sum, 1);
            return 1;
        }

        if(root.left != null && root.val == root.left.val - 1){
            temp = left + 1;
            test = true;
        }

        if(root.right != null && root.val == root.right.val - 1){
            temp = Math.max(temp, right + 1);
            test = true;
        }
        sum = Math.max(sum, temp);
        if(test){
            return temp;
        }else{
            return 1;
        }
    }


    public static void main(String[] args){
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.right = t3;
        t3.left = t2;
        t3.right = t4;
        t4.right = t5;
        BinaryTreeLongestConecutiveSequence b = new BinaryTreeLongestConecutiveSequence();
        System.out.println(b.longestConsecutive(t5));
    }
}
