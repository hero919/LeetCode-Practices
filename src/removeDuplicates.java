import java.util.Arrays;

/**
 * Created by zeqingzhang on 12/17/16.
 */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        long temp = Integer.MIN_VALUE - 1;
        int k = nums.length - 1;
        int result = nums.length;
        for(int i = nums.length -1; i >= 0; i--){
            if(temp == nums[i]){
                result--;
                continue;
            }
            nums[k] = nums[i];
            temp = nums[k];
            k--;
        }
        //System.out.println("nums is " + Arrays.toString(nums));
        //System.out.println(result);
        for(int j = 0; j < result; j++){
            nums[j] = nums[nums.length - result + j];

        }
        return result;
    }


    public int removeDuplicates03(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args){
        removeDuplicates r = new removeDuplicates();
        int[] input = new int[]{
                1,2,3
        };
        System.out.println(r.removeDuplicates03(input));
        //System.out.println(Arrays.toString(input));

    }
}
