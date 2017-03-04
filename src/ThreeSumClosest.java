import java.util.Arrays;

/**
 * Created by zeqingzhang on 12/6/16.
 */
public class ThreeSumClosest {


        public int threeSumClosest(int[] nums, int target) {
            if(nums == null || nums.length == 0 || nums.length < 3){
                return 0;
            }
            Arrays.sort(nums);
            int length = nums.length;
            int result = nums[0] + nums[1] + nums[2];
            for(int i = 0; i < length - 2; i++){
                int j = i + 1;
                int k = length - 1;
                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == target){
                        return sum;
                    }
                    if(sum - target > 0){
                        if(Math.abs(sum - target) < Math.abs(target - result)){
                            result = sum;
                        }
                        k--;
                    }else if(sum - target < 0){
                        if(Math.abs(sum - target) < Math.abs(target - result)){
                            result = sum;
                        }
                        j++;
                    }
                }
            }
            return result;
        }


    public static void main(String[] args){
        int[] input = new int[]{
                -3 , -2, -5, 3, -4
        };
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(input, -1));
    }
}
