import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 10/29/16.
 */
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<Integer> subArray = new ArrayList<>();
        helper(root, target, result, subArray);
        return result;
    }

    private void helper(TreeNode root,
                        int target,
                        List<List<Integer>> result,
                        List<Integer> subArray){


        if(root == null){
            int sum = 0;
            for(int i = 0; i < subArray.size(); i++){
                sum += subArray.get(i);
            }
            if(sum == target){
                result.add(subArray);
            }
        }else{
            subArray.add(root.val);
            helper(root.left, target, result, subArray);
            helper(root.right, target, result, subArray);
        }
    }


    public List<List<Integer>> binaryTreePathSum02(TreeNode root, int target) {
        // Algorithm: Traverse
        // Use recursion to traverse the tree in preorder, pass with a parameter
        // `sum` as the sum of each node from root to current node.
        // Put the whole path into result if the leaf has a sum equal to target.

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, path, root.val, target, result);
        return result;
    }

    private void helper(TreeNode root,
                        ArrayList<Integer> path,
                        int sum,
                        int target,
                        List<List<Integer>> result) {

        // meet leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        // go left
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, path, sum + root.left.val, target, result);
            //path.remove(path.size() - 1);
        }

        // go right
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, path, sum + root.right.val, target, result);
            //path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args){
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(3);
        t0.left = t1;
        t0.right = t3;
        t1.left = t2;
        t1.right = t4;
        BinaryTreePathSum b = new BinaryTreePathSum();

        System.out.println(b.binaryTreePathSum02(t0, 5));
        System.out.println(t0.val);

    }
}
