/**
 * Created by zeqingzhang on 12/10/16.
 */
import java.util.*;
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }


    public static void main(String[] args){
        int[] nums = new int[]{
            1 , -1, 5 , -2 , 3
        };
        MaximumSizeSubarraySumEqualsk m = new MaximumSizeSubarraySumEqualsk();
        System.out.println(m.maxSubArrayLen(nums, 3));
    }
}
