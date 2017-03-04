import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeqingzhang on 11/2/16.
 */
public class ThreeSum02 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }



        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int sum = 0;
            sum = sum - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int subsum = nums[start] + nums[end];
                if(subsum == sum){
                    ArrayList<Integer> array =
                            new ArrayList<Integer>();
                    array.add(nums[i]);
                    array.add(nums[start]);
                    array.add(nums[end]);
                    result.add(array);
                    start++;
                }else if(subsum > sum){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return result;
    }



    public static void main(String[] args){
        ThreeSum02 t = new ThreeSum02();
        System.out.println(t.threeSum(new int[]{-1, 1, 0}));

    }
}
