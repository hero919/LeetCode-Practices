import java.util.Arrays;

/**
 * Created by zeqingzhang on 2/12/17.
 */
public class removeDuplicates02 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Integer pre = null;
        int i = 0;
        for(int num : nums){
            while(pre != null && pre == num){
                continue;
            }
            nums[i++] = num;
            pre = num;
        }


        return i;
    }

    public static void main(String[] args){
        removeDuplicates02 r = new removeDuplicates02();
        System.out.println(r.removeDuplicates(new int[]{
                1, 1
        }));
    }

}
