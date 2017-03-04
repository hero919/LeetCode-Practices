import java.util.Arrays;

/**
 * Created by zeqingzhang on 11/5/16.
 */
public class JumpGame02 {
    public int jump(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] tracker = new int[nums.length];
        boolean[] canJump = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            tracker[i] = Integer.MAX_VALUE;
        }
        tracker[0] = 0;
        canJump[0] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(canJump[j] && nums[j] + j >= i){
                    canJump[i] = true;
                    tracker[i] = Math.min(tracker[i], tracker[j] + 1);
                }
            }
        }

        System.out.println(Arrays.toString(canJump));
        System.out.println(Arrays.toString(tracker));
        return tracker[nums.length - 1];
    }

    public static void main(String[] args){
        JumpGame02 j = new JumpGame02();
        j.jump(new int[]{
                17,8,29,17,35,28,14,2,45,8,6,54,24,43,20,14,33,31,27,11
        });
    }
}
