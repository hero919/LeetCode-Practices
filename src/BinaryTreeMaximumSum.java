

/**
 * Created by zeqingzhang on 10/22/16.
 */
public class BinaryTreeMaximumSum {


    class ResultType{
        int singleSum;
        int totalSum;
        ResultType(int singleSum, int totalSum){
            this.singleSum = singleSum;
            this.totalSum = totalSum;
        }
    }

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        ResultType result = helper(root);
        return result.totalSum;


    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int singlePath = Math.max(left.singleSum , right.singleSum) + root.val;
        singlePath = Math.max(singlePath, 0);

        int totalSum = Math.max(left.totalSum, right.totalSum);
        totalSum = Math.max(totalSum , left.singleSum + right.singleSum + root.val);

        return new ResultType(singlePath, totalSum);
    }




    public static void main(String[] aegs){

    }
}
