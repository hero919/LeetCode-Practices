import java.util.Stack;

/**
 * Created by zeqingzhang on 2/19/17.
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        // write your code here
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            if(top.right != null){
                stack.push(top.right);
            }

            if(top.left != null){
                stack.push(top.left);
            }

            if(!stack.isEmpty()){
                top.left = null;
                top.right = stack.peek();
            }
        }
    }


}
