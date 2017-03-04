import java.util.Arrays;

/**
 * Created by zeqingzhang on 12/4/16.
 */
public class MaxSubArrayFinal {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] resultSet = new int[nums.length];
        resultSet[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            resultSet[i] = Math.max(resultSet[i - 1] + nums[i], nums[i]);
        }

        System.out.println(Arrays.toString(resultSet));
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < resultSet.length; i++){
            result = Math.max(resultSet[i], result);
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        };

        MaxSubArrayFinal m = new MaxSubArrayFinal();
        m.maxSubArray(input);

    }

}
