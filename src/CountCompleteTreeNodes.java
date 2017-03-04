/**
 * Created by zeqingzhang on 1/7/17.
 */
public class CountCompleteTreeNodes {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }

    public static void main(String[] args){
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();
        System.out.println(c.countNodes(t0));
    }
}
