import java.util.Arrays;

/**
 * Created by zeqingzhang on 3/2/17.
 */
public class ThreeSumSmaller {
    int count;

    public int threeSumSmaller(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }





    public static void main(String[] args){

    }
}
