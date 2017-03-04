import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeqingzhang on 1/18/17.
 */
public class SumNums {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }

        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        int ans = 0;
        for(String s : result){
            ans += Integer.parseInt(s);
        }

        return ans;
    }

    private void dfs(TreeNode root, List<String> result, String s){
        if(root == null){
            return;
        }
        s = s + root.val;
        if(root.left == null && root.right == null){
            result.add(s);
            return;
        }

        dfs(root.left, result, s);
        dfs(root.right, result, s);
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t6;
        t3.right = t7;
        t7.left = t8;
        t7.right = t9;
        SumNums s = new SumNums();
        System.out.println(s.sumNumbers(t1));
    }
}
