/**
 * Created by zeqingzhang on 2/19/17.
 */
public class BinaryTreeLongestConsecutiveSequence {
    int result = 1;

//    class ResultType{
//        TreeNode node;
//        int sum;
//        ResultType(TreeNode node, int sum) {
//            this.node = node;
//            this.sum = sum;
//        }
//    }

    public int longestConsecutive(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
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

        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left != null && root.right != null && (root.val == left - 1 || root.val == right - 1)){
            int returnValue =  Math.max(left + 1, right + 1);
            result = Math.max(returnValue, result);
            return returnValue;
        }

        if(root.right != null && root.right.val - 1 == root.val){
            result = Math.max(right + 1, result);
            return right + 1;
        }

        if(root.left != null && root.left.val - 1 == root.val){
            result = Math.max(left + 1, result);
            return left + 1;
        }


        return 1;
    }


}
