/**
 * Created by zeqingzhang on 1/5/17.
 */
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode dummyHead = new TreeNode(0);
        TreeNode head = dummyHead.left;
        helper(head, nums, 0, nums.length - 1);
        return dummyHead.left;
    }


    private TreeNode helper(TreeNode head, int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        head = new TreeNode(nums[mid]);
        head.left = helper(head.left,nums, start, mid - 1);
        head.right = helper(head.right,nums, mid + 1, end);
        return head;
    }

}
