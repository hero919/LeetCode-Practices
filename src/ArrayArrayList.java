import java.util.*;

/**
 * Created by zeqingzhang on 3/2/17.
 */
public class ArrayArrayList {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        int left = 0;
        int right = nums.length -1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                result[0] = left;
                result[1] = right;
                return result;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }
    public static void main(String[] args){
       ArrayArrayList a = new ArrayArrayList();
        System.out.println(Arrays.toString(a.twoSum(new int[]{3, 2, 4}, 6)));

    }
}
