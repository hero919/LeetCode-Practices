/**
 * Created by zeqingzhang on 1/4/17.
 */
public class TweakedIdentical {
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        return isIdentical(a, b) || isTweaked(a, b);
    }


    private boolean isIdentical(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }

        if(a == null || b == null){
            return false;
        }

        return a.val == b.val && isIdentical(a.left, b.left) &&
                isIdentical(a.right, b.right);
    }


    private boolean isTweaked(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }

        if(a == null || b == null){
            return false;
        }

        return a.val == b.val && isTweaked(a.left, b.right) &&
                isTweaked(a.right, b.left);
    }

}
