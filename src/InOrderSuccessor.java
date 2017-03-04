import java.util.Stack;

/**
 * Created by zeqingzhang on 11/2/16.
 */
public class InOrderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }

        if(root == p){
            return root.right;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(curr == p){
                if(curr.right != null){
                    return curr.right;
                }else{
                    return stack.pop();
                }
            }
            curr = curr.right;
        }
        return null;
    }
    public static void main(String[] args){
        TreeNode t0 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t0.left = t1;
        InOrderSuccessor i = new InOrderSuccessor();
        System.out.println(i.inorderSuccessor(t0, t1));


    }
}
